package com.gamelabfedorovich.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.gamelabfedorovich.Assets;
import com.gamelabfedorovich.Setting;
import com.gamelabfedorovich.math.Coords;

public class SettingScreen implements Screen {
    private Game game;
    private Stage stage;
    private Label language;
    private Label difficulty;
    private TextButton eng_rus;
    private TextButton _2x2;
    private TextButton _3x3;
    private ImageButton close;
    private SpriteBatch batch;

    public SettingScreen(Game game){
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();

        /*
        //стиля - "settingRus" пока нет будет ошибка
        language = new Label(Setting.eng_Or_Rus, Assets.skin);
        language.setPosition(5, Coords.cellRatioY - (language.getHeight() + 10));
        */
        difficulty = new Label(Setting.difEng_Or_Rus, Assets.skin, "setting");
        difficulty.setPosition(10, Coords.cellHeight - difficulty.getHeight() - 5);
        /*
        eng_rus = new TextButton(Setting.text_for_button_eng_or_rus, Assets.skin);
        eng_rus.setHeight(language.getHeight());
        eng_rus.setPosition(language.getX() + language.getWidth() - 30 ,
                language.getY() - 5);

        eng_rus.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Setting.languageEng = !Setting.languageEng;
                language.setText(Setting.eng_Or_Rus);
                eng_rus.setText(Setting.text_for_button_eng_or_rus);
                System.out.println("eng_rus.touchUp");
                System.out.println(Setting.languageEng);
                System.out.println(Setting.eng_Or_Rus);
                System.out.println(Setting.text_for_button_eng_or_rus);
                super.touchUp(event, x, y, pointer, button);
            }
        });
        */
        _2x2 = new TextButton("2x2", Assets.skin);
        _2x2.setPosition(difficulty.getX() + difficulty.getWidth(), difficulty.getY());
        _2x2.setHeight(difficulty.getHeight());

        _3x3 = new TextButton("3x3", Assets.skin);
        _3x3.setPosition(_2x2.getX() + _2x2.getWidth(), _2x2.getY());
        _3x3.setHeight(_2x2.getHeight());

        close = new ImageButton(Assets.skin, "close");
        close.setPosition(0, 0);
        close.setSize(Coords.cellWidth / 10, Coords.cellRatioY / 10);
        close.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new MainScreen(game));
                super.touchUp(event, x, y, pointer, button);
            }
        });


        stage = new Stage(new FillViewport(Coords.cellWidth, Coords.cellRatioY));
        //stage.addActor(language);
        stage.addActor(difficulty);
        stage.addActor(_2x2);
        stage.addActor(_3x3);
        //stage.addActor(eng_rus);
        stage.addActor(close);

        Gdx.input.setInputProcessor(stage);

    }

    private void update(){
        //calling is 60 event on 1 second, it is a bad realisation selected

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
        //dispose();
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
