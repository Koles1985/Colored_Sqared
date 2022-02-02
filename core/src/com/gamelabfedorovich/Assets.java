package com.gamelabfedorovich;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
    public static Texture background;
    public static Skin skin;
    public static Texture colors;
    public static TextureRegion white;
    public static TextureRegion red;
    public static TextureRegion green;
    public static TextureRegion blue;
    public static TextureRegion yellow;
    public static TextureRegion fiolet;


    public static void load(){
        FileHandle handle = Gdx.files.internal("skin/rainbow-ui.json");
        background = new Texture("texture/background.png");
        skin = new Skin(handle);
        colors = new Texture("colors.png");
        white = new TextureRegion(colors, 0,0, 72,72);
        yellow = new TextureRegion(colors, 72, 0, 72, 72);
        green = new TextureRegion(colors, 144, 0, 72,72);
        blue = new TextureRegion(colors, 0,72,72,72);
        fiolet = new TextureRegion(colors, 72,72,72,72);
        red = new TextureRegion(colors, 144, 72, 72, 72);

    }

    public static void reload(){
    }
}
