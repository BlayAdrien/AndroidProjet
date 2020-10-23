package com.example.blais_piteau_android.View.Bitmaps;

import android.graphics.Rect;

import com.example.blais_piteau_android.modele.Constantes;
import com.example.blais_piteau_android.modele.RessourceType;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe permet de gérer les méta-données des Assets.
 */
public class AssetInfos implements IAssetInfos{
    private RessourceType type;
    private List<Integer> id_s;
    /**
     * Le hitbox est la representation de la zone à considérer comme solide de l'asset.
     */
    private List<Rect> hitboxs;

    public AssetInfos(RessourceType type,List<Integer> ressources_ids,List<Rect> hitbox){
        this.type = type;
        if(ressources_ids != null) this.id_s = ressources_ids;
        else this.id_s = new ArrayList<>();
        this.hitboxs = hitbox;
        refactorHitboxs();
    }

    /**
     * Permet de proportionner les hitboxs à la taille de l'écran.
     */
    private void refactorHitboxs(){
        for (Rect hitbox: hitboxs) {
            hitbox.left = (hitbox.left* Constantes.SCREEN_X/Constantes.SCREEN_PIXEL_WIDTH);
            hitbox.right = (hitbox.right* Constantes.SCREEN_X/Constantes.SCREEN_PIXEL_WIDTH);
            hitbox.top = (hitbox.top* Constantes.SCREEN_X/Constantes.SCREEN_PIXEL_WIDTH);
            hitbox.bottom = (hitbox.bottom* Constantes.SCREEN_X/Constantes.SCREEN_PIXEL_WIDTH);
        }
    }

    /**
     * Permet de récupérer le type de l'assetInfo
     * @return
     */
    public RessourceType getType() {
        return type;
    }

    /**
     * Permet de récupérer les identifiants des drawables utilisés à la représentation de l'Asset.
     * @return : une liste d'entiers.
     */
    public List<Integer> getId_s() {
        return id_s;
    }

    public List<Rect> getHitboxs(){return hitboxs;}
}
