package com.example.blais_piteau_android.View.Assets.AssetFactory;

import com.example.blais_piteau_android.View.Assets.Asset;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObject;
import com.example.blais_piteau_android.modele.RessourceType;
import com.example.blais_piteau_android.View.Bitmaps.IBitmapLoader;

/**
 * Permet de gérer la création d'assets.
 */
public abstract class AbstractAssetFactory {
    protected IBitmapLoader loader;
    /**
     * Permet de créer un Asset
     * @param type : le type de l'asset
     * @return un Asset construit
     */
    public abstract Asset createAsset(RessourceType type);

    /**
     * Permet de créer un Asset avec un gameobject déjà existant
     * @param type : le type de l'asset
     * @param go : Le gameObject existant
     * @return un Asset construit
     */
    public abstract Asset createAsset(RessourceType type,AbstractGameObject go);
}
