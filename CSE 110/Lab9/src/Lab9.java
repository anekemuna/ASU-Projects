//
// AUTHOR: Munachimso Aneke
// FILENAME: Lab9.java
// SPECIFICATION: This program is for practicing the use of arrays.
//                 It also reviews some previous topics.
// LAB LETTER: H
// START TIME: 12:20pm
// END TIME: 1:10pm

import java.util.Scanner;

public class Lab9
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Create an Array of 10 Integers.");

        int[] ints = new int[10];

        System.out.println("Insert 8 integers into the Array.");
        int size = 8;

        for(int i = 0; i < size; i++)
        {
            ints[i] = in.nextInt();
        }

        // Display the array values
        System.out.println("Values in array are: ");
        for(int i = 0; i < size; i++)
        {
            System.out.print(ints[i] + ", ");
        }

        // Insert another integer at a new location
        System.out.println("\nEnter which location you want to insert: ");
        int loc = in.nextInt();

        System.out.println("Enter which value you want to insert: ");
        int value = in.nextInt();

        // Change the values in the array such that it
        // Moves the values to a new location creating space for the new element
        for(int i = size; i > loc-1; i--)
        {
            ints[i] = ints[i-1];

        }
        ints[loc -1] = value;
        size++;

        // Display the Array values
        System.out.println("Values in array are: ");
        for(int i = 0; i < size; i++)
        {
            System.out.print(ints[i] + ", ");
        }

        // Delete an integer at a given location
        System.out.println("\nEnter which location you want to delete: ");
        loc = in.nextInt();

        // Change the values in the array such that it
        // Moves the values to a new location deleting the value at the given location
        for(int i = loc -1; i < size; i++)
        {
            ints[i] = ints[i+1];
        }
        size--;

        // Display the Array values
        System.out.println("Values in array are: ");
        for(int i = 0; i < size; i++)
        {
            System.out.print(ints[i] + ", ");
        }

        // Swap values from 2 locations
        System.out.println("\nEnter the first swap location: ");
        int first = in.nextInt();

        System.out.println("Enter the second swap location: ");
        int second = in.nextInt();

        // Swap values at location first and second
        // Do note actual array location are 1 less
        // Swap can be done in 3 steps
        // Step 1- create temporary copy of the data in the first location
        int temp = ints[first - 1];
        // Step 2- store 2nd value in 1st value
        ints[first -1] = ints[second -1];
        // Step 3- store temp value in 2nd value
        ints[second -1] = temp;

        // Display the Array values
        System.out.println("Values in array are: ");
        for(int i = 0; i < size; i++)
        {
            System.out.print(ints[i] + ", ");
        }

    }
}
