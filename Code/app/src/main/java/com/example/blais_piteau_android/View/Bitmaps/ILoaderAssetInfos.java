package com.example.blais_piteau_android.View.Bitmaps;

import com.example.blais_piteau_android.modele.RessourceType;

import java.util.Map;

public interface ILoaderAssetInfos {
    Map<RessourceType,AssetInfos> loadAll();
}
