package com.gamelabfedorovich;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g3d.Environment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.FileHandler;

public class Setting {
    public static boolean languageEng = true;
    public static int difficult = 3;





    public static void load(){
        FileHandle handle = Gdx.files.local("test.txt");
        //String test = handle.readString();
        //System.out.println(test);
    }

    public static void save() {
        FileHandle handle = Gdx.files.local("test.txt");
        handle.writeString("s", false);
    }
}
