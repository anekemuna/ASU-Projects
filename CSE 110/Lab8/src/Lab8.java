//---------------------------------------------------------------------------
// AUTHOR:        Munachimso Aneke
// FILENAME:      Lab8.java
// SPECIFICATION: This program is for practicing arrays.
// INSTRUCTIONS:  Read the following code skeleton and add your own code
//                according to the comments. Ask your TA or your class-
//                mates for help and/or clarification. When you see
//                //--> that is where you need to add code.
// LAB LETTER: H
//---------------------------------------------------------------------------

//importing Scanner class
import java.util.Scanner;

public class Lab8
{
    public static void main(String[] args)
    {
        //Define scan object of the type Scanner class
        Scanner in = new Scanner(System.in);

        //define an int variable <size>
        //int size;  // not used

        //Declare an integer array
        int [] int_arr;

        //Assign it memory location. Specify the dimension of the array(Let’s take 5)
        int_arr =  new int[5];

        //Using a for loop which runs till <size>, read values from the user and store it in the integer array.
        for (int i = 0; i < int_arr.length ; i++)
        {
            // Read the value the user enters
            System.out.println("Please enter value for index " + i + ":");
            //Assign it to the ith element of the array.
            int_arr[i] = in.nextInt();
        }

        //TASK 1
        //Using a for loop which runs till <size>, print all the values of the array and find the sum of all
        //  elements of the array.

        int sum = 0;
        for (int i = 0; i < int_arr.length ; i++)
        {
            // Print all the values of the array.
            System.out.println("Value at index " + i + ": " + int_arr[i]);

            // Add the element to sum
            sum += int_arr[i];
        }

        //Print the value of sum
        System.out.println("\nThe sum of all the elements of the array: " + sum);

        //TASK 2
        //Using the array that we’ve created, we’ll rotate the elements in the arrays.
        // Given an array, after computation the array will be with the elements "rotated left" so {1, 2, 3} yields
        //  {2, 3, 1}.

        //Store the last element: int last = int_arr[int_arr.length - 1];
        //int last = int_arr[int_arr.length - 1]; // not used

        //Store the first element: int first = int_arr[0];
        int first = int_arr[0];


        for(int i =0; i< int_arr.length -1; i++)
        {
            //Shift the elements one position upward.
            int_arr[i] = int_arr[i+1];
        }

        //Assign the last and first variables to their positions.
        int_arr[int_arr.length-1] = first;

        System.out.println("\nArray after left rotation: \n");
        //Display the array again using a for-loop
        for (int i = 0; i < int_arr.length ; i++)
        {
            // Print all the values of the array.
            System.out.println("Value at index " + i + " : " + int_arr[i]);
        }

        //close scanner object
        in.close();

    }
}
// Questions
// 1. Why do we need the variable size and last