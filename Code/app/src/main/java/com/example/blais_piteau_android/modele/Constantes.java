package com.example.blais_piteau_android.modele;

import com.example.blais_piteau_android.modele.GameObject.Background;
import com.example.blais_piteau_android.modele.GameObject.Rock;
import com.example.blais_piteau_android.modele.GameObject.Fish;
import com.example.blais_piteau_android.modele.GameObject.Player;
import com.example.blais_piteau_android.modele.GameObject.Tree;

import java.util.HashMap;
import java.util.Map;

public class Constantes {
    public static final String SCORE_MESSAGE = "com.example.blais_piteau_android.SCORE_MESSAGE";
    public static final String MEILLEUR_SCORE = "com.example.blais_piteau_android.MEILLEUR_SCORE";
    public static final String SCORE_FIN = "com.example.blais_piteau_android.SCORE_FIN";
    public static final String SCORE_TOTAL = "com.example.blais_piteau_android.SCORE_TOTAL";


    public final static int SCREEN_PIXEL_WIDTH = 200;

    //TODO: A déplacer dans Utils
    /***/
    public static int SCREEN_X;
    public static int SCREEN_Y;
    /***/

    //Définie la vitesse de lecture des images animées:
    public static final int ANIMATION_SPEED = 10;


    public static final Map<RessourceType,Class> RESSOURCE_CLASS = new HashMap<RessourceType,Class>(){{
        put(RessourceType.ROCK1, Rock.class);
        put(RessourceType.ROCK2, Rock.class);
        put(RessourceType.ROCK3, Rock.class);
        put(RessourceType.PLAYER1, Player.class);
        put(RessourceType.FISH1, Fish.class);
        put(RessourceType.FISH2, Fish.class);
        put(RessourceType.TREE1, Tree.class);
        put(RessourceType.BACKGROUND1, Background.class);
    }};
}
