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
        assertEquals(StartingHealth, player.gethealth());
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
}
