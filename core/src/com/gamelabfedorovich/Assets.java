package com.gamelabfedorovich;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
    public static Texture background;
    public static Skin skin;

    public static void load(){
        FileHandle handle = Gdx.files.internal("skin/rainbow-ui.json");
        background = new Texture("texture/background.png");
        skin = new Skin(handle);

    }

    public static void reload(){
    }
}
