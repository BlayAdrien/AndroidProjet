package com.example.blais_piteau_android.modele.Mover;

import android.util.Log;

import com.example.blais_piteau_android.modele.Constantes;
import com.example.blais_piteau_android.modele.EtatPartie.IEtatPartie;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObject;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObjectManager;
import com.example.blais_piteau_android.modele.Player_movement.IMovementController;
import com.example.blais_piteau_android.modele.Utils;

import java.util.List;

public class Mover extends AbstractMover{
    public Mover(AbstractGameObjectManager gameObjectManager, IEtatPartie etatPartie, IMovementController playerController) {
        super(etatPartie);
        this.playerController = playerController;
        this.gameObjectManager = gameObjectManager;
        this.gameObjects = gameObjectManager.getGameObjects();
    }

    @Override
    public void move(double elapsed_time) {
        for (AbstractGameObject go : gameObjectManager.getGameObjects()) {
            if(go.isActive()){
                go.moveY((float)(etatPartie.getSpeed()*elapsed_time)+go.getSlowingFactor());
            }
            else{
                go.setPosition_y(-10-go.getSize_y());
                go.setPosition_x((float)(Math.random()* (Constantes.SCREEN_X-go.getSize_x())));
                go.setActive(true);
            }
        }

        gameObjectManager.getPlayer().setPosition_x(playerController.getPosX());
        gameObjectManager.getPlayer().moveY((float)(gameObjectManager.getPlayer().getSlowingFactor()*elapsed_time));


        List<AbstractGameObject> backgrounds = gameObjectManager.getBackgrounds();
        for (int i=0; i<backgrounds.size();i++){
            if(backgrounds.get(i).isActive()){
                backgrounds.get(i).moveY((float)(etatPartie.getSpeed()*elapsed_time));
            }
            else{
                backgrounds.get(i).setPosition_y(backgrounds.get(Utils.Mod(i-1,backgrounds.size())).getPosition_y()-backgrounds.get(i).getSize_y()+15);
                backgrounds.get(i).setActive(true);
            }
        }
    }


}
