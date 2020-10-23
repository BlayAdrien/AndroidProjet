package com.example.blais_piteau_android.View.Renderer;

import android.graphics.Canvas;
import com.example.blais_piteau_android.View.Assets.AbstractAsset;
import java.util.List;

/**
 * Permet de représenter que doit faire un Renderer
 */
public abstract class AbstractRenderer {
    protected List<AbstractAsset> assets;

    /**
     * Fonction principale de rendering.
     * @param c : Le canvas sur lequel le renderer va dessiner le jeu.
     */
    public abstract void render(Canvas c);
}
