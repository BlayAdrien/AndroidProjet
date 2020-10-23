package com.example.blais_piteau_android.View.Assets;

import android.graphics.Bitmap;

import com.example.blais_piteau_android.View.Assets.graphics.IGraphic;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObject;
import com.example.blais_piteau_android.modele.RessourceType;

public abstract class AbstractAsset {
    protected IGraphic graphic;
    protected AbstractGameObject gameObject;
    protected RessourceType type;

    public IGraphic getGraphic(){return  graphic;}
    public AbstractGameObject getGameObject(){return gameObject;}
    public RessourceType getType(){
        return type;
    }
    public Bitmap getDrawing(){
        return graphic.getNextDrawing();
    }
}
