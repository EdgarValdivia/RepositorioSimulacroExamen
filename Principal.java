package com.example.edgarvaldivia.xprestamos;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {
      Button prestar,prestamos,ayuda,acerca;

    private MediaPlayer mp;

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
                mp = MediaPlayer.create(Principal.this,R.raw.principalrrr);
                mp.start();
            }
        });
        prestamos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirVentanaPrestamos();
                mp = MediaPlayer.create(Principal.this,R.raw.principalrrr);
                mp.start();
            }
        });
        ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirVentanaAyuda();
                mp = MediaPlayer.create(Principal.this,R.raw.principalrrr);
                mp.start();
            }
        });
        acerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirVentanaAcerca();
                mp = MediaPlayer.create(Principal.this,R.raw.principalrrr);
                mp.start();
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
