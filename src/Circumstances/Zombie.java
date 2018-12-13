package Circumstances;

import Apoc.Runner;
import People.Person;

public class Zombie extends Circumstance {
    public Zombie (int zombx, int zomby) {
        super(zombx, zomby);



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
        System.out.println("There's a zombie!!!");

    }


}

