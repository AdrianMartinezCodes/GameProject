package Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

    public enum state {
        idling,
        walking,
        dying
    }

    public enum direction {
        left,
        right,
        up,
        down
    }

    TextureAtlas atlas = new TextureAtlas("Pack/NullExemptPack.atlas");
    //Every entity should have these
    protected Double health;
    protected Double attack;
    protected Boolean alive;
    protected Integer xCord;
    protected Integer yCord;
    protected Animation<TextureRegion> idleAnimation;

    protected TextureRegion left;
    protected TextureRegion right;
    protected TextureRegion up;
    protected TextureRegion down;
    protected Animation<TextureRegion> Walkingleft;
    protected Animation<TextureRegion> WalkingRight;
    protected Animation<TextureRegion> WalkingUp;
    protected Animation<TextureRegion> WalkingDown;

    protected static float speedmax = 30f;
    protected static float damping = 0.9f;
    protected direction dir;

    //constructor
    public Entity() {
        setAlive(true);
    }

    public Entity(Integer xCord, Integer yCord) {
        setAlive(true);
        setXCord(xCord);
        setYCord(yCord);
    }


    //Setters
    public void setHealth(Double healthModify) {
        this.health = healthModify;
    }

    public void setAttack(Double attackModify) {
        this.attack = attackModify;
    }

    public void setAlive(Boolean status) {
        this.alive = status;
    }

    public void setXCord(Integer xCord) {
        this.xCord = xCord;
    }

    public void setYCord(Integer yCord) {
        this.yCord = yCord;
    }




    public void setIdleAnimation(float Frames,String filePath){
        idleAnimation = new Animation<TextureRegion>(Frames,
                atlas.findRegions(filePath), Animation.PlayMode.LOOP);
    }

    public void setMovements(float Frames, String filepath) {
        left = atlas.findRegion( filepath + "Left");
        right = atlas.findRegion(filepath + "Right");
        up = atlas.findRegion(filepath + "Up");
        down = atlas.findRegion(filepath + "Down");

        Walkingleft = new Animation<>(Frames, left);
        WalkingRight = new Animation<>(Frames, right);
        WalkingUp = new Animation<>(Frames, up);
        WalkingDown = new Animation<>(Frames, down);
    }

    //Getters
    public Double getHealth() {
        return health;
    }

    public Double getAttack() {
        return attack;
    }

    public Integer getxCord() {
        return xCord;
    }

    public Integer getyCord() {
        return yCord;
    }

    public Boolean isAlive() {
        return alive;
    }

    public TextureRegion getIdleAnimationKeyFrame(float time, Boolean bool) {
        return idleAnimation.getKeyFrame(time, bool);
    }



    public Vector2 position = new Vector2();
    public Vector2 speed = new Vector2();
    state st = state.walking;

    public float statetime = 0;

    public void UpdatePlayer(float deltatime) {
        if (deltatime == 0) return;
        statetime += deltatime;
        //rightwalking
        if (Math.abs(speed.x) > speedmax) {
            speed.x = Math.signum(speed.x) * speedmax;
            if (dir != direction.left) {
                dir = direction.right;
            }
            st = state.walking;
        }

        if (Math.abs(speed.x) < 1) {
            speed.x = 0;
            if (st != state.walking) st = state.idling;
            dir = direction.right;
        }
        //upwalking
        if (Math.abs(speed.y) > speedmax) {
            speed.y = Math.signum(speed.y) * speedmax;
            if (dir != direction.down) {
                dir = direction.up;
            }
            st = state.walking;
        }

        if (Math.abs(speed.y) < 1) {
            speed.y = 0;
            if (st != state.walking) st = state.idling;
            dir = direction.up;
        }

        if (Math.abs(-speed.x) > speedmax) {
            speed.x = Math.signum(-speed.x) * speedmax;
            if (dir != direction.right) {
                dir = direction.left;
            }
            st = state.walking;
        }
        if (Math.abs(-speed.x) < 1) {
            speed.x = 0;
            if (st != state.walking) st = state.idling;
            dir = direction.up;
        }

        if (Math.abs(-speed.y) > speedmax) {
            speed.y = Math.signum(-speed.y) * speedmax;
            if (dir != direction.up) {
                dir = direction.down;
            } 
            st = state.walking;
        }
        if (Math.abs(-speed.y) < 1) {
            speed.y = 0;
            if (st != state.walking) st = state.idling;
            dir = direction.down;
        }

        speed.scl(deltatime);

        position.add(speed);
        speed.scl(1 / deltatime);

        // Apply damping to the velocity on the x-axis so we don't
        // walk infinitely once a key was pressed
        speed.x *= damping;
        speed.y *= damping;

        InputProcess();
    }

    public Animation<TextureRegion> fm = null;
    public void drawMob(float deltatime) {
        boolean loop = true;

        switch (st) {
            case idling:
                if (speed.y == 0) {
                    fm = idleAnimation;
                } else if (-speed.y == 0) {
                    fm = idleAnimation;
                } else if (speed.x == 0) {
                    fm =idleAnimation;
                } else if (-speed.x == 0) {
                    fm = idleAnimation;
                }
                break;
            case walking:
                if (speed.y > speedmax) {
                    fm = WalkingUp;
                } else if (-speed.y > speedmax) {
                    fm = WalkingDown;
                } else if (speed.x > speedmax) {
                    fm = WalkingRight;
                } else if (-speed.x > speedmax) {
                    fm = Walkingleft;
                }
                break;
            case dying:
                break;
            default:
                break;
        }


    }

    public void InputProcess() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
            if (st != state.idling) st = state.walking;
            speed.y += speedmax;
            dir = direction.up;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
            if (st != state.idling) st = state.walking;
            speed.y = -speedmax;
            dir = direction.down;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            if (st != state.idling) st = state.walking;
            speed.x = -speedmax;
            dir = direction.left;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            if (st != state.idling) st = state.walking;
            speed.x += speedmax;
            dir = direction.right;
        } else {
            st = state.idling;
            speed.x = 0;
            speed.y = 0;
        }
    }
}
