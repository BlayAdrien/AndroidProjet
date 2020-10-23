package com.example.blais_piteau_android.modele.Levels;

import com.example.blais_piteau_android.modele.RessourceType;

public class MyEvent {
    private int seuil;
    private int fluctuation;
    private RessourceType type;
    private boolean isDone;

    public MyEvent(int seuil, int fluctuation, RessourceType type){
        this.seuil = seuil -fluctuation+2*Math.round((float)(Math.random()*fluctuation));
        this.fluctuation = fluctuation;
        this.type = type;
        this.isDone = false;
    }

    public int getSeuil() {
        return seuil;
    }

    public int getFluctuation() {
        return fluctuation;
    }

    public RessourceType getType() {
        return type;
    }

    public boolean isDone() {
        return isDone;
    }
}
