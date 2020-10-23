package com.example.blais_piteau_android.modele.GameObject;

import com.example.blais_piteau_android.modele.GameObjectType;
import com.example.blais_piteau_android.modele.Logic.IElement;
import com.example.blais_piteau_android.modele.Logic.Neutral;

public class Fish extends AbstractGameObject {
    public Fish(){
        super(new Neutral(),GameObjectType.BACKGROUND_ATTACHED,-50,-50,1,1);
        this.setActive(true);
    }
    public Fish(IElement logic,boolean isActive, float pos_x, float pos_y, float size_x, float size_y) {
        super(logic,GameObjectType.BACKGROUND_ATTACHED,pos_x,pos_y,size_x,size_y);
        this.setActive(isActive);
    }
}
