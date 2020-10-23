package com.example.blais_piteau_android.View.Bitmaps;

import com.example.blais_piteau_android.modele.RessourceType;

import java.util.List;
import java.util.Map;

public class AssetInfosManager implements IAssetInfoManager{
    private ILoaderAssetInfos loader;
    private Map<RessourceType,AssetInfos> infos;
    public AssetInfosManager(ILoaderAssetInfos loader){
        this.loader = loader;
        this.infos = loader.loadAll();
    }

    public List<Integer> getDrawables(RessourceType type)
    {
        return infos.get(type).getId_s();
    }

    public AssetInfos getInfos(RessourceType type){
        return infos.get(type);
    }
}