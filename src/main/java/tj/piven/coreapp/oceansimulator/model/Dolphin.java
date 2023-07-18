package tj.piven.coreapp.oceansimulator.model;

public class Dolphin {

    private int health = 100;
    private int energy = 100;
    private final double FINS = 10.5;


    public void setHealth(int health) {this.health = health;}
    public int getHealth (){
        return health;
    }
    public void setEnergy (int energy) {this.energy = energy;}

    public int getEnergy() {
        return energy;
    }


    public double getFINS() {
        return FINS;
    }


}


