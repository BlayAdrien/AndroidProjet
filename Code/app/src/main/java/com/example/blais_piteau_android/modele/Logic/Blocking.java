package com.example.blais_piteau_android.modele.Logic;

import com.example.blais_piteau_android.modele.EtatPartie.IEtatPartie;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObject;

public class Blocking extends Element {
    private boolean blocking = false;

    public Blocking(IElement e){
        super(e);
    }

    @Override
    public void affect(IEtatPartie e,AbstractGameObject touching,AbstractGameObject touched) {
        if(blocking) return;
        touching.setSlowingFactor((float)e.getSpeed());
        touching.setPosition_y(touched.getHitBox().get(0).bottom-5);
        blocking = true;
    }

    @Override
    public void end_affect(IEtatPartie e,AbstractGameObject touching,AbstractGameObject touched) {
        touching.setSlowingFactor(0);
        blocking = false;
    }
}
