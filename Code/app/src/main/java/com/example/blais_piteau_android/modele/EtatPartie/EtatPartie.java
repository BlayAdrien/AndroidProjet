package com.example.blais_piteau_android.modele.EtatPartie;

public class EtatPartie implements IEtatPartie {
    private int score;
    private int obstacles_pris;
    private double speed;
    private boolean isProtected;
    private boolean isInvinsible; // je sais plus à quoi il sert
    private float distance;

    public EtatPartie(double speed, boolean isProtected, boolean isInvinsible){
        this.score = 0;
        this.obstacles_pris = 0;
        this.speed = speed;
        this.isProtected = isProtected;
        this.isInvinsible = isInvinsible;
        this.distance = 0f;
    }

    public int getScore() {
        return (int)(distance/100);
        //return score;
    }

    public void addDistance(float amount){
        this.distance += amount;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getObstacles_pris() {
        return obstacles_pris;
    }

    public void setObstacles_pris(int obstacles_pris) {
        this.obstacles_pris = obstacles_pris;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isProtected() {
        return isProtected;
    }

    public void setProtected(boolean aProtected) {
        isProtected = aProtected;
    }

    public boolean isInvinsible() {
        return isInvinsible;
    }

    public void setInvinsible(boolean invinsible) {
        isInvinsible = invinsible;
    }

    @Override
    public float getDistance() {
        return distance;
    }
}
