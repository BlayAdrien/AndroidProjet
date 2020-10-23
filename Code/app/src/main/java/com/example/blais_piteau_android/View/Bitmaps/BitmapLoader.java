package com.example.blais_piteau_android.View.Bitmaps;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.blais_piteau_android.modele.Constantes;
import com.example.blais_piteau_android.modele.RessourceType;

import java.util.ArrayList;
import java.util.List;

/**
 * Le classe BitmapLoader permet de charger tous les Bitmap d'un RessourceType donné.
 */
public class BitmapLoader implements IBitmapLoader{
    private IAssetInfoManager infosManager;
    private Resources ressources;
    private int screenX = 10,screenY = 10;

    public BitmapLoader(Resources ressources,IAssetInfoManager assetInfoManager,int screenX,int screenY){
        this.ressources = ressources;
        this.screenX = screenX;
        this.screenY = screenY;
        this.infosManager = assetInfoManager;
    }


    @Override
    public List<Bitmap> loadRessource(RessourceType type) {
        List<Integer> id_s = infosManager.getDrawables(type);
        List<Bitmap> res = new ArrayList<>();
        for (Integer i: id_s) {
            Bitmap tmp = BitmapFactory.decodeResource(ressources, i);
            //TODO : scale bitmap en fonction d'une taille de carte pré-def et en fonction de la taille de l'écran
            res.add(Bitmap.createScaledBitmap(tmp,tmp.getWidth()*screenX/ Constantes.SCREEN_PIXEL_WIDTH,(tmp.getWidth()*screenX/ Constantes.SCREEN_PIXEL_WIDTH)*tmp.getHeight()/tmp.getWidth(),false));
        }
        return res;
    }
}