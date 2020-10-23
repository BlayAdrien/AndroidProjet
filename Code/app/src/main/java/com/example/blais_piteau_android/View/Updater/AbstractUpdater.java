package com.example.blais_piteau_android.View.Updater;

import com.example.blais_piteau_android.modele.GameObject.AbstractGameObjectManager;

/**
 * Représente que doit faire un Updater.
 */
public abstract class AbstractUpdater {
    protected AbstractGameObjectManager gameObjectManager;

    /**
     * Constructeur Abstrait de Updater.
     * @param gameObjectManager : Le Manager de GameObjects.
     */
    public  AbstractUpdater(AbstractGameObjectManager gameObjectManager){
        this.gameObjectManager = gameObjectManager;
    }

    /**
     * La fonction à appeler à chaque fois que l'on veut mettre à jour le jeu
     * @param elapsed_time : le temps qu'il s'est écoulé depuis la dernière mise à jour du jeu.
     */
    public abstract void update(double elapsed_time);

}
