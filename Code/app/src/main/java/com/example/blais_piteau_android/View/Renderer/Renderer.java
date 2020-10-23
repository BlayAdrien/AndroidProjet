package com.example.blais_piteau_android.View.Renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import com.example.blais_piteau_android.View.Assets.AbstractAsset;
import com.example.blais_piteau_android.modele.EtatPartie.IEtatPartie;

import java.util.List;

/**
 * Permet de rendre les Assets dans un canvas.
 */
public class Renderer extends AbstractRenderer {
    private Paint paint = new Paint();
    private Paint border_debug = new Paint();
    private Paint text = new Paint();
    private IEtatPartie etat;

    /**
     * Constructeur de Renderer.
     * @param assets : La liste des assets à rendre
     * @param etat : l'etat de la partie.
     */
    public Renderer(List<AbstractAsset> assets, IEtatPartie etat){
        this.assets = assets;
        this.etat = etat;
        this.paint.setAntiAlias(false);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(false);
        border_debug.setColor(Color.rgb(255,0,0));
        border_debug.setStyle(Paint.Style.STROKE);
        border_debug.setStrokeWidth(5);
        text.setColor(Color.WHITE);
        text.setStyle(Paint.Style.FILL);
        text.setTextSize(100);
    }

    @Override
    public void render(Canvas c) {
        for (AbstractAsset a: this.assets) {
            if(a.getGameObject().isActive()){
                c.drawBitmap(a.getDrawing(),a.getGameObject().getPosition_x(),a.getGameObject().getPosition_y(),paint);


                //Rendering hitboxs :
                /*
                for (Rect r: a.getGameObject().getHitBox()) {
                    c.drawRect(r.left,r.top,r.right,r.bottom,border_debug);
                }
                */
            }
        }
        render_score(c);
    }

    private void render_score(Canvas c){
        c.drawText(Integer.toString(etat.getScore()), 10, 100, text);
    }

}
