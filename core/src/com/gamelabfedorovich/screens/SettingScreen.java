package com.gamelabfedorovich.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.gamelabfedorovich.Assets;
import com.gamelabfedorovich.Setting;
import com.gamelabfedorovich.math.Coords;

import java.util.Set;

public class SettingScreen implements Screen {
    private Game game;
    private Stage stage;
    private Label language;
    private Label difficulty;
    private TextButton eng_rus;
    private ImageButton close;
    private SpriteBatch batch;

    public SettingScreen(Game game){
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        //language
        String eng_Or_Rus = Setting.languageEng ? "Language:" : "Язык: ";
        //difficulty
        String difEng_Or_Rus = Setting.languageEng ? "Difficulty: " : "Сложность: ";
        //button eng_rus
        String text_for_button_eng_or_rus = Setting.languageEng ? "English" : "Русский";
        //style for all labels
        String styleText = Setting.languageEng ? "setting" : "settingRus";



        //стиля - "settingRus" пока нет будет ошибка
        language = new Label(Setting.eng_Or_Rus, Assets.skin, styleText);
        language.setPosition(5, Coords.cellRatioY - (language.getHeight() + 10));

        difficulty = new Label(Setting.difEng_Or_Rus, Assets.skin, styleText);
        difficulty.setPosition(language.getX(),
                (language.getY() - difficulty.getHeight()) - 10);

        eng_rus = new TextButton(Setting.text_for_button_eng_or_rus, Assets.skin);
        eng_rus.setHeight(language.getHeight());
        eng_rus.setPosition(language.getX() + language.getWidth() - 30 ,
                language.getY() - 5);

        close = new ImageButton(Assets.skin, "close");
        close.setPosition(0, 0);
        close.setSize(Coords.cellWidth / 10, Coords.cellRatioY / 10);


        stage = new Stage(new FillViewport(Coords.cellWidth, Coords.cellRatioY));
        stage.addActor(language);
        stage.addActor(difficulty);
        stage.addActor(eng_rus);
        stage.addActor(close);
        Gdx.input.setInputProcessor(stage);

    }

    private void update(){
        //calling is 60 event on 1 second, it is a bad realisation selected
        if(eng_rus.isPressed()){
            Setting.languageEng = !Setting.languageEng;
            String langText = Setting.eng_Or_Rus;
            language.setText(langText);
            String buttonText = Setting.text_for_button_eng_or_rus;
            eng_rus.setText(buttonText);
            System.out.println(langText);
            Setting.save();
        }
        if(close.isPressed()){
            game.setScreen(new MainScreen(game));
            Setting.save();
        }
    }

    @Override
    public void render(float delta) {
        GL20 gl = Gdx.graphics.getGL20();
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gl.glClearColor(0.93f, 1, 1,1);
        update();
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();
        language.remove();
        difficulty.remove();
        eng_rus.remove();
        close.remove();
        stage.dispose();
    }
}
