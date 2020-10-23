package com.example.blais_piteau_android.View.Updater;


import android.graphics.Rect;
import android.util.Log;
import com.example.blais_piteau_android.MainGameActivity;
import com.example.blais_piteau_android.View.Assets.AssetsManager;
import com.example.blais_piteau_android.modele.Constantes;
import com.example.blais_piteau_android.modele.EtatPartie.IEtatPartie;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObject;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObjectManager;
import com.example.blais_piteau_android.modele.Levels.LevelManager;
import com.example.blais_piteau_android.modele.RessourceType;

import java.util.Map;

/**
 * Permet de mettre à jour le jeu.
 */
public class Updater extends AbstractUpdater {
    private IEtatPartie etat;
    private AssetsManager assetsManager;
    private LevelManager levelManager;
    private AbstractGameObject player;
    private MainGameActivity activity;

    /**
     * Constructeur de Updater.
     * @param activity : L'activity depuis laquelle l'Updater est créé.
     * @param gameObjectManager : Le manager de GameObject
     * @param etat : L'etat de la partie
     * @param assetsManager : Le manager des Assets
     * @param levelManager : le manager des levels
     */
    public Updater(MainGameActivity activity, AbstractGameObjectManager gameObjectManager, IEtatPartie etat, AssetsManager assetsManager, LevelManager levelManager){
        super(gameObjectManager);
        this.activity = activity;
        this.etat = etat;
        this.assetsManager = assetsManager;
        this.levelManager = levelManager;
        this.player = gameObjectManager.getPlayer(); //facilite l'accès au player
    }

    @Override
    public void update(double elapsed_time) { //TODO: Pour la suppression d'asset : vérifier qu'elle est invisible / attendre qu'elle le soit
        //Mise à jour des assets dans le jeu : Ajout / Suppression
        if(levelManager.checkLevel(etat.getScore())){
            for (Map.Entry<RessourceType,Integer> entry : levelManager.getCurrent().getObstacles().entrySet()){
                int difference = entry.getValue()-assetsManager.numberOfAssetOfType(entry.getKey());
                if(difference != 0){
                    if(difference > 0){
                        for(int i=0;i<difference;i++) assetsManager.addNewAsset(entry.getKey());
                    }else{
                        for(int i=0;i>difference;i--) assetsManager.removeAsset(entry.getKey());
                    }
                }
            }
        }
        //Mise a jour des visibilités
        for (AbstractGameObject go : gameObjectManager.getGameObjects()) {
            if(!go.isActive()){

            }else{
                if(go.getPosition_y()> Constantes.SCREEN_Y){
                    go.setActive(false);
                }
            }
        }

        for (AbstractGameObject go : gameObjectManager.getGameObjects()) {
            for (Rect r_obj: go.getHitBox()) {
                for (Rect r_player: player.getHitBox()) {
                    if(Rect.intersects(r_player,r_obj)){
                        go.setIsTouched(true);
                        go.getLogic().affect(etat,player,go);
                    }
                    else{
                        if(go.getIsTouched()) {
                            go.setIsTouched(false);
                            go.getLogic().end_affect(etat,player,go);
                        }
                    }
                }
            }
        }

        // vérifier la visibilité des backgrounds
        for (AbstractGameObject bg: gameObjectManager.getBackgrounds()) {
            if(bg.getPosition_y() > Constantes.SCREEN_Y){
                bg.setActive(false);
            }
        }
        //ajout des points
        etat.addDistance((float)(etat.getSpeed()*elapsed_time));

        //vérification que le joueur n'est pas mort :
        if(gameObjectManager.getPlayer().getPosition_y() > (Constantes.SCREEN_Y+gameObjectManager.getPlayer().getSize_y()/2)){
            activity.gameOver();
        }
    }
}
