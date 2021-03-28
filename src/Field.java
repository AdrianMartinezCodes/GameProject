import java.util.Random;

public class Field {

    int DEFAULT_X = 30;
    int DEFAULT_Y = 30;
    //the playing field
    Object[][] field;
    int xRange;
    int yRange;



    Random rand = new Random();

    public Field(){
        this.xRange = DEFAULT_X;
        this.yRange = DEFAULT_Y;
        field = new Object[xRange][yRange];

    }

    public Field(int xRange, int yRange) throws ArrayIndexOutOfBoundsException{
        if(xRange < 0 || yRange < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        this.xRange = xRange;
        this.yRange = yRange;
        field = new Object[xRange][yRange];
    }

    public void generateEntity(Entity entity){
        int xLocation = rand.nextInt(xRange);
        int yLocation = rand.nextInt(yRange);
        while(field[xLocation][yLocation] != null){
            xLocation = rand.nextInt(xRange);
            yLocation = rand.nextInt(yRange);
        }
    }

    public void updateEntityLocation(Entity entity, int xLocation, int yLocation){
        field[entity.getxCord()][entity.getyCord()] = null;
        field[xLocation][yLocation] = entity;
    }

}
