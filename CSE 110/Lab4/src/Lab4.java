//-----------------------------------------------------------------------------------
// AUTHOR: Munachimso Aneke
// FILENAME: Lab4.java
// SPECIFICATION: This program is for practicing the switch statement, do-while, while, and for loops.
//                Using a while calculate the sum of integers from 1 to n.
//                Using a for loop find the factorial of n
// LAB LETTER:   H
//-----------------------------------------------------------------------------------

import java.util.Scanner;

public class Lab4
{
    public static void main(String[] args)
    {
        /* Declare constants*/
        final int SUM = 1;
        final int FACTORIAL = 2;
        final int FACTORS = 3;
        final int QUIT = 4;

        int choice; // choice- user input

        Scanner in = new Scanner(System.in);

       do {
           System.out.println("This program does the following:");
           System.out.println("1. Sum of numbers from 1 to n: ");
           System.out.println("2. Factorial of n");
           System.out.println("3. Factors of n");
           System.out.println("4. Quit");
           System.out.println("Please choose an option ");

           choice = in.nextInt();
           int num;

           switch (choice)
           {

               case SUM:  // calculate the sum of 1-n
                   System.out.println("\nPlease enter a number n: ");
                   num = in.nextInt();
                   int sum = 0, count = 0; // sum:-result of sum, count:- loop counter

                   while( count < num)
                   {
                       count++; //update statement
                       sum = sum + count;
                   }

                   System.out.println("Sum of numbers from 1 - " + num + " is " + sum + "\n");
                   break;
               case FACTORIAL: // calculate  n!
                   System.out.println("\nPlease enter a number n: ");
                   num = in.nextInt();
                   long fact = 1; // long because int will result to overflow

                   for (int i = num; i > 1; i--)
                   {
                       fact = fact * i;
                   }

                   System.out.println("Factorial of " + num + " is " + fact + "\n");
                   break;
               case FACTORS:  // Calculate the factors of n
                   System.out.println("\nPlease enter a number n: ");
                   num = in.nextInt();
                   System.out.println("Factors of number " + num + " are");

                   for(int i = 1; i <= num; i++)
                   {
                       if((num%i == 0)) // checking if i is a factor of num
                       {
                           System.out.print( i + "  ");
                       }
                   }
                   System.out.println("\n");
                   break;
               case QUIT: // quit program option
                   System.out.println("Your choice was " + QUIT + " , Quitting the program, Have a good day!");
                   break;
               default:
                   System.out.println("Incorrect choice, " + choice + " Please choose again \n");
           }

       } while (choice != QUIT);
    }
}
