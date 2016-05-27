package com.example.edgarvaldivia.xprestamosgingerbread;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VentanaPrestamos extends AppCompatActivity {
    ListView lista;
    private MediaPlayer oki,noni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_prestamos);
        oki = MediaPlayer.create(VentanaPrestamos.this, R.raw.positivesound);
        noni = MediaPlayer.create(VentanaPrestamos.this, R.raw.negativesound);
        lista = (ListView) findViewById(R.id.listaV);
        cargarlaLista();
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                presionmuchotiempo();
                return false;
            }
        });
    }

    public void cargarlaLista(){
        Conexion X = new Conexion(this,"AdministracionDePrestamos",null,1);
        SQLiteDatabase db = X.getReadableDatabase();
        if(db!=null){
            Cursor cux = db.rawQuery("select * from Prestamos",null);
            int cantidad = cux.getCount();
            int k=0;
            String[] arr = new String[cantidad];
            if(cux.moveToFirst()){
                do {
                    String linea = cux.getInt(0)+""+cux.getString(1)+""+cux.getString(2);
                    arr[k] = linea;
                    k++;
                }while(cux.moveToNext());
            }

            ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
            ListView lista = (ListView) findViewById(R.id.listaV);
            lista.setAdapter(adapter);
        }
    }


  public void presionmuchotiempo() {
      AlertDialog.Builder builder = new AlertDialog.Builder(this);
      builder.setMessage("Ya Te Devolcieron Tu Articulo?")
              .setTitle("CONFIRMAR")
              .setCancelable(false).setIcon(R.drawable.amarillo)
              .setNegativeButton("Aun NO!",
                      new DialogInterface.OnClickListener() {
                          public void onClick(DialogInterface dialog, int id) {
                              noni.start();
                              dialog.cancel();
                          }
                      }).setPositiveButton("Si Apenas",
              new DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface dialog, int id) {
                     oki.start();
                  }
              });
      AlertDialog alert = builder.create();
      alert.show();
  }

/*NO ME MUESTRA UN CLICK ITEM SIMPLE VER PORQUE?
    public void info(){
      AlertDialog.Builder infox = new AlertDialog.Builder(this);
      infox.setTitle("Info Prestamos")
              .setIcon(R.drawable.infoicono)
              .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface dialog, int id) {
                      clickdonkey.start();
                  }
              });
  }
*/
}
