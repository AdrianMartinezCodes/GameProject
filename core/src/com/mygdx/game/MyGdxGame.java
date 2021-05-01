package com.mygdx.game;

import Entity.Mob;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MyGdxGame extends Game {
	ShapeRenderer shapeRenderer;
	float circleX = 200;
	float circleY = 100;

	Random rand = new Random(System.nanoTime());
	ArrayList<Mob> circles;
	SpriteBatch batch;
	BitmapFont font;


	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();
		circles = new ArrayList<>(10);
		for(int i = 0; i < 10; i++){
			circles.add(new Mob(rand.nextInt(800),rand.nextInt(400)));
		}
		batch = new SpriteBatch();
		font = new BitmapFont();

	}

	@Override
	public void render () {

		if (Gdx.input.isTouched()) {
			circleX = Gdx.input.getX();
			circleY = Gdx.graphics.getHeight() - Gdx.input.getY();
		}

		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			circleY++;
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.S)){
			circleY--;
		}

		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			circleX--;
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			circleX++;
		}

		Gdx.gl.glClearColor(.25f,.25f,.25f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(1, 1, 4, 1);
		/*Mob mob = circles.get(0);
		if(mob.isAlive()){
			shapeRenderer.circle(mob.getxCord(), mob.getyCord(), 15);
		}
		if(circleX == mob.getxCord() || circleY == mob.getyCord()){
			circles.get(0).setAlive(false);
		}*/
		for(int i = 0; i < 10; i++) {
			Mob mob = circles.get(i);
			int x = (int)rand.nextGaussian();
			int y = (int) rand.nextGaussian();
			if(mob.getxCord()< 0 || mob.getxCord() > Gdx.graphics.getHeight()){
				x *= -1;
				//circles.get(i).setXCord(mob.getxCord() * -1);
			}
			if(mob.getyCord() < 0 || mob.getyCord() > Gdx.graphics.getWidth()){
				y *= -1;
				//circles.get(i).setYCord(mob.getyCord() * -1);
			}
			circles.get(i).setXCord(mob.getxCord() + x);
			circles.get(i).setYCord(mob.getyCord() + y);

			shapeRenderer.circle(mob.getxCord() , mob.getyCord(), 15);
			StringBuilder string = new StringBuilder();
			string.append("X: ").append(mob.getxCord()).append(" ").append("Y: ").append(mob.getyCord());
			batch.begin();
			font.draw(batch, string , circles.get(i).getxCord(),
					circles.get(i).getyCord());
			batch.end();

		}
		/*for(int i = 0; i < 10; i++){
			Mob mob = circles.get(i);
			if((circleX == mob.getxCord() && (circleY == mob.getyCord()))){
				circles.get(i).setAlive(false);
			}
			if(mob.isAlive()){
				shapeRenderer.circle(mob.getxCord(), mob.getyCord(), 15);
			}
		}/*

		/*shapeRenderer.circle(200, 70, 15);
		shapeRenderer.circle(300, 400, 15);
		shapeRenderer.circle(100, 100, 15);
		shapeRenderer.circle(80, 300, 15);*/
		shapeRenderer.end();


		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(0, 1, 0, 1);
		shapeRenderer.circle(circleX, circleY, 25);
		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		shapeRenderer.dispose();
	}
}
