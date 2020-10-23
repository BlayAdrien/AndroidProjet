package com.example.blais_piteau_android.View.Assets.AssetFactory;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.blais_piteau_android.View.Assets.Asset;
import com.example.blais_piteau_android.View.Assets.graphics.AnimationGraphics;
import com.example.blais_piteau_android.View.Assets.graphics.IGraphic;
import com.example.blais_piteau_android.View.Assets.graphics.StaticGraphic;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObject;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObjectManager;
import com.example.blais_piteau_android.modele.GameObject.GameObjectFactory.GameObjectFactory;
import com.example.blais_piteau_android.modele.Logic.Blocking;
import com.example.blais_piteau_android.modele.Logic.Element;
import com.example.blais_piteau_android.modele.RessourceType;
import com.example.blais_piteau_android.View.Bitmaps.IBitmapLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * L'AssetFactory va permettre de gérer l'instanciation des Assets, il va surtout éviter la duplication des Bitmaps en mémoire
 */
public class AssetFactory extends AbstractAssetFactory {
    private Map<RessourceType,List<Bitmap>> graphics_bitmaps; //TODO : changement diag class
    private GameObjectFactory gameObjectFactory;
    private AbstractGameObjectManager gameObjectManager;

    public AssetFactory(IBitmapLoader loader,AbstractGameObjectManager gameObjectManager){
        super.loader = loader;
        this.graphics_bitmaps = new HashMap<>();
        this.gameObjectManager = gameObjectManager;
    }


    private IGraphic find_a_graphic(RessourceType type){
        IGraphic graphicTMP;
        //si on a déjà les images en mémoire, alors on peut faire avec, sinon on va les charger
        List<Bitmap> bitmaps;
        if(graphics_bitmaps.containsKey(type)){
            bitmaps = graphics_bitmaps.get(type);
        }
        else{
            bitmaps = loader.loadRessource(type);
            graphics_bitmaps.put(type,bitmaps);
        }
        if(bitmaps.size() == 1)
            graphicTMP = new StaticGraphic(bitmaps.get(0));
        else
            graphicTMP = new AnimationGraphics(bitmaps,true);
        return graphicTMP;
    }

    @Override
    public Asset createAsset(RessourceType type){
        IGraphic graphicTMP = find_a_graphic(type);
        AbstractGameObject gameObject = null;
        try {
            gameObject = gameObjectManager.addNewGameObject(new Blocking(null),type,graphicTMP.getGraphicSizeX(),graphicTMP.getGraphicSizeY());
            Log.println(Log.DEBUG,"size","HECSIZE : " + graphicTMP.getGraphicSizeX() + " : " + graphicTMP.getGraphicSizeY());
        } catch (Exception e) {
            Log.println(Log.ERROR,"HEC","IGraphic not initialized");
        }
        return new Asset(type,graphicTMP,gameObject);
    }

    @Override
    public Asset createAsset(RessourceType type, AbstractGameObject go){
        return new Asset(type,find_a_graphic(type),go);
    }
}
