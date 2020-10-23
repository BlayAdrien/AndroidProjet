package com.example.blais_piteau_android.modele.EtatPartie;

public interface IEtatPartie {
     int getScore();
     void setScore(int score);
     void addDistance(float amount);
     int getObstacles_pris();
     void setObstacles_pris(int obstacles_pris);
     double getSpeed();
     void setSpeed(double speed);
     boolean isProtected();
     void setProtected(boolean aProtected);
     boolean isInvinsible();
     void setInvinsible(boolean invinsible);
     float getDistance();
}
