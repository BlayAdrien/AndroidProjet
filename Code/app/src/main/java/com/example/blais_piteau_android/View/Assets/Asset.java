package com.example.blais_piteau_android.View.Assets;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.blais_piteau_android.View.Assets.graphics.IGraphic;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObject;
import com.example.blais_piteau_android.modele.RessourceType;
import com.example.blais_piteau_android.modele.Logic.IElement;

/**
 * Permet de représenter un Asset dans le jeu. Un asset est un élément qui apparait à l'écran, qui possède sa logique, et une manière de s'afficher.
 */
public class Asset extends AbstractAsset{

    /**
     * Constructeur d'asset.
     * @param type : Le type de l'asset
     * @param graphic : L'élément graphique qui sera utilisé pour l'afficher
     * @param gameObject : Le gameObject qui lui correspond
     */
    public Asset(RessourceType type,IGraphic graphic, AbstractGameObject gameObject){
        super();
        this.type = type;
        this.graphic = graphic;
        this.gameObject = gameObject;
    }

    /**
     * Permet de récupérer la représentation graphique de l'asset
     * @return un Bitmap
     */
    public Bitmap getDrawing(){return graphic.getNextDrawing();}


    /**
     * Permet de connaitre la taille X de notre Asset sur l'écran
     * @return : la taille X
     */
    public float getScreenSizeX(){
        try {
            return graphic.getGraphicSizeX();
        } catch (Exception e) {
            Log.println(Log.ERROR,"BLAIS_PITEAU","ScreenSizeX (AbstractAsset) : Image not initialized");
            return -1.0f;
        }
    }

    /**
     * Permet de connaitre la taille Y de notre Asset sur l'écran
     * @return : la taille Y
     */
    public float getScreenSizeY(){
        try {
            return graphic.getGraphicSizeY();
        } catch (Exception e) {
            Log.println(Log.ERROR,"BLAIS_PITEAU","ScreenSizeY (AbstractAsset) : Image not initialized");
            return -1.0f;
        }
    }
}
