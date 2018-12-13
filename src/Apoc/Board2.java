package Apoc;

public class Board2 {
    private String secondfloor[][];

    public Board2(String[][] secondfloor) {
        this.secondfloor = secondfloor;
    }


    public void fill(String str) {
        for (int row = 0; row < secondfloor.length; row++)
        {
            for (int column = 0; column < secondfloor[row].length;column++)
            {
                secondfloor[row][column]=str;
            }
        }
    }
    public void edit(String replace, int row, int column)
    {

        secondfloor[row][column] = replace;
    }



    public String toString(){
        String board2 = "";
        for (int row = 0; row < secondfloor.length; row++)
        {
            for (int column = 0; column < secondfloor[row].length; column++)
            {

                board2 = board2 + secondfloor[row][column];
            }
            board2=board2+"\n";
        }
        return board2;
    }
}


