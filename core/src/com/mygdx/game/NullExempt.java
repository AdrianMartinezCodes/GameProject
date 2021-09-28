package com.mygdx.game;

import Entity.Mob;
import Entity.Player;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class NullExempt extends Game {
	ShapeRenderer shapeRenderer;

	SpriteBatch batch;
	BitmapFont font;
	TextureAtlas atlas;
	SpriteBatch spriteBatch;
	Player player;
	float stateTime;
	Mob slime;

	@Override
	public void create () {
		float PLAYER_FRAMES = 0.33f;
		float MOB_FRAMES = .15f;
		player = new Player();
		slime = new Mob();
		batch = new SpriteBatch();
		font = new BitmapFont();
		player.setMovements(PLAYER_FRAMES, "run");
		player.setIdleAnimation(PLAYER_FRAMES,"player-idle");
		slime.setIdleAnimation(MOB_FRAMES,"slime");
		stateTime = 0f;
		setScreen(new TitleScreen(this));
	}

	@Override
	public void dispose () {
		batch.dispose();
		shapeRenderer.dispose();
		font.dispose();
		spriteBatch.dispose();
		atlas.dispose();
	}
}
