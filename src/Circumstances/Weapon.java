package Circumstances;

import Apoc.Runner;
import People.Person;

public class Weapon extends Circumstance  {
    public Weapon (int weaponx, int weapony) {
        super(weaponx, weapony);



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
        System.out.println("You have found a weapon that you can use to kill a zombie.");

    }


}