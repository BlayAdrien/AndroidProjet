package com.example.blais_piteau_android.modele;

public class Utils {
    static public int Mod(int x, int y)
    {
        int result = x % y;
        return result < 0? result + y : result;
    }
}
