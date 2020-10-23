package com.example.blais_piteau_android.View.Bitmaps;

import com.example.blais_piteau_android.modele.RessourceType;

import java.util.List;

public interface IAssetInfoManager {
    List<Integer> getDrawables(RessourceType type);
    AssetInfos getInfos(RessourceType type);
}
