package Circumstances;

import People.Person;

public class Circumstance {
        Person occupant;
        int xLoc,yLoc;

        public Circumstance(int x, int y)
        {
            xLoc = x;
            yLoc = y;
        }

        /**
         * Method controls the results when a person enters this room.
         * @param x the Person entering
         */
        public void enterCircumstance(Person x)
        {
            System.out.println("You moved.");
            occupant = x;
            x.setxLoc(this.xLoc);
            x.setyLoc(this.yLoc);
        }

        /**
         * Removes the player from the room.
         * @param x
         */
        public void leaveCircumstance(Person x)
        {
            occupant = null;
        }

    }

