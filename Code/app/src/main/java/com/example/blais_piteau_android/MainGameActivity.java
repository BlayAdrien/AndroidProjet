package com.example.blais_piteau_android;

import android.content.Intent;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blais_piteau_android.View.BackgroundView;
import com.example.blais_piteau_android.modele.Constantes;
import com.example.blais_piteau_android.modele.Game;

public class MainGameActivity extends AppCompatActivity {
    private BackgroundView background;
    private Game game;

    @Override
    protected void onCreate(Bundle saveInstanteState){
        super.onCreate(saveInstanteState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point); // récupérer la taille de la fenêtre
        game = new Game(this,getResources(),(SensorManager)getSystemService(SENSOR_SERVICE),point.x,point.y);
        background = new BackgroundView(this,game.getRenderer(),game.getUpdater(), game.getMover());
        setContentView(background);
    }

    public void gameOver(){
        Intent intent = new Intent(getApplicationContext(), GameOverActivity.class);
        intent.putExtra(Constantes.SCORE_MESSAGE,game.getEtatPartie().getScore());
        startActivity(intent);
    }


    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        background.resume();
        game.resume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        background.pause();
        game.pause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}



//  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);