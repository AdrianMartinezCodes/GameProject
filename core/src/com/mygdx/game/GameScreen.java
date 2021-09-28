package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameScreen extends ScreenAdapter {

    NullExempt game;
    public GameScreen(NullExempt game) {
        this.game = game;
    }

    @Override
    public void show() {
        game.player.setXCord(50);
        game.player.setYCord(50);
        game.slime.setYCord(100);
        game.slime.setXCord(100);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        game.stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion playerFrame =
                game.player.getIdleAnimationKeyFrame(game.stateTime,true);
        TextureRegion slimeFrame =
                game.slime.getIdleAnimationKeyFrame(game.stateTime,true);


        game.player.UpdatePlayer(delta);
        game.batch.begin();
        game.batch.draw(game.player.fm.getKeyFrame(game.stateTime,true),
                game.player.getxCord(), game.player.getyCord());
        //game.batch.draw((Texture) fm.getKeyFrame(statetime, loop), position.x, position.y);
        //game.batch.draw(playerFrame,game.player.getxCord(),game.player.getyCord());
        game.batch.draw(slimeFrame,game.slime.getxCord(),game.slime.getyCord());
        game.batch.end();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}
