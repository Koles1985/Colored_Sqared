package com.gamelabfedorovich.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.gamelabfedorovich.Assets;
import com.gamelabfedorovich.math.Coords;

public class MainScreen implements Screen {
    private Game game;
    private SpriteBatch batch;
    private OrthographicCamera guiCam;
    private TextButton play;
    private TextButton setting;
    private Label label;
    private Stage stage;



    public MainScreen(Game game){
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        guiCam = new OrthographicCamera();
        guiCam.setToOrtho(false, Coords.cellWidth, Coords.cellRatioY);


        play = new TextButton("Play", Assets.skin);
        play.setPosition(Coords.centerX - play.getWidth() / 2 - 20,
                Coords.centerY - play.getHeight() / 2 + 10);

        setting = new TextButton("Setting", Assets.skin);
        setting.setPosition(Coords.centerX - setting.getWidth() / 2 - 20,
                play.getY() - setting.getHeight());

        label = new Label("Colored Squared", Assets.skin, "title");
        label.setPosition(Coords.centerX - label.getWidth() / 2,
                Coords.cellHeight - label.getHeight() - 50);

        System.out.println(play.getWidth());

        stage = new Stage(new FillViewport(Coords.cellWidth, Coords.cellRatioY));
        stage.addActor(play);
        stage.addActor(setting);
        stage.addActor(label);

        Gdx.input.setInputProcessor(stage);


    }

    private void update(float delta){
        guiCam.update();

        if(play.isPressed()){
            game.setScreen(new GameScreen(game));
        }
        if(setting.isPressed()){
            game.setScreen(new SettingScreen(game));
        }
    }

    @Override
    public void render(float delta) {
        GL20 gl = Gdx.graphics.getGL20();
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update(delta);
        batch.setProjectionMatrix(guiCam.combined);
        batch.begin();
        batch.draw(Assets.background, 0,0, Coords.cellWidth, Coords.cellRatioY);
        batch.end();
        stage.act(delta);
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
        stage.dispose();
        label.remove();
        play.remove();
        setting.remove();
    }
}
