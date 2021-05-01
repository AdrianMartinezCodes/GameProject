package Entity;/*
* This file will be used for player vs mob interactions(i.e a collision between the player
* entity and mob entity).
*
 */

import java.util.Random;

public class Collisions extends Entity{
    /*
    * Initiates EntityOne attack on EntityTwo
    * Chance to miss based on normal distribution(0,1). Attack is intiated
    * on value >= 0.5.
    * TODO: add a way to modify miss chance(maybe luck stat or base off of defence).
     */

    public Collisions(){
        super();
    }
    public Collisions(Integer xCord, Integer yCord){
        super(xCord, yCord);
    }
    private static final Random rand = new Random();

    public boolean initiateAttack(Entity EntityTwo){
        double entityOneMiss = rand.nextGaussian();
        double CHANCE_TO_MISS = 0.5;

        if(entityOneMiss < CHANCE_TO_MISS){ return false; }
        else{
            Double updatedMobHealth = EntityTwo.getHealth() - getAttack();
            EntityTwo.setHealth(updatedMobHealth);
            return true;
        }
    }

}
