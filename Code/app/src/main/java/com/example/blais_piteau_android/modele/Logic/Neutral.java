package com.example.blais_piteau_android.modele.Logic;

import com.example.blais_piteau_android.modele.EtatPartie.IEtatPartie;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObject;

/**
 * Cette classe représente une absence d'évènement sur la logique  de l'Asset
 */
public class Neutral implements IElement{

    public Neutral() {
    }

    @Override
    public void affect(IEtatPartie e,AbstractGameObject touching,AbstractGameObject touched) {
        return;
    }

    @Override
    public void end_affect(IEtatPartie e,AbstractGameObject touching,AbstractGameObject touched) {
        return;
    }
}
