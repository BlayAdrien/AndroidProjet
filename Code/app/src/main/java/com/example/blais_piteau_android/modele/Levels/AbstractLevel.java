package com.example.blais_piteau_android.modele.Levels;

import com.example.blais_piteau_android.modele.RessourceType;

import java.util.Map;

public abstract class AbstractLevel {
    protected int seuilDePoints;
    protected int obstacleLevel;
    protected Map<RessourceType, Integer> obstacles;

    public Map<RessourceType, Integer> getObstacles() {
        return obstacles;
    }
}
