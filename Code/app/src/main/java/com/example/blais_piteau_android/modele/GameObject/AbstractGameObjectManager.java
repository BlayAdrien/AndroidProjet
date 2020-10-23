package com.example.blais_piteau_android.modele.GameObject;

import com.example.blais_piteau_android.modele.GameObject.GameObjectFactory.IGameObjectFactory;
import com.example.blais_piteau_android.modele.Logic.IElement;
import com.example.blais_piteau_android.modele.RessourceType;

import java.util.List;

public abstract class AbstractGameObjectManager {
    protected List<AbstractGameObject> gameObjects;
    protected IGameObjectFactory factory;
    protected AbstractGameObject player;
    protected List<AbstractGameObject> backgrounds;
    public abstract AbstractGameObject addNewGameObject(IElement logic, RessourceType type, float size_x, float size_y);
    public AbstractGameObject getPlayer(){return player;}
    public List<AbstractGameObject> getBackgrounds(){return backgrounds;}
    public void addBackground(AbstractGameObject background){ backgrounds.add(background);}
    public List<AbstractGameObject> getGameObjects(){
        return gameObjects;
    }
}
