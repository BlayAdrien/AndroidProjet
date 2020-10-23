package com.example.blais_piteau_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.blais_piteau_android.modele.Constantes;
import com.example.blais_piteau_android.modele.Statistic.AbstractStatistic;
import com.example.blais_piteau_android.modele.Statistic.Statistic;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        AbstractStatistic statistic = new Statistic(this);

        TextView score = (TextView) findViewById(R.id.score);
        TextView bestScore = (TextView) findViewById(R.id.best_score);

        int scoreFin = getIntent().getIntExtra(Constantes.SCORE_MESSAGE, 0);

        score.setText(Integer.toString(scoreFin));
        bestScore.setText(Integer.toString(statistic.getMeilleurScore()));
        statistic.ajoutNouveauScore(scoreFin);

        findViewById(R.id.recommencer).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(getApplicationContext(), MainGameActivity.class));
            }
        });

        findViewById(R.id.returnAccueil).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(getApplicationContext(), AccueilActivity.class));
            }
        });
    }
}
