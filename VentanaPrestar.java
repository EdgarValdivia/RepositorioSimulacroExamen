package com.example.edgarvaldivia.xprestamosgingerbread;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class VentanaPrestar extends AppCompatActivity {

    EditText articulo,persona;

    Conexion superbase;

    Button hecho;
    private MediaPlayer mpHCH;

    Spinner categoSpin;


    String[] datosSpin = {"                 LIBROS Y/O REVISTAS",
            "            ARTICULOS ELECTRONICOS",
            "               ARTICULOS ESCOLARES",
            "                         DINERO  $",
            "                          PRENDAS",
            "                           JOYERIA",
            "                             ECT"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_prestar);


        superbase = new Conexion(this,"AdministracionDePrestamos",null,1);


        categoSpin = (Spinner)findViewById(R.id.spCategorias);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datosSpin);
        categoSpin.setAdapter(adaptador);



        articulo = (EditText) findViewById(R.id.txtNombreArticulo);
        persona = (EditText) findViewById(R.id.txtNombrePersona);
        hecho = (Button) findViewById(R.id.btnHecho);
        hecho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarDatosMetodo();
                mpHCH = MediaPlayer.create(VentanaPrestar.this,R.raw.hechorrr);
                mpHCH.start();

                funcionHecho();

            }
        });

    }


    public void insertarDatosMetodo(){

        boolean respuesta = vacios();
        if(respuesta == false){
            Toast.makeText(this, "Error Hay Algun Campo Vacio!",Toast.LENGTH_LONG).show();
            return;
        }

        try{
            SQLiteDatabase base = superbase.getWritableDatabase();
            String akn = "  a";
            String SQL = "INSERT INTO PRESTAMOS(Articulo,Persona) VALUES('      "+articulo.getText().toString()+akn+" ',' "+persona.getText().toString()+" ')";
            base.execSQL(SQL);
            /*correcto();*/
            Toast.makeText(this, "BUENA SUERTE, ESPERO Y TE REGRESEN TU ARTICULO"+"\n"+"REGISTRO EXITOSO!!!",Toast.LENGTH_LONG).show();
            base.close();
            articulo.setText("");
            persona.setText("");
        }
        catch(SQLException e){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("NO SE GUARDO EL REGISTRO!").setMessage(e.getMessage()).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        }
    }

    public void funcionHecho(){
        finish();
    }

    private boolean vacios(){
       if(articulo.length()==0 || articulo.getText().toString().equals("")) return false;
          else if (persona.length()==0 || persona.getText().toString().equals("")) return false;
        return true;
    }
}

/*TEXTVIEW Y SPINER QUE ELIMINAMOS DEL ACTIVITY PRESTAR POR MOTIVOS DE PROGRAMACION SUPER INTENSA*/

/*
       <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="CATEGORIA DEL ARTICULO"
            android:id="@+id/textView"
            android:layout_gravity="center_horizontal"
            android:textColor="#2778b6"
            android:textSize="20dp"
            android:textStyle="bold" />

        <Spinner
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/spCategorias"
            android:textColor="#2778b6"
            android:textStyle="bold"
            android:textSize="20dp"
            android:background="#634db914"
            android:clickable="true"
            style="@style/AppTheme" />
*/
