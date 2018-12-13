package Circumstances;

import Apoc.Runner;
import People.Person;

public class HealthPacks extends Circumstance  {
    public HealthPacks (int healthx, int healthy) {
        super(healthx, healthy);



    }


    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterCircumstance(Person x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You have acquired a health kit. You can use it to heal.");

    }


}