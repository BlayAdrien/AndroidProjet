package com.example.blais_piteau_android.View;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.example.blais_piteau_android.View.Renderer.AbstractRenderer;
import com.example.blais_piteau_android.modele.Mover.AbstractMover;
import com.example.blais_piteau_android.View.Updater.AbstractUpdater;

public class BackgroundView extends View implements Runnable {
    private boolean isPlaying;
    private Thread thread;
    private AbstractRenderer renderer;
    private AbstractUpdater updater;
    private AbstractMover mover;
    private double elapsed_time;
    private double init_time;
    private double last_time;


    public BackgroundView(Context context, AbstractRenderer renderer, AbstractUpdater updater, AbstractMover mover) {
        super(context);
        this.renderer = renderer;
        this.updater = updater;
        this.init_time = System.currentTimeMillis();
        this.last_time = init_time;
        this.mover = mover;
        isPlaying = false;
    }

    public void pause(){
        isPlaying = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume(){
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while(isPlaying){
            update();
        }
    }

    @Override
    protected void onDraw(Canvas c){
        super.onDraw(c);
        renderer.render(c);
        invalidate();
    }

    private void update(){
        elapsed_time = System.currentTimeMillis() - last_time;
        last_time = System.currentTimeMillis();
        mover.move(elapsed_time/1000);
        updater.update(elapsed_time/1000);
    }

}
