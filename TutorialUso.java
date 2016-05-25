package com.example.edgarvaldivia.xprestamosgingerbread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TutorialUso extends AppCompatActivity {
    Button entendido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_uso);


        entendido = (Button) findViewById(R.id.btnEntendido);
        entendido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finTutorial();
            }
        });
    }


    public void finTutorial(){
        finish();
    }

}
