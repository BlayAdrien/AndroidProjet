package com.example.blais_piteau_android;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.blais_piteau_android.modele.Statistic.AbstractStatistic;
import com.example.blais_piteau_android.modele.Statistic.Statistic;

public class StatsActivity extends AppCompatActivity {
    private AbstractStatistic statistic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_activity);
        statistic = new Statistic(this);

        TextView scoreFin = (TextView) findViewById(R.id.textViewScoreLast);
        TextView bestScore = (TextView) findViewById(R.id.textViewRecordPerso);
        TextView scoreTot = (TextView) findViewById(R.id.textViewScoreTot);

        scoreFin.setText(Integer.toString(statistic.getScoreFinPartie()));
        bestScore.setText(Integer.toString(statistic.getMeilleurScore()));
        scoreTot.setText(Integer.toString(statistic.getScoreTotal()));

    }
}
