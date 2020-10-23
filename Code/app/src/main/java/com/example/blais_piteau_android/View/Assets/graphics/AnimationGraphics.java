package com.example.blais_piteau_android.View.Assets.graphics;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.blais_piteau_android.modele.Constantes;

import java.util.List;

/**
 * La class AnimationGraphics permet de stocker les informations graphiques relatives à l'affichage d'un asset animé.
 * Un asset animé est un asset donc l'aspect graphique change au fur et a mesure du temps.
 */
public class AnimationGraphics implements IGraphic {
    private List<Bitmap> images;
    private int size; //Nombre de dessins
    private int index;
    private int invSpeed;
    private int cpt = 0;

    /**
     * Constructeur de AnimationGraphics
     * @param images
     * @param startRandomFrame
     */
    public AnimationGraphics(List<Bitmap> images,boolean startRandomFrame){
        this.images = images;
        this.size = images.size();
        this.index = 0;
        this.invSpeed = Constantes.ANIMATION_SPEED;
        if(startRandomFrame){
            index = (Math.round((float)Math.random()*size))%size;
            Log.println(Log.DEBUG, "HEC2", " INFO : INDEX : " + index);
        }
    }

    public float getGraphicSizeX() throws Exception{
        if(images == null || images.size() == 0) throw new Exception("Images non initialisée ou vide.");
        return images.get(0).getWidth();
    }
    public float getGraphicSizeY()throws Exception{
        if(images == null || images.size() == 0) throw new Exception("Images non initialisée ou vide.");
        return images.get(0).getHeight();
    }

    @Override
    public Bitmap getNextDrawing() {
        Bitmap tmp = images.get(index);
        if(cpt%invSpeed == 0){
            index = (index+1)%size;
            cpt = 1;
        }else{
            cpt++;
        }
        return tmp;
    }
}
