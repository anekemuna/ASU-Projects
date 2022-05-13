//-----------------------------------------------------------------------------------------
// AUTHOR:        Munachimso Aneke
// FILENAME:      Lab5.java
// SPECIFICATION: This program is for practicing nested loops.
//                It prints out a certain size of pyramid and triangle of stars
// LAB LETTER:    H
//---------------------------------------------------------------------------------------------

import java.util.Scanner;

public class Lab5
{
    public static void main(String [] args)
    {
        // constants
        final int PYRAMID = 1;
        final int TRIANGLE = 2;
        final int QUIT = 3;

        Scanner in = new Scanner(System.in); //scanner object

        int choice, size = 0;

        do {
            System.out.println("This program does the following:"); //display option
            System.out.println("1. Print a PYRAMID.");
            System.out.println("2. Print a TRIANGLE.");
            System.out.println("3. Quit");

            System.out.println("\nPlease select an option: "); //read in an option
            choice = in.nextInt();

            switch (choice)
            {
                case PYRAMID:
                    System.out.println("Please input the pyramid height: ");
                    size = in.nextInt();
                    for(int i = 0; i < size; i++)
                    {
                        for(int j = 0; j <= i; j++)
                        {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case TRIANGLE:
                    System.out.println("Please input the pyramid height: ");
                    size = in.nextInt();
                    int k = size;

                    for(int i = 0; i < size; i++)
                    {
                        for(int j = 0; j < k; j++)
                        {
                            System.out.print(" ");
                        }
                        k--;

                        for (int j = 0; j <= i; j++)
                        {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case QUIT:
                    System.out.println("Quitting the program as you requested...");
                    break;
                default:
                    System.out.println("Please choose again");
            }

        }while(choice != QUIT);

        in.close();
    }
}
