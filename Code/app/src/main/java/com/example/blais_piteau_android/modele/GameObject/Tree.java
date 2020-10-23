package com.example.blais_piteau_android.modele.GameObject;

import com.example.blais_piteau_android.modele.GameObjectType;
import com.example.blais_piteau_android.modele.Logic.IElement;

public class Tree extends AbstractGameObject {
    public Tree(){
        super();
        this.setActive(true);
    }
    public Tree(IElement logic,boolean isActive, float pos_x, float pos_y, float size_x, float size_y) {
        super(logic,GameObjectType.BACKGROUND_ATTACHED,pos_x,pos_y,size_x,size_y);
        this.setActive(isActive);
    }
}
