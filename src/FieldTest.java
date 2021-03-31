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

}
