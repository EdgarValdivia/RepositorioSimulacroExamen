package com.example.edgarvaldivia.xprestamos;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VentanaPrestar extends AppCompatActivity {
    Button hecho;

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_prestar);


        hecho = (Button) findViewById(R.id.btnHecho);
        hecho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(VentanaPrestar.this,R.raw.hechorrr);
                mp.start();
                funcionHecho();
            }
        });
    }


    public void funcionHecho(){
        finish();
    }
}
