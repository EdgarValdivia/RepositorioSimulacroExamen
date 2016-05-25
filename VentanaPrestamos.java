package com.example.edgarvaldivia.xprestamosgingerbread;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VentanaPrestamos extends AppCompatActivity {
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_prestamos);
        lista = (ListView) findViewById(R.id.listaV);
        cargarlaLista();
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return super.onKeyLongPress(keyCode, event);
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


}
