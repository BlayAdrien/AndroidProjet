package com.example.blais_piteau_android;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class LoadActivity extends AppCompatActivity {

    public final int TEMPS = 3000;

    @Override
    protected void onCreate(Bundle saveInstanteState) {
        super.onCreate(saveInstanteState);
        setContentView(R.layout.load_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadActivity.this, AccueilActivity.class);
                startActivity(intent);
                finish();
            }
        }, TEMPS);
    }
}
