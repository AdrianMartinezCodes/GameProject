package Entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FieldTest {
    Field field;
    Player player;
    Mob mob;
    @Before
    public void setup(){
        field = new Field();
        player = new Player();
        mob = new Mob();
    }

    @Test
    public void addPlayer(){
        assertTrue(field.generateEntity(player));
    }

    @Test
    public void addMob(){
        assertTrue(field.generateEntity(mob));
    }

    @Test
    public void checkPopulationOne(){
        field.generateEntity(player);
        assertEquals(1,field.population);
    }

    @Test
    public void fieldFull(){
        Field smallField = new Field(2,2);
        for(int i = 0; i < field.maxPopulation; i++){
            field.generateEntity(new Mob());
        }
        assertTrue(field.fieldIsFull());
    }

    @Test
    public void fieldNotFull(){
        assertFalse(field.fieldIsFull());
    }

    @Test
    public void movePlayer(){
        field.generateEntity(player);
        assertTrue(field.updateEntityLocation(player,3,4));
    }

    @Test
    public void moveMob(){
        field.generateEntity(mob);
        assertTrue(field.updateEntityLocation(mob,3,4));
    }

    @Test
    public void movePlayerCheckCoords(){
        field.generateEntity(player);
        field.updateEntityLocation(player,3,4);
        assertEquals(3,(int)player.getxCord());
        assertEquals(4, (int)player.getyCord());
    }

    @Test
    public void moveMobCheckCoords(){
        field.generateEntity(mob);
        field.updateEntityLocation(mob,3,4);
        assertEquals(3,(int) mob.getxCord());
        assertEquals(4,(int) mob.getyCord());
    }

}
