public class Player extends Entity {
    //Starting player stats
    final Double START_ATTACK = 2.5;
    final Double START_HEALTH = 20.0;
    //constructor
    public Player(){
        super();
        setAttack(START_ATTACK);
        setHealth(START_HEALTH);
    }
}
