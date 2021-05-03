package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;


public class TitleScreen extends ScreenAdapter {

    NullExempt game;

    public TitleScreen(NullExempt game) {
        this.game = game;
    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                    game.setScreen(new GameScreen(game));
                }
                return true;
            }
        });
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, .25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        for(int i = 0; i < Gdx.graphics.getWidth(); i = i +16){
            for(int j = 0; j < Gdx.graphics.getHeight(); j+= 16){
                if(i*j%3 == 0){
                    game.batch.draw(game.splitTiles[6][0],i,j);
                }
                else{
                    game.batch.draw(game.splitTiles[5][1],i,j);
                }
            }
        }
        game.font.draw(game.batch, "FPS" + Gdx.graphics.getFramesPerSecond(),10,20);
        game.font.draw(game.batch, "Press space to play.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .25f);
        game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }

}
