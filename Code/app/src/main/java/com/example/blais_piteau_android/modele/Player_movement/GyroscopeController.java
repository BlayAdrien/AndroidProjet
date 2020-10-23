package com.example.blais_piteau_android.modele.Player_movement;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import com.example.blais_piteau_android.modele.Constantes;

import java.util.Arrays;

public class GyroscopeController implements IMovementController,SensorEventListener  {
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private Sensor magnometer;

    /*******/
    private float[] accelOutput;
    private float[] magOutput;

    private float[] orientation = new float[3];
    public float[] getOrientation(){ return orientation;}

    private float[] startOrientation = null;
    public float[] getStartOrientation(){ return startOrientation;}

    public void newGame(){startOrientation = null;}

    private long frameTime;
    private long init_time;

    private float player_size_X,player_size_Y;


    private float x_axis = 0;
    private float y_axis = 0;


    public GyroscopeController(SensorManager sm,float player_size_X,float player_size_Y){
        this.player_size_X = player_size_X;
        this.player_size_Y = player_size_Y;
        this.init_time = System.currentTimeMillis();
        this.sensorManager = sm;
        this.accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        this.magnometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        this.x_axis = Constantes.SCREEN_X /2+player_size_X;
        this.y_axis = Constantes.SCREEN_Y/1.75f;
        this.register();
        Log.println(Log.DEBUG, "HEC", " INFO : END of construction de GyroscopeController : ");
    }

    public void register(){
        sensorManager.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_GAME);
        sensorManager.registerListener(this,magnometer,SensorManager.SENSOR_DELAY_GAME);
    }

    public void pause(){
        sensorManager.unregisterListener(this);
    }


    public float getPosX() {

        if(frameTime < init_time)
            frameTime = init_time;
        int elapsedTime = (int)(System.currentTimeMillis() - frameTime);
        frameTime = System.currentTimeMillis();
        if(orientation != null && startOrientation != null){
            float pitch = orientation[1] - startOrientation[1];
            float roll = orientation[2] - startOrientation[2];

            float xSpeed = 2*roll*Constantes.SCREEN_X/1000f;
            float ySpeed = pitch*Constantes.SCREEN_Y/1000f; //TODO : est ce que l'on fait déplace le joueur sur l'axe y ?

            x_axis += Math.abs(xSpeed*elapsedTime) > 0.1f ? xSpeed*elapsedTime: 0;
            Log.println(Log.DEBUG,"HEC54485","[INFO] : x_axis = " + x_axis + " : " + (Constantes.SCREEN_X-player_size_X/2) + " : elapsedTime = " + elapsedTime + " : " + roll + " : xSpeed = " + xSpeed);
            if(x_axis > (Constantes.SCREEN_X-player_size_X)) x_axis = Constantes.SCREEN_X-player_size_X;
            else if(x_axis < 0 ) x_axis = 0;
        }
        return x_axis;
    }

    public float getPosY() {
        return y_axis;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            accelOutput = sensorEvent.values;
        else if(sensorEvent.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
            magOutput = sensorEvent.values;
        if(accelOutput != null && magOutput != null) {
            //matrix 3x3 :
            float[] R = new float[9];
            float[] I = new float[9];


            boolean success = SensorManager.getRotationMatrix(R, I, accelOutput, magOutput);
            if(success) {
                SensorManager.getOrientation(R, orientation);
                Log.println(Log.DEBUG,"HEC557788","accelOutput : " + Arrays.toString(orientation));
                if(startOrientation == null) {
                    startOrientation = new float[orientation.length];
                    System.arraycopy(orientation, 0, startOrientation, 0, orientation.length);
                    startOrientation[1] = 0;
                    startOrientation[2] = 0;
                }
            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
