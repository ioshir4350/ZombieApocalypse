package Circumstances;

import Apoc.Runner;
import People.Person;

public class Helicopter extends Circumstance {
    public Helicopter(int x, int y) {
        super(x, y);

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
        System.out.println("You have reached the helicopter! You will now be taken to the nearest evacuation camp.");
        Runner.gameOff();
    }


}