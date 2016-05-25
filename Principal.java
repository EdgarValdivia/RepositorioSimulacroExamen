package com.example.edgarvaldivia.xprestamosgingerbread;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {
    Button prestar,prestamos,ayuda,acerca;

    private MediaPlayer mpPRIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        prestar = (Button) findViewById(R.id.btnPrestar);
        prestamos = (Button) findViewById(R.id.btnPrestamos);
        ayuda = (Button) findViewById(R.id.btnAyuda);
        acerca = (Button) findViewById(R.id.btnAcerca);


        prestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirVentanaPrestar();
                mpPRIN = MediaPlayer.create(Principal.this,R.raw.principalrrr);
                mpPRIN.start();
            }
        });
        prestamos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirVentanaPrestamos();
                mpPRIN = MediaPlayer.create(Principal.this,R.raw.principalrrr);
                mpPRIN.start();
            }
        });
        ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirVentanaAyuda();
                mpPRIN = MediaPlayer.create(Principal.this,R.raw.principalrrr);
                mpPRIN.start();
            }
        });
        acerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirVentanaAcerca();
                mpPRIN = MediaPlayer.create(Principal.this,R.raw.principalrrr);
                mpPRIN.start();
            }
        });
    }



    public void abrirVentanaPrestar(){
        Intent var1 = new Intent(this,VentanaPrestar.class);
        startActivity(var1);
    }
    public void abrirVentanaPrestamos(){
        Intent var2 = new Intent(this,VentanaPrestamos.class);
        startActivity(var2);
    }
    public void abrirVentanaAyuda(){
        Intent var3 = new Intent(this,VentanaAyuda.class);
        startActivity(var3);
    }
    public void abrirVentanaAcerca(){
        Intent var4 = new Intent(this,VentanaAcerca.class);
        startActivity(var4);
    }

}
