package Praktikum_11_22;

import java.util.Arrays;
import java.util.Random;

public class Creature {
    private int vitality;
    private boolean lovely;
    private String name;
    private Creature [] parentOf = new Creature[5];
    private int counter;
    private Random rand = new Random();

    Creature(String name){
        this.name = name;
        this.lovely = rand.nextBoolean();
        this.vitality = rand.nextInt(100);
        this.counter = 0;
    }
    Creature(int vitality, boolean lovely, String name){
        this.setVitality(vitality);
        this.lovely = lovely;
        this.name = name;
        this.counter = 0;
    }

    public int getVitality() {
        return vitality;
    }
    public boolean setVitality(int vitality) {
        if (vitality<=100 && vitality>=0) {
            this.vitality = vitality; 
            return true;
        }else{
            return false;
        }
    }
    public boolean isLovely() {
        return lovely;
    }
    public String getName() {
        return name;
    }

     @Override
    public String toString() {
        return "Creature [vitality=" + vitality + ", lovely=" + lovely + ", name=" + name + ", parentOf="
                + Arrays.toString(parentOf) + ", counter=" + counter + "]";
    }

    public boolean canJoin(Creature otherCreature){
        return this.vitality >= 50 && otherCreature.getVitality() >= 50 && this.counter <=5;
    }
    private boolean reduceVitality(){
        if (this.vitality >= 33) {
            this.vitality -= 33;
            return true;
        }
        return false;
        
    }
    public Creature join(Creature otherCreature){
        if (canJoin(otherCreature)) {
            this.parentOf[counter++] = new Creature(
                (this.vitality+otherCreature.getVitality())/2
                ,this.lovely = this.lovely ^ otherCreature.isLovely() ? rand.nextBoolean() : this.lovely
                ,this.name+otherCreature.getName());
            this.reduceVitality();
            return this.parentOf[counter-1];
        }
        return null;
    }

}
