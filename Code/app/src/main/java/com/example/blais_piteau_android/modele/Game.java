package com.example.blais_piteau_android.modele;

import android.content.res.Resources;
import android.hardware.SensorManager;

import com.example.blais_piteau_android.MainGameActivity;
import com.example.blais_piteau_android.View.Assets.AssetFactory.AssetFactory;
import com.example.blais_piteau_android.View.Assets.AssetsManager;
import com.example.blais_piteau_android.View.Bitmaps.AssetInfosManager;
import com.example.blais_piteau_android.View.Bitmaps.BitmapLoader;
import com.example.blais_piteau_android.View.Bitmaps.IAssetInfoManager;
import com.example.blais_piteau_android.View.Bitmaps.StubLoaderAssetInfos;
import com.example.blais_piteau_android.modele.EtatPartie.EtatPartie;
import com.example.blais_piteau_android.modele.EtatPartie.IEtatPartie;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObjectManager;
import com.example.blais_piteau_android.modele.GameObject.GameObjectFactory.GameObjectFactory;
import com.example.blais_piteau_android.modele.GameObject.GameObjectManager;
import com.example.blais_piteau_android.modele.Levels.LevelManager;
import com.example.blais_piteau_android.modele.Levels.StubLevelLoader;
import com.example.blais_piteau_android.View.Renderer.AbstractRenderer;
import com.example.blais_piteau_android.View.Renderer.Renderer;
import com.example.blais_piteau_android.modele.Mover.AbstractMover;
import com.example.blais_piteau_android.modele.Mover.Mover;
import com.example.blais_piteau_android.modele.Player_movement.GyroscopeController;
import com.example.blais_piteau_android.View.Updater.AbstractUpdater;
import com.example.blais_piteau_android.View.Updater.Updater;
import com.example.blais_piteau_android.modele.Player_movement.IMovementController;

public class Game {
    private AssetsManager assetsManager;
    private LevelManager levelManager;
    private AbstractRenderer renderer;
    private IEtatPartie etatPartie;
    private AbstractUpdater updater;
    private AbstractGameObjectManager gameObjectManager;
    private AbstractMover mover;
    private IAssetInfoManager assetInfoManager;
    private MainGameActivity activity;
    private IMovementController movementController;

    public Game(MainGameActivity activity, Resources res, SensorManager sm, int screenX, int screenY){
        this.activity = activity;
        Constantes.SCREEN_X = screenX;
        Constantes.SCREEN_Y = screenY;
        this.assetInfoManager = new AssetInfosManager(new StubLoaderAssetInfos());
        this.etatPartie = new EtatPartie(500,false,false);
        this.gameObjectManager = new GameObjectManager(RessourceType.PLAYER1,new GameObjectFactory());
        this.assetsManager = new AssetsManager(new AssetFactory(new BitmapLoader(res,assetInfoManager,screenX,screenY),gameObjectManager),assetInfoManager,gameObjectManager);
        this.levelManager = new LevelManager(new StubLevelLoader(),this.assetsManager);
        this.renderer = new Renderer(assetsManager.getAssets_list(),etatPartie);
        this.updater = new Updater(activity,this.gameObjectManager,etatPartie,assetsManager,levelManager); //TODO; l'updater ne doit pas connaitre la vue ? si ?
        this.movementController = new GyroscopeController(sm,gameObjectManager.getPlayer().getSize_x(),gameObjectManager.getPlayer().getSize_y());
        this.mover = new Mover(gameObjectManager,etatPartie,movementController); //TODO : lui ne connait pas la vue
    }

    public void pause(){
        movementController.pause();
    }
    public void resume(){
        movementController.register();
    }

    public AbstractRenderer getRenderer() {
        return renderer;
    }

    public AbstractUpdater getUpdater() {
        return updater;
    }

    public AbstractMover getMover(){return mover;}

    public IEtatPartie getEtatPartie(){return etatPartie;}
}
