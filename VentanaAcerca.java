package com.example.edgarvaldivia.xprestamosgingerbread;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VentanaAcerca extends AppCompatActivity {

    private MediaPlayer mpac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_acerca);
        mpac = MediaPlayer.create(VentanaAcerca.this,R.raw.acercarrr);
        mpac.start();
    }
}
