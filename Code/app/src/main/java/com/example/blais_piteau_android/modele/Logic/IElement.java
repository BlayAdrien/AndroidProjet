package com.example.blais_piteau_android.modele.Logic;

import com.example.blais_piteau_android.modele.EtatPartie.IEtatPartie;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObject;

public interface IElement {
    void affect(IEtatPartie e, AbstractGameObject touching,AbstractGameObject touched);
    void end_affect(IEtatPartie e, AbstractGameObject touching,AbstractGameObject touched);
}
