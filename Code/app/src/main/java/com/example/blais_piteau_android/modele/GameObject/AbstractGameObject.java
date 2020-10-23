package com.example.blais_piteau_android.modele.GameObject;

import android.graphics.Rect;
import com.example.blais_piteau_android.modele.GameObjectType;
import com.example.blais_piteau_android.modele.Logic.IElement;
import com.example.blais_piteau_android.modele.Logic.Neutral;
import com.example.blais_piteau_android.modele.RessourceType;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente ce que doit avoir/faire un GameObject
 */
public abstract class AbstractGameObject {
    private RessourceType visualType;
    private GameObjectType gameObjectType;
    private float pos_x;
    private float pos_y;
    private float size_x;
    private float size_y;
    private boolean isActive = false;
    protected IElement logic;
    private List<Rect> hitBox;
    private List<Rect> saved_hitboxs;
    protected double speed;
    private float slowingFactor = 0f;
    private boolean isTouched = false;

    public AbstractGameObject(){ //TODO: à enlever
        pos_x = 0;
        pos_y = 0;
        size_x = 1;
        size_y = 1;
        logic = null;
        gameObjectType = GameObjectType.BACKGROUND_ATTACHED;
        saved_hitboxs = new ArrayList<>();
        hitBox = new ArrayList<>();
    }

    public AbstractGameObject(IElement logic,GameObjectType type,float pos_x,float pos_y,float size_x,float size_y){
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.size_x = size_x;
        this.size_y = size_y;
        this.logic = (logic != null)? logic : new Neutral();
        this.gameObjectType = type;
        this.saved_hitboxs = new ArrayList<>();
        this.hitBox = new ArrayList<>();
    }

    public boolean getIsTouched(){return isTouched;}

    public void setIsTouched(boolean val){
        if(this.isTouched != val)
            this.isTouched = val;
    }

    /**
     * Permet d'appliquer un modèle de hitbox au gameobject
     * @param hitboxs : la hitbox, considérant que left est la distance entre la paroie de gauche et le bord gauche de la hitbox, etc..
     */
    public void applyHitBoxs(List<Rect> hitboxs){
        for(int i=0; i < hitboxs.size() ; i++){
            this.hitBox.add(new Rect((int)(pos_x+hitboxs.get(i).left),(int)(pos_y+hitboxs.get(i).top),(int)(pos_x+size_x-hitboxs.get(i).right),(int)(pos_y+size_y-hitboxs.get(i).bottom)));
        }
        this.saved_hitboxs = hitboxs;

    }
    public void moveX(float amount){
        this.pos_x += amount;
        for(int i=0; i < hitBox.size() ; i++){
            hitBox.get(i).left = (int)(this.pos_x+saved_hitboxs.get(i).left);
            hitBox.get(i).right = (int)(this.pos_x+this.size_x-saved_hitboxs.get(i).right);
        }
    }

    public void moveY(float amount){
        this.pos_y += amount;
        for(int i=0; i < hitBox.size() ; i++){
            hitBox.get(i).top = (int)(this.pos_y+saved_hitboxs.get(i).top);
            hitBox.get(i).bottom = (int)(this.pos_y+this.size_y-saved_hitboxs.get(i).bottom);
        }

    }

    public List<Rect> getHitBox(){
        return hitBox;
    }

    public void setSize_x(float size_x){this.size_x = size_x;}
    public void setSize_y(float size_y){this.size_y = size_y;}

    /**
     * Permet de récupérer la position x de l'asset
     * @return : la position x.
     */
    public float getPosition_x() {return pos_x;}

    /**
     * Permet de regler la position x de l'asset
     * @param position_x : la nouvelle position x.
     */
    public void setPosition_x(float position_x) {
        //float center_x = position_x + this.size_x/2;
        for(int i=0; i < hitBox.size() ; i++){
            hitBox.get(i).left = (int)(position_x+saved_hitboxs.get(i).left);
            hitBox.get(i).right = (int)(position_x+size_x-saved_hitboxs.get(i).right);
        }
        this.pos_x = position_x;
    }

    /**
     * Permet de récupérer la position y de l'asset
     * @return : La position Y de l'Asset sur l'écran
     */
    public float getPosition_y() {

        return pos_y;
    }

    /**
     * Permet de régler la position y de l'asset
     * @param position_y : la nouvelle position y.
     */
    public void setPosition_y(float position_y) {
        for(int i=0; i < hitBox.size() ; i++){
            hitBox.get(i).top = (int)(position_y + saved_hitboxs.get(i).top);
            hitBox.get(i).bottom = (int)(position_y + size_y - saved_hitboxs.get(i).bottom);
        }
        this.pos_y = position_y;
    }

    /**
     * Permet de savoir si l'asset est visible à l'écran, et donc s'il doit être rendu / mis à jour.
     * @return True si visible, False sinon
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Permet de régler la visibilité de l'asset
     * @param active : True pour active, False pour invisible
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Permet de savoir le type de l'asset
     * @return : Le type de l'Asset
     */
    public RessourceType getType() {
        return visualType;
    }
    public void setVisualType(RessourceType type){this.visualType = type;}

    public float getSize_x(){return size_x;}
    public float getSize_y(){return size_y;}

    public float getSlowingFactor(){return slowingFactor;}
    public void setSlowingFactor(float value){slowingFactor = value;}

    public IElement getLogic(){return logic;}
    public GameObjectType getGameObjectType(){return gameObjectType;}
}
