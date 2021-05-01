package Entity;

public class Mob extends Collisions {
    //constructor - Only care to make it alive, will have child that manipulate stats later
    public Mob(){
        super();
    }

    public Mob(Integer xCord, Integer yCord){
        super(xCord, yCord);
    }
}
