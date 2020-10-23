package com.example.blais_piteau_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AccueilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanteState){
        super.onCreate(saveInstanteState);
        setContentView(R.layout.main_activity);

        final EditText pseudoText = (EditText) findViewById(R.id.pseudo);


        findViewById(R.id.Jouer).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (pseudoText.length()==0) {
                    pseudoText.setError("Vous devez entrer un pseudo");
                } else {
                    startActivity(new Intent(AccueilActivity.this, MainGameActivity.class));
                }
            }
        });

        findViewById(R.id.Settings).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(AccueilActivity.this, SettingsActivity.class));
            }
        });


        findViewById(R.id.stats).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(AccueilActivity.this, StatsActivity.class));
            }
        });

        findViewById(R.id.Quitter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}
