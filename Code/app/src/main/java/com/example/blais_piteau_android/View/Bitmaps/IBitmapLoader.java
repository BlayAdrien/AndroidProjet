package com.example.blais_piteau_android.View.Bitmaps;

import android.graphics.Bitmap;
import com.example.blais_piteau_android.modele.RessourceType;

import java.util.List;

public interface IBitmapLoader {
    List<Bitmap> loadRessource(RessourceType type);
}
