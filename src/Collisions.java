/*
* This file will be used for player vs mob interactions(i.e a collision between the player
* entity and mob entity).
*
 */

import java.util.Random;

public class Collisions {
    /*
    * Initiates EntityOne attack on EntityTwo
    * Chance to miss based on normal distribution(0,1). Attack is intiated
    * on value >= 0.5.
    * TODO: add a way to modify miss chance(maybe luck stat or base off of defence).
     */

    Random rand = new Random();

    public boolean InitiateAttack(Entity EntityOne, Entity EntityTwo){
        Double entityOneMiss = rand.nextGaussian();
        Double CHANCE_TO_MISS = 0.5;

        if(entityOneMiss < CHANCE_TO_MISS){ return false; }
        else{
            Double updatedMobHealth = EntityTwo.gethealth() - EntityOne.getAttack();
            EntityTwo.setHealth(updatedMobHealth);
            return true;
        }

    }

}
