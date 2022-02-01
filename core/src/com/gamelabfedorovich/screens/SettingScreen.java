package com.gamelabfedorovich.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
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
    private boolean isLanguage;
    private boolean isClose;
    //private SpriteBatch batch;

    public SettingScreen(Game game){
        this.game = game;
    }

    @Override
    public void show() {
        isLanguage = false;
        isClose = false;

        setLabels();
        setButtons();
        catchButtonPressed(eng_rus);
        catchButtonPressed(close);

        stage = new Stage(new FillViewport(Coords.cellWidth, Coords.cellRatioY));
        stage.addActor(language);
        stage.addActor(difficulty);
        stage.addActor(eng_rus);
        stage.addActor(close);
        Gdx.input.setInputProcessor(stage);

    }

    private void setLabels(){
        String styleText = Setting.languageEng ? "setting" : "settingRus";
        //стиль - "settingRus" пока нет русского языка
        language = new Label(Setting.eng_Or_Rus, Assets.skin, styleText);
        language.setPosition(5, Coords.cellRatioY - (language.getHeight() + 10));

        difficulty = new Label(Setting.difEng_Or_Rus, Assets.skin, styleText);
        difficulty.setPosition(language.getX(),
                (language.getY() - difficulty.getHeight()) - 10);
    }
    private void setButtons(){
        eng_rus = new TextButton(Setting.text_for_button_eng_or_rus, Assets.skin);
        eng_rus.setName("language");
        eng_rus.setHeight(language.getHeight());
        eng_rus.setPosition(language.getX() + language.getWidth() - 30 ,
                language.getY() - 5);

        close = new ImageButton(Assets.skin, "close");
        close.setName("close");
        close.setPosition(0, 0);
        close.setSize(Coords.cellWidth / 10, Coords.cellRatioY / 10);
    }
    private void catchButtonPressed(final Button buttonScreen){
        buttonScreen.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                if(buttonScreen.getName().equals("language"))
                    isLanguage = true;
                if(buttonScreen.getName().equals("close"))
                    isClose = true;
            }
        });
    }

    private void update(){
        if(isLanguage){
            Setting.languageEng = !Setting.languageEng;
            String eng_Or_Rus = Setting.languageEng ? "Language:" : "Язык: ";
            String text_for_button_eng_or_rus = Setting.languageEng ? "English" : "Русский";
            String difEng_Or_Rus = Setting.languageEng ? "Difficulty: " : "Сложность: ";
            language.setText(eng_Or_Rus);
            difficulty.setText(difEng_Or_Rus);
            eng_rus.setText(text_for_button_eng_or_rus);
            isLanguage = false;
        }

        if(isClose){
            game.setScreen(new MainScreen(game));
            isClose = false;
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
        //batch.dispose();
        language.remove();
        difficulty.remove();
        eng_rus.remove();
        close.remove();
        stage.dispose();
    }
}
