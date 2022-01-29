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
import com.gamelabfedorovich.gui.GuiTextButton;
import com.gamelabfedorovich.math.Coords;

public class SettingScreen implements Screen {
    private Game game;
    private Stage stage;
    private Label language;
    private Label difficulty;
    private TextButton eng_rus;
    private ImageButton close;
    private SpriteBatch batch;
    private GuiTextButton tb;
    private boolean isChangeLanguage;
    private boolean isClose;

    public SettingScreen(Game game){
        this.game = game;
    }

    @Override
    public void show() {
        isChangeLanguage = false;
        isClose = false;
        batch = new SpriteBatch();



        settingsLable();
        settingsButtons();

        clicked(eng_rus);
        clicked(close);

        /*
        tb = new GuiTextButton("English", Assets.skin);
        tb.setPosition(language.getX() + language.getWidth(), language.getY());
        */

        stage = new Stage(new FillViewport(Coords.cellWidth, Coords.cellRatioY));
        stage.addActor(language);
        stage.addActor(difficulty);
        stage.addActor(eng_rus);
        stage.addActor(close);
        Gdx.input.setInputProcessor(stage);

    }

    private void settingsLable(){
        //стиля - "settingRus" пока нет будет ошибка
        String styleText = Setting.languageEng ? "setting" : "settingRus";
        language = new Label("Language: ", Assets.skin, styleText);
        language.setPosition(5, Coords.cellRatioY - (language.getHeight() + 10));
        //надпись сложность
        difficulty = new Label("Difficulty: ", Assets.skin, styleText);
        difficulty.setPosition(language.getX(),
                (language.getY() - difficulty.getHeight()) - 10);
    }

    private void settingsButtons(){
        //кнопка выбора языка
        eng_rus = new TextButton("English", Assets.skin);
        eng_rus.setName("Language button");
        eng_rus.setHeight(language.getHeight());
        eng_rus.setPosition(language.getX() + language.getWidth() - 30 ,
                language.getY() - 5);

        //кнопка выхода
        close = new ImageButton(Assets.skin, "close");
        close.setName("Close button");
        close.setPosition(0, 0);
        close.setSize(Coords.cellWidth / 10, Coords.cellRatioY / 10);
    }

    private void clicked(final Button buttonCalled){
        buttonCalled.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                if(buttonCalled.getName().equals(eng_rus.getName()))
                    isChangeLanguage = true;
                if(buttonCalled.getName().equals(close.getName()))
                    isClose = true;
            }
        });
    }

    private void update(){
        //calling is 60 event on 1 second, it is a bad realisation selected
        if(isChangeLanguage){
            Setting.languageEng = !Setting.languageEng;

            String langText = Setting.languageEng ? "Language: " : "Язык: ";
            String diffText = Setting.languageEng ? "Difficulty: " : "Сложность: ";
            String langButtonText = Setting.languageEng ? "English" : "Русский";

            language.setText(langText);
            difficulty.setText(diffText);
            eng_rus.setText(langButtonText);
            isChangeLanguage = false;
        }
        if(isClose){
            game.setScreen(new MainScreen(game));
            Setting.save();
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
        batch.dispose();
        language.remove();
        difficulty.remove();
        eng_rus.remove();
        close.remove();
        stage.dispose();
    }
}
