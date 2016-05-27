package com.example.edgarvaldivia.xprestamosgingerbread;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class VentanaAcerca extends AppCompatActivity {
    ImageButton tec;
    private MediaPlayer mpac,logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_acerca);
        mpac = MediaPlayer.create(VentanaAcerca.this,R.raw.acercarrr);
        mpac.start();

        tec = (ImageButton) findViewById(R.id.imagendemonio);
        tec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logo = MediaPlayer.create(VentanaAcerca.this, R.raw.bdgtigresmini);
                logo.start();
                finish();
            }
        });
    }



}
