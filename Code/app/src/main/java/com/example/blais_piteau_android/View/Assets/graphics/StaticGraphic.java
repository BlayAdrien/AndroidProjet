package com.example.blais_piteau_android.View.Assets.graphics;

import android.graphics.Bitmap;

/**
 * Permet de représenter un élément graphique d'une seule image.
 */
public class StaticGraphic implements IGraphic {
    private Bitmap image;

    /**
     * Constructeur par défaut, prends une seule image en entrée.
     * @param image : L'image qui lui correspond.
     */
    public StaticGraphic(Bitmap image){
        this.image = image;
    }

    @Override
    public Bitmap getNextDrawing() {
        return image;
    }

    @Override
    public float getGraphicSizeX() throws Exception {
        if(image == null) throw new Exception("Image non initialisée.");
        return image.getWidth();
    }

    @Override
    public float getGraphicSizeY() throws Exception {
        if(image == null) throw new Exception("Image non initialisée.");
        return image.getHeight();
    }

}
