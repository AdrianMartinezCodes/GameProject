public abstract class Entity {

    //Every entity should have these
    Double health;
    Double attack;
    Boolean alive;

    //Setters
    public void setHealth(Double healthModify){
        this.health = healthModify;
    }
    public void setAttack(double attackModify){
        this.attack = attackModify;
    }
    public void setDeathStatus(){
        this.alive = false;
    }

    //Getters
    public Double gethealth(){
        return health;
    }
    public Double getAttack(){
        return attack;
    }

    public void entityDeath(){
        if(health <= 0){
            setDeathStatus();
        }
    }
}
