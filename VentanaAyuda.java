package com.example.edgarvaldivia.xprestamosgingerbread;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VentanaAyuda extends AppCompatActivity {
    Button tutorial;
    private MediaPlayer mpay,mtut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_ayuda);
        mpay = MediaPlayer.create(VentanaAyuda.this,R.raw.ayudarrr);
        mpay.start();


        tutorial = (Button) findViewById(R.id.btnTutorial);
        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTutorial();
                mtut = MediaPlayer.create(VentanaAyuda.this,R.raw.wowcaman);
                mtut.start();

            }
        });
    }//onCreate

    public void abrirTutorial(){
        Intent tut = new Intent(this,TutorialUso.class);
        startActivity(tut);
    }

}
