package com.gamelabfedorovich.gui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GuiTextButton extends Actor {
    private TextButton button;

    private GuiTextButton(){

    }

    public GuiTextButton(String text, Skin skin){
        this.button = getButton(text, skin);
        setHeightAndWidth(this.button);
        //isTouchable();
        System.out.println(isTouchable());
        clicked();
    }

    public GuiTextButton(String text, Skin skin, String styleName){
        this.button = getButton(text, skin, styleName);
        setHeightAndWidth(this.button);
    }
    public GuiTextButton(String text,  TextButton.TextButtonStyle style){
        this.button = getButton(text, style);
        setHeightAndWidth(this.button);
    }

    private TextButton getButton(String text, Skin skin){
        return new TextButton(text, skin);
    }

    private TextButton getButton(String text, Skin skin, String styleName){
        return new TextButton(text, skin, styleName);
    }

    private TextButton getButton(String text, TextButton.TextButtonStyle style){
        return  new TextButton(text, style);
    }

    private void setHeightAndWidth(TextButton button){
        setWidth(button.getWidth());
        setHeight(button.getHeight());
    }

    public void setText(String text){
        this.button.setText(text);
    }

    @Override
    public void setPosition(float x, float y) {
        //super.setPosition(x, y);
        this.button.setPosition(x, y);
        setBounds(this.button.getX(), this.button.getY(), this.button.getWidth(),
                this.button.getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        this.button.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {

    }

    public void clicked(){
        addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Clicked");
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
}
