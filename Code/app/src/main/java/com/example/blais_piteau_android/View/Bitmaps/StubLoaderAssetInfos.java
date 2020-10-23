package com.example.blais_piteau_android.View.Bitmaps;

import android.graphics.Rect;

import com.example.blais_piteau_android.R;
import com.example.blais_piteau_android.modele.RessourceType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StubLoaderAssetInfos implements ILoaderAssetInfos {

    @Override
    public Map<RessourceType, AssetInfos> loadAll() {
        Map<RessourceType, AssetInfos> res = new HashMap<>();
        res.put(RessourceType.ROCK1, new AssetInfos(RessourceType.ROCK1,new ArrayList<Integer>(Arrays.asList(R.drawable.rock2_0,R.drawable.rock2_1,R.drawable.rock2_2,R.drawable.rock2_3,R.drawable.rock2_4)), new ArrayList<Rect>(Arrays.asList(new Rect(24,43,24,28)))));
        res.put(RessourceType.ROCK2, new AssetInfos(RessourceType.ROCK2,new ArrayList<Integer>(Arrays.asList(R.drawable.rock3_0001,R.drawable.rock3_0002,R.drawable.rock3_0003,R.drawable.rock3_0004,R.drawable.rock3_0005,R.drawable.rock3_0006,R.drawable.rock3_0007)),new ArrayList<Rect>(Arrays.asList(new Rect(15,32,15,13)))));
        res.put(RessourceType.PLAYER1,new AssetInfos(RessourceType.PLAYER1,new ArrayList<Integer>(Arrays.asList(R.drawable.shark_1)),new ArrayList<Rect>(Arrays.asList(new Rect(10,2,10,4),new Rect(6,17,6,16)))));
        res.put(RessourceType.BACKGROUND1,new AssetInfos(RessourceType.BACKGROUND1,new ArrayList<Integer>(Arrays.asList(R.drawable.bg4)),new ArrayList<Rect>(Arrays.asList(new Rect(0,0,0,0)))));
        return res;
    }
}
