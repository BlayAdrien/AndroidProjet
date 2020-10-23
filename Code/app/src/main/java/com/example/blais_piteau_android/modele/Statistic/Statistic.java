package com.example.blais_piteau_android.modele.Statistic;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import com.example.blais_piteau_android.modele.Constantes;

public class Statistic extends AbstractStatistic {

    private AppCompatActivity statsActivity;

    public Statistic(AppCompatActivity statsActivity){
        this.statsActivity = statsActivity;
    }

    public int getMeilleurScore(){
        SharedPreferences settings = statsActivity.getSharedPreferences("GAME", Context.MODE_PRIVATE);
        int meilleurScore = settings.getInt(Constantes.MEILLEUR_SCORE,0);
        return meilleurScore;
    }


    public int getScoreFinPartie(){
        SharedPreferences settings = statsActivity.getSharedPreferences("GAME", Context.MODE_PRIVATE);
        int scoreFin = settings.getInt(Constantes.SCORE_FIN,0);
        return scoreFin;
    }

    @Override
    public void ajoutNouveauScore(int score) {
        SharedPreferences settings = statsActivity.getSharedPreferences("GAME", Context.MODE_PRIVATE);
        int meilleurScore = settings.getInt(Constantes.MEILLEUR_SCORE,0);
        int scoreTotal = settings.getInt(Constantes.SCORE_TOTAL,0);

        SharedPreferences.Editor e = settings.edit();
        if(score> meilleurScore){
            e.putInt(Constantes.MEILLEUR_SCORE, score);
        }
        e.putInt(Constantes.SCORE_TOTAL,scoreTotal+score);
        e.putInt(Constantes.SCORE_FIN,score);
        e.commit();
    }


    public int getScoreTotal(){
        SharedPreferences settings = statsActivity.getSharedPreferences("GAME", Context.MODE_PRIVATE);
        int scoreTotal = settings.getInt(Constantes.SCORE_TOTAL, 0);
        return scoreTotal;
    }
}
