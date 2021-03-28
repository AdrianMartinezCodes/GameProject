import java.util.zip.DeflaterInputStream;

public abstract class Entity {

    //Every entity should have these
    protected Double health;
    protected Double attack;
    protected Boolean alive;
    protected Integer xCord;
    protected Integer yCord;

    //constructor
    public Entity(){
        setAlive(true);
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

}
