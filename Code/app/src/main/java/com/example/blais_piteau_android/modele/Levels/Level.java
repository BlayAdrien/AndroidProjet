package com.example.blais_piteau_android.modele.Levels;

import com.example.blais_piteau_android.modele.RessourceType;

import java.util.List;
import java.util.Map;

public class Level extends AbstractLevel {
    private double speed;
    private List<MyEvent> specialEvents;

    public Level(int seuil,Map<RessourceType,Integer> obstacles,int obstacleLevel,List<MyEvent> events,double speed){
        this.specialEvents = events;
        super.seuilDePoints = seuil;
        super.obstacleLevel = obstacleLevel;
        this.speed = speed;
        this.obstacles = obstacles;
    }

    public List<MyEvent> getSpecialEvents() {
        return specialEvents;
    }

    public double getSpeed() {
        return speed;
    }
    public Map<RessourceType, Integer> getObstacles(){
        return super.obstacles;
    }

}
