package com.example.blais_piteau_android.modele.GameObject;

import com.example.blais_piteau_android.modele.Constantes;
import com.example.blais_piteau_android.modele.GameObjectType;
import com.example.blais_piteau_android.modele.Logic.IElement;
import com.example.blais_piteau_android.modele.Logic.Neutral;

public class Background extends AbstractGameObject {
    public Background(){
        super(new Neutral(),GameObjectType.BACKGROUND, Constantes.SCREEN_X/2,Constantes.SCREEN_Y/2,1,1);
    }

    public Background(IElement logic,boolean isActive,float pos_x, float pos_y, float size_x, float size_y) {
        super(logic, GameObjectType.BACKGROUND, pos_x, pos_y, size_x, size_y);
    }
}
