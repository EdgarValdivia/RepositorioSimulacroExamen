package com.example.edgarvaldivia.xprestamos;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VentanaAyuda extends AppCompatActivity {

    private MediaPlayer mpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_ayuda);
        mpay = MediaPlayer.create(VentanaAyuda.this,R.raw.ayudarrr);
        mpay.start();
    }
}
