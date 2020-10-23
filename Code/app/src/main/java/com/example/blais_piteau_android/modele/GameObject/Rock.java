package com.example.blais_piteau_android.modele.GameObject;

import com.example.blais_piteau_android.modele.GameObjectType;
import com.example.blais_piteau_android.modele.Logic.Blocking;
import com.example.blais_piteau_android.modele.Logic.Element;
import com.example.blais_piteau_android.modele.Logic.IElement;

public class Rock extends AbstractGameObject {
    public Rock(){
        super(new Blocking(null),GameObjectType.BACKGROUND_ATTACHED,-50,-50,1,1);
        this.setActive(true);
    }
    public Rock(IElement logic, boolean isActive, float pos_x, float pos_y, float size_x, float size_y) {
        super((logic != null)?logic:new Element(new Blocking(null)),GameObjectType.BACKGROUND_ATTACHED,pos_x,pos_y,size_x,size_y);
        this.setActive(isActive);
    }
}
