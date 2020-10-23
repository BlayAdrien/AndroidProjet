package com.example.blais_piteau_android.modele.GameObject;

import com.example.blais_piteau_android.modele.Constantes;
import com.example.blais_piteau_android.modele.GameObject.GameObjectFactory.IGameObjectFactory;
import com.example.blais_piteau_android.modele.GameObjectType;
import com.example.blais_piteau_android.modele.Logic.IElement;
import com.example.blais_piteau_android.modele.RessourceType;

import java.util.ArrayList;

public class GameObjectManager extends AbstractGameObjectManager{

    public GameObjectManager(RessourceType player_type, IGameObjectFactory factory){
        this.gameObjects = new ArrayList<>();
        this.factory = factory;
        this.player = factory.makeGameObject(player_type);
        this.player.setPosition_y(Constantes.SCREEN_Y/2);
        this.backgrounds = new ArrayList<>();
    }

    public AbstractGameObject addNewGameObject(IElement logic,RessourceType type,float size_x,float size_y){
        AbstractGameObject res = factory.makeGameObject(type);
        res.setSize_x(size_x);
        res.setSize_y(size_y);

        if(res.getGameObjectType() == GameObjectType.BACKGROUND) //TODO: faire pareil pour le player.
            this.backgrounds.add(res);
        else
            this.gameObjects.add(res);

        return res;
    }
}
