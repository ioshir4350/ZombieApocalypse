package Apoc;

import People.Person;
import Circumstances.Circumstance;
import Circumstances.HealthPacks;
import Circumstances.Zombie;
import Circumstances.Weapon;
import Circumstances.Helicopter;

import java.util.Scanner;

public class Runner {

        private static boolean gameOn = true;

        public static void main(String[] args)
        {
            Circumstance[][] secondfloor1 = new Circumstance[5][8];

            //Fill the building with normal rooms
            for (int x = 0; x<secondfloor1.length; x++)
            {
                for (int y = 0; y < secondfloor1[x].length; y++)
                {
                    secondfloor1[x][y] = new Circumstance(x,y);
                }
            }
            //Display array
            String[][] secondfloor = new String[5][8];
            Board2 board2 = new Board2(secondfloor);
            board2.fill("X");
            board2.edit("P", 4,0);
            board2.edit("H", 0,7);
            System.out.println(board2);


            //Create a random winning room.

            //Zombie Locations
            int zombx = (int) (Math.random() * secondfloor1.length);
            int zomby = (int) (Math.random() * secondfloor1.length);
            if((zombx != 7) && (zomby != 0)) {
                secondfloor1[zombx][zomby] = new Zombie(zombx, zomby);
            }
            //Health Pack Locations
            int healthx = (int) (Math.random() * secondfloor1.length);
            int healthy = (int) (Math.random() * secondfloor1.length);
            if((healthx != 7) && (healthy != 0)) {
                secondfloor1[healthx][healthy] = new HealthPacks(healthx, healthy);
            }
            //Weapon Locations
            int weaponx = (int) (Math.random() * secondfloor1.length);
            int weapony = (int) (Math.random() * secondfloor1.length);
            System.out.println(weaponx);
            System.out.println(weapony);
            if((weaponx != 7) && (weapony != 0)) {
                secondfloor1[weaponx][weapony] = new Weapon(weaponx, weapony);
            }



            //Setup player 1 and the input scanner
            Person player1 = new Person("FirstName", "FamilyName", 0,0);
            secondfloor1[4][0].enterCircumstance(player1);
            Scanner in = new Scanner(System.in);
            while(gameOn)
            {
                System.out.println("Where would you like to move? (Choose a, s, d, w)");
                String move = in.nextLine();
                if(validMove(move, player1, secondfloor1))
                {
                    System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
                    board2.fill("X");
                    board2.edit("P", player1.getxLoc(),player1.getyLoc());
                    board2.edit("H", 0,7);
                    System.out.println(board2);
                }
                else {
                    System.out.println("Please choose a valid move.");
                }


            }
            in.close();
        }

        /**
         * Checks that the movement chosen is within the valid game map.
         * @param move the move chosen
         * @param p person moving
         * @param map the 2D array of rooms
         * @return
         */
        public static boolean validMove(String move, Person p, Circumstance[][] map)
        {
            move = move.toLowerCase().trim();
            switch (move) {
                case "w":
                    if (p.getxLoc() > 0)
                    {
                        map[p.getxLoc()][p.getyLoc()].leaveCircumstance(p);
                        map[p.getxLoc()-1][p.getyLoc()].enterCircumstance(p);
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                case "d":
                    if (p.getxLoc()< map[p.getxLoc()].length)
                    {
                        map[p.getxLoc()][p.getyLoc()].leaveCircumstance(p);
                        map[p.getxLoc()][p.getyLoc() + 1].enterCircumstance(p);
                        return true;
                    }
                    else
                    {
                        return false;
                    }

                case "s":
                    if (p.getxLoc() < map.length - 1)
                    {
                        map[p.getxLoc()][p.getyLoc()].leaveCircumstance(p);
                        map[p.getxLoc()+1][p.getyLoc()].enterCircumstance(p);
                        return true;
                    }
                    else
                    {
                        return false;
                    }

                case "a":
                    if (p.getyLoc() > 0)
                    {
                        map[p.getxLoc()][p.getyLoc()].leaveCircumstance(p);
                        map[p.getxLoc()][p.getyLoc()-1].enterCircumstance(p);
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                default:
                    break;

            }
            return true;
        }
        public static void gameOff()
        {
            gameOn = false;
        }



    }