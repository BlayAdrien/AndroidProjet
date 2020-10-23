package com.example.blais_piteau_android.modele.Logic;

import com.example.blais_piteau_android.modele.EtatPartie.IEtatPartie;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObject;

public class Element implements IElement {
    private IElement elem;
    public Element(IElement e){
        this.elem = e;
    }

    @Override
    public void affect(IEtatPartie e, AbstractGameObject touching,AbstractGameObject touched) {

    }

    @Override
    public void end_affect(IEtatPartie e, AbstractGameObject touching,AbstractGameObject touched) {

    }
}
