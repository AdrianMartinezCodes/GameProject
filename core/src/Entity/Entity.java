package Entity;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Entity {
    TextureAtlas atlas = new TextureAtlas("Pack/NullExemptPack.atlas");
    //Every entity should have these
    protected Double health;
    protected Double attack;
    protected Boolean alive;
    protected Integer xCord;
    protected Integer yCord;
    protected Animation<TextureRegion> idleAnimation;

    //constructor
    public Entity(){
        setAlive(true);
    }

    public Entity(Integer xCord,Integer yCord){
        setAlive(true);
        setXCord(xCord);
        setYCord(yCord);
    }


    //Setters
    public void setHealth(Double healthModify){
        this.health = healthModify;
    }
    public void setAttack(Double attackModify){
        this.attack = attackModify;
    }
    public void setAlive(Boolean status){
        this.alive = status;
    }

    public void setXCord(Integer xCord){
        this.xCord = xCord;
    }

    public void setYCord(Integer yCord){
        this.yCord = yCord;
    }

    public void setIdleAnimation(float Frames,String filePath){
        idleAnimation = new Animation<TextureRegion>(Frames,
                atlas.findRegions(filePath), Animation.PlayMode.LOOP);
    }

    //Getters
    public Double getHealth(){
        return health;
    }
    public Double getAttack(){
        return attack;
    }

    public Integer getxCord(){
        return xCord;
    }

    public Integer getyCord(){
        return yCord;
    }

    public Boolean isAlive(){
        return alive;
    }

    public TextureRegion getIdleAnimationKeyFrame(float time, Boolean bool){
        return idleAnimation.getKeyFrame(time,bool);
    }
    //TextureRegion playerFrame =
    //                game.player.idleAnimation.getKeyFrame(game.stateTime,true);

}
