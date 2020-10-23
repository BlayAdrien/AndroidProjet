package com.example.blais_piteau_android.modele.Mover;
import com.example.blais_piteau_android.modele.EtatPartie.IEtatPartie;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObject;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObjectManager;
import com.example.blais_piteau_android.modele.Player_movement.IMovementController;

import java.util.List;

public abstract class AbstractMover {
    protected List<AbstractGameObject> gameObjects;
    protected IEtatPartie etatPartie;
    protected IMovementController playerController;
    protected AbstractGameObjectManager gameObjectManager;

    public AbstractMover(IEtatPartie etatPartie){
        this.etatPartie = etatPartie;

    }
    public abstract void move(double elapsed_time);
}
