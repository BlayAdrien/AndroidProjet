package com.example.blais_piteau_android.View.Assets;
import android.util.Log;

import com.example.blais_piteau_android.View.Assets.AssetFactory.AbstractAssetFactory;
import com.example.blais_piteau_android.View.Bitmaps.IAssetInfoManager;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObjectManager;
import com.example.blais_piteau_android.modele.RessourceType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Permet de gérer les Assets, ajouter, supprimer des assets du jeu
 */
public class AssetsManager {
    private AbstractAssetFactory assetFactory;
    private List<AbstractAsset> assets_list;
    private AbstractGameObjectManager gameObjectManager;
    private IAssetInfoManager assetInfoManager;

    /**
     * Constructeur de AssetsManager.
     * @param factory : La factory d'Assets qui sera utilisé pour ocnstruire les Assets.
     * @param assetInfoManager : Le manager des AssetsInfos.
     * @param gameObjectManager : Le Manager des GameObjects.
     */
    public AssetsManager(AbstractAssetFactory factory, IAssetInfoManager assetInfoManager, AbstractGameObjectManager gameObjectManager){
        this.assetFactory = factory;
        this.assetInfoManager = assetInfoManager;
        this.assets_list = new ArrayList<>();
        this.gameObjectManager = gameObjectManager;
        init_backgrounds();
        init_player();

    }

    /**
     * Permet d'initialiser les backgrounds dans le jeu.
     */
    private void init_backgrounds(){
        AbstractAsset bg1 = assetFactory.createAsset(RessourceType.BACKGROUND1);
        bg1.getGameObject().setActive(true);
        bg1.getGameObject().setPosition_x(0);
        bg1.getGameObject().setPosition_y(0);
        AbstractAsset bg2 = assetFactory.createAsset(RessourceType.BACKGROUND1);
        bg2.getGameObject().setActive(true);
        bg2.getGameObject().setPosition_x(0);
        bg2.getGameObject().setPosition_y(-bg2.getGameObject().getSize_y());
        assets_list.add(bg1);
        assets_list.add(bg2);
    }

    /**
     * Permet d'initialiser le joueur dans le jeu.
     */
    private void init_player(){
        //ajout de l'asset pour le joueur avec le gameobject déjà existant.
        AbstractAsset player = assetFactory.createAsset(gameObjectManager.getPlayer().getType(),gameObjectManager.getPlayer());
        //Set la position
        try {
            player.getGameObject().setSize_x(player.getGraphic().getGraphicSizeX());
            player.getGameObject().setSize_y(player.getGraphic().getGraphicSizeY());
        } catch (Exception e) {
            Log.println(Log.ERROR,"HEC","Graphics not initialized");
        }
        //set la hitbox
        float player_center_x  = (player.getGameObject().getPosition_x()+player.getGameObject().getSize_x()/2);
        float player_center_y  = (player.getGameObject().getPosition_y()+player.getGameObject().getSize_y()/2);
        player.getGameObject().setActive(true);
        player.getGameObject().applyHitBoxs(assetInfoManager.getInfos(player.getType()).getHitboxs());

        assets_list.add(player);
    }

    /**
     * Permet d'ajouter un nouvel Asset dans le jeu.
     * @param type : le type de l'asset à ajouter.
     */
    public void addNewAsset(RessourceType type){
        try {
            AbstractAsset a = assetFactory.createAsset(type);
            a.getGameObject().applyHitBoxs(assetInfoManager.getInfos(type).getHitboxs());
            assets_list.add(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de supprimer un Asset du jeu.
     * @param type : le type de l'Asset à supprimer.
     */
    public void removeAsset(RessourceType type){
        for (AbstractAsset a : assets_list){
            if(a.getType() == type) {
                assets_list.remove(a);
                break;
            }
        }
    }

    /**
     * Retourne le nombre d'asset du type demandé dans la liste des assets.
     * @param type : Le type à compter.
     * @return : Le nombre d'occurence de 'type'
     */
    public int numberOfAssetOfType(RessourceType type){
        int num = 0;
        for (AbstractAsset a : assets_list) {
            if (a.getType() == type) num++;
        }
        return num;
    }

    /**
     * Permet de récupérer la liste des Assets.
     * @return : Une liste d'Assets.
     */
    public List<AbstractAsset> getAssets_list(){return assets_list;}
}
