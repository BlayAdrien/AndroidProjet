package com.example.blais_piteau_android.View.Assets.graphics;

import android.graphics.Bitmap;

/**
 * Cette interface permet de représenter un élément graphique, soit composé de plusieurs images, soit que d'une seule.
 */
public interface IGraphic {
    /**
     * Permet de récuperer l'image à dessiner à la frame suivante
     * @return : un bitmap
     */
    Bitmap getNextDrawing();

    /**
     * Permet de connaitre la taille X de l'image
     * @return : float la taille de l'image
     * @throws Exception : S'il n'y a pas d'image, lance une exception.
     */
    float getGraphicSizeX()throws Exception;
    /**
     * Permet de connaitre la taille Y de l'image
     * @return : float la taille de l'image
     * @throws Exception : S'il n'y a pas d'image, lance une exception.
     */
    float getGraphicSizeY()throws Exception;
}
