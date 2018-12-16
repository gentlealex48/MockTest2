package com.kkaty.mocktest2;

import java.util.*;
import java.util.Scanner;


public class InfectedClass
{


    public static boolean isInfected;
    public boolean visited = false;




    InfectedClass(boolean infected)
    {
        isInfected = infected;



    }

    public static void main(String[] args)
    {




        DisplayInfected();


    }


    public static  void DisplayInfected()
    {



        final int ROWS = 5;
        final int COLS = 5;
        boolean infected = false; //This variable would be true if the infected rooms are more or equal to five
        String[][] floor = new String[ROWS][COLS];


        floor[1][0] = "X";
        floor[1][2] ="X";
        floor[1][3] ="X";
        floor[2][0]="X";
        floor[3][0]="X";



        infected = IOutbreak(floor); // passing the "floor 2d array" to the IOubreak Method and return the infected variable.


        System.out.println("Is the number of infected rome above or equal to five (True or False)" + infected);


    }

    public static boolean IOutbreak(String[][] floor)
    {




        int[][] storeInfectedRoom = new int[floor.length][floor[0].length]; //this 2darray stores the amount of room that have been infected
        int infectedIndicator = 1; //This variable is stored in a box in the "storeInfected 2d array", to indicate which room is infected.
        int limit = 5;

        //Searching horizontally for any infected rooms
        for(int row = 0; row <floor.length; row++)
        {
            for(int col = 0; col <floor[row].length; col++)
            {
                if(col<(floor[row].length -1))
                {
                    int forwardCol = col + 1;
                    if(floor[row][col] != null && floor[row][forwardCol] != null)
                    {
                        storeInfectedRoom[row][col] = infectedIndicator;
                        storeInfectedRoom[row][forwardCol] = infectedIndicator;
                    }
                }else if(col == (floor[row].length -1))
                {
                    int reverseCol = col - 1;
                    if(floor[row][col] != null && floor[row][reverseCol] != null)
                    {
                        storeInfectedRoom[row][col] = infectedIndicator;
                    }

                }

            }

        }


        //Searching Vertically for any infected rooms
        for(int col= 0; col < storeInfectedRoom[0].length; col++)
        {
            for(int row = 0; row <storeInfectedRoom.length; row++)
            {
                if(row <(floor.length -1))
                {
                    int forwardRow = row + 1;
                    if(floor[row][col] != null  && floor[forwardRow][col] != null)
                    {
                        storeInfectedRoom[row][col] = infectedIndicator;
                        storeInfectedRoom[forwardRow][col] = infectedIndicator;

                    }

                }else if(row == (floor.length -1))
                {

                    int reverseRow = row - 1;
                    if(floor[row][col] != null && floor[reverseRow][col] != null)
                    {

                        storeInfectedRoom[row][col] = infectedIndicator;

                    }

                }


            }

        }

        int totalInfected = 0;

        for(int row = 0; row < storeInfectedRoom.length; row++)
        {
            for(int col = 0; col < storeInfectedRoom[row].length; col++)
            {

                totalInfected += storeInfectedRoom[row][col];

            }


        }

        //The variable isInfected  would be true if the infected rooms are more or equal to five
        if(totalInfected >= limit)
        {
            isInfected = true;
        }
        else
        {
            isInfected = false;
        }

        return isInfected;
    }

}
