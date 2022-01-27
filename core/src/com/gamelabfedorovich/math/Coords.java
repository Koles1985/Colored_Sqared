package com.gamelabfedorovich.math;

import com.badlogic.gdx.Gdx;

public final class Coords {
    private static Coords instance;
    public static float aspectRatio;
    public static int cellWidth;
    public static int cellHeight;
    public static float centerX;
    public static float centerY;
    public static float cellRatioY;

    public static Coords getCoords(){
        calculate();
        if(instance == null){
           return instance = new Coords();
        }else {
            return instance;
        }
    }
    private static void calculate(){
        aspectRatio = (float) Gdx.graphics.getWidth() / Gdx.graphics.getHeight();
        cellWidth = 800;
        cellHeight = 480;
        cellRatioY = cellWidth / aspectRatio;
        centerX = (float) cellWidth / 2;
        centerY = (float) cellHeight / 2;

    }
}
