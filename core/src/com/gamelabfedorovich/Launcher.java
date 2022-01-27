package com.gamelabfedorovich;


import com.badlogic.gdx.Game;
import com.gamelabfedorovich.math.Coords;
import com.gamelabfedorovich.screens.MainScreen;

public class Launcher extends Game {
	@Override
	public void create() {
		Assets.load();
		Coords.getCoords();
		Setting.load();
		setScreen(new MainScreen(this));
	}

	@Override
	public void dispose() {
		getScreen().dispose();
		super.dispose();
	}
}
