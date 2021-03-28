public class Player extends Collisions {
    //Starting player stats
    final private  Double START_ATTACK = 2.5;
    final private  Double START_HEALTH = 20.0;
    //constructor
    public Player(){
        super();
        setAttack(START_ATTACK);
        setHealth(START_HEALTH);
    }
}
