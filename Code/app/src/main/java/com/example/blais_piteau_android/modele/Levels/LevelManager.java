package com.example.blais_piteau_android.modele.Levels;

import com.example.blais_piteau_android.View.Assets.AssetsManager;
import com.example.blais_piteau_android.modele.RessourceType;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class LevelManager {
    private List<AbstractLevel> levels;
    private AbstractLevel current;
    private AssetsManager assetsManager;
    public AbstractLevel getCurrent() {
        return current;
    }
    private int index=0;

    public LevelManager(ILevelLoader loader, AssetsManager assetsManager){
        this.assetsManager = assetsManager;
        this.levels = loader.load();
        this.current = levels.get(index); //current devient le premier de la liste

        for(Map.Entry<RessourceType, Integer> entry : current.getObstacles().entrySet()){
            for(int i=0;i<entry.getValue();i++){
                assetsManager.addNewAsset(entry.getKey());
            }
        }
    }

    public boolean checkLevel(int points){
        if(points > current.seuilDePoints){
            current = levels.get(++index);
            return true;
        }
        return false;
    }
}
