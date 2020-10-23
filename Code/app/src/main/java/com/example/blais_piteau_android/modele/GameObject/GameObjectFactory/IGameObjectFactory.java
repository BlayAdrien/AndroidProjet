package com.example.blais_piteau_android.modele.GameObject.GameObjectFactory;

import com.example.blais_piteau_android.modele.GameObject.AbstractGameObject;
import com.example.blais_piteau_android.modele.RessourceType;

public interface IGameObjectFactory {
    AbstractGameObject makeGameObject(RessourceType type);
}
