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
    //language
    public static String eng_Or_Rus = Setting.languageEng ? "Language:" : "Язык: ";
    //difficulty
    public static String difEng_Or_Rus = Setting.languageEng ? "Difficulty: " : "Сложность: ";
    //button eng_rus
    public static String text_for_button_eng_or_rus = Setting.languageEng ? "English" : "Русский";
    //style for all labels
    public  static String styleText = Setting.languageEng ? "setting" : "settingRus";





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
