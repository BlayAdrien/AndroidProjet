package com.example.blais_piteau_android.modele.Levels;

import com.example.blais_piteau_android.modele.RessourceType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StubLevelLoader implements ILevelLoader {
    @Override
    public List<AbstractLevel> load() {
        List<AbstractLevel> res = new ArrayList<>();

        res.add(new Level(100,new HashMap<RessourceType, Integer>(){{
            put(RessourceType.ROCK1,2);
            put(RessourceType.ROCK2,3);
        }},1,new ArrayList<>(Arrays.asList(new MyEvent(20,2, RessourceType.ROCK2),new MyEvent(50,4,RessourceType.ROCK2))),1));

        res.add(new Level(200,new HashMap<RessourceType, Integer>(){{
            put(RessourceType.ROCK1,3);
            put(RessourceType.ROCK2,3);
        }},1,new ArrayList<MyEvent>(),1.5));

        res.add(new Level(300,new HashMap<RessourceType, Integer>(){{
            put(RessourceType.ROCK1,4);
            put(RessourceType.ROCK1,4);
        }},1,new ArrayList<>(Arrays.asList(new MyEvent(210,5, RessourceType.ROCK2),new MyEvent(250,4,RessourceType.ROCK2))),2));

        res.add(new Level(400,new HashMap<RessourceType, Integer>(){{
            put(RessourceType.ROCK1,5);
            put(RessourceType.ROCK2,4);
        }},1,new ArrayList<MyEvent>(),2.5));

        res.add(new Level(600,new HashMap<RessourceType, Integer>(){{
            put(RessourceType.ROCK1,5);
            put(RessourceType.ROCK2,5);
        }},2,new ArrayList<>(Arrays.asList(new MyEvent(510,2, RessourceType.ROCK2),new MyEvent(560,40,RessourceType.ROCK2))),3));
        return res;
    }
}
