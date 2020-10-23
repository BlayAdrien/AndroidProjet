package com.example.blais_piteau_android.modele.GameObject.GameObjectFactory;

import android.util.Log;
import com.example.blais_piteau_android.modele.Constantes;
import com.example.blais_piteau_android.modele.GameObject.AbstractGameObject;
import com.example.blais_piteau_android.modele.RessourceType;


public class GameObjectFactory implements IGameObjectFactory {
    @Override
    public AbstractGameObject makeGameObject(RessourceType type) {
        AbstractGameObject res  = null;

        Class classe = Constantes.RESSOURCE_CLASS.get(type);
        try{

            //res = (AbstractGameObject) constructor.newInstance(new Element(new Neutral()),true,Constantes.SCREEN_X/2,(-size_y -10),size_x,size_y);//

            Log.println(Log.DEBUG,"HEC45","[INFO] : Loading "+type + " " + classe.getName());
            //res = (AbstractGameObject)classe.newInstance();
            res = (AbstractGameObject)Class.forName(classe.getName()).newInstance();
            res.setVisualType(type);
            // SET DE LA POSITION :
            //res.setPosition_x(Constantes.SCREEN_X/2);
            //res.setPosition_y(-size_y -10);

        }catch (InstantiationException e){
            Log.println(Log.ERROR,"HEC45","La classe demandée n'est pas instanciable !");
        }catch (IllegalAccessException e){
            Log.println(Log.ERROR,"HEC45","La classe demandée n'est pas accessible !");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }
}
