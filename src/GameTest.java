import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    //Testing for Player entity creation
    @Test
    public void testPlayerCreation(){
        Player player = new Player();
        Double StartingAttack = 2.5;
        Double StartingHealth = 20.0;
        assertEquals(StartingAttack,player.getAttack());
        assertEquals(StartingHealth, player.getHealth());
    }

    //Testing for Mob entity creation
    @Test
    public void testMobCreation(){
        Mob mob = new Mob();
        assertTrue(mob instanceof Entity);
        Double attack = 2.0;
        mob.setAttack(attack);
        assertEquals(attack,mob.getAttack());

    }

    @Test
    public void checkValueAfterAttack(){
        Mob mob1 = new Mob();
        Mob mob2 = new Mob();
        mob1.setAttack(10.0);
        mob2.setHealth(13.0);
        assertTrue(mob1.initiateAttack(mob2));
        assertEquals((Double)3.0,mob2.getHealth());
        //
    }


}
