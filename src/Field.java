import java.util.HashMap;
import java.util.Random;

public class Field {
    //Default values
    int DEFAULT_X = 30;
    int DEFAULT_Y = 30;
    //the playing field
    Object[][] field;
    int xRange;
    int yRange;
    Random rand = new Random();
    //population keeps track of how populated the field is. Cannot exceed maxPopulation
    int maxPopulation;
    HashMap<Entity,Integer> entityMap;
    int population;

    /**
     * Initates a new Field based on default values of 30 x 30
     */
    public Field(){
        this.xRange = DEFAULT_X;
        this.yRange = DEFAULT_Y;
        field = new Object[xRange][yRange];
        maxPopulation = xRange * yRange;
        entityMap = new HashMap<>(maxPopulation);
    }

    /**
     * Initiates a new Field based on default xRange and yRange
     * @param xRange int representing width of the field
     * @param yRange int representing length of the field
     * @throws ArrayIndexOutOfBoundsException
     */
    public Field(int xRange, int yRange) throws ArrayIndexOutOfBoundsException{
        if(xRange < 0 || yRange < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        this.xRange = xRange;
        this.yRange = yRange;
        field = new Object[xRange][yRange];
        maxPopulation = xRange * yRange;
        entityMap = new HashMap<>(maxPopulation);
    }

    //public objectsInField

    /**
     * Adds an entity to the field at a random location
     * @param entity any object that extends the entity class
     * @return true if added, false if not
     */
    public boolean generateEntity(Entity entity){
        int xLocation = rand.nextInt(xRange);
        int yLocation = rand.nextInt(yRange);
        if(fieldIsFull()){
            return false;
        }
        do {
            xLocation = rand.nextInt(xRange);
            yLocation = rand.nextInt(yRange);
        }while (field[xLocation][yLocation] != null);
        entity.setXCord(xLocation);
        entity.setYCord(yLocation);
        entityMap.put(entity,1);
        population++;
        return true;
    }

    /**
     * Check if field is full
     * @return true if full, false if not
     */
    public boolean fieldIsFull(){
        //if population were to somehow exceed maxPopulation, returns false still
        return population >= maxPopulation;
    }

    /**
     * Updates an entity location based on x and y coordinates
     * @param entity
     * @param xLocation
     * @param yLocation
     * @return
     * @throws ArrayIndexOutOfBoundsException
     */
    public boolean updateEntityLocation(Entity entity, int xLocation, int yLocation) throws
            ArrayIndexOutOfBoundsException{
        if(xLocation < 0 || yLocation < 0 || xLocation > xRange || yLocation > yRange){
            throw new ArrayIndexOutOfBoundsException();
        }
        field[entity.getxCord()][entity.getyCord()] = null;
        field[xLocation][yLocation] = entity;
        entity.setXCord(xLocation);
        entity.setYCord(yLocation);
        return true;
    }

}
