public abstract class Entity {

    //Every entity should have these
    protected Double health;
    protected Double attack;
    protected Boolean alive;

    //constructor
    public Entity(){
        setAlive(true);
    }


    //Setters
    public void setHealth(Double healthModify){
        this.health = healthModify;
    }
    public void setAttack(double attackModify){
        this.attack = attackModify;
    }
    public void setAlive(Boolean status){
        this.alive = status;
    }

    //Getters
    public Double gethealth(){
        return health;
    }
    public Double getAttack(){
        return attack;
    }

}
