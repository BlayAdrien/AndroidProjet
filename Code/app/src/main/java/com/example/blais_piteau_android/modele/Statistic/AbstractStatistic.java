package com.example.blais_piteau_android.modele.Statistic;

public abstract class AbstractStatistic {
    public abstract int getMeilleurScore();
    public abstract int getScoreFinPartie();
    public abstract void ajoutNouveauScore(int score);
    public abstract int getScoreTotal();
}
