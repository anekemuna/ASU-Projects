// Assignment #: 2
//         Name: Munachimso Aneke
//    StudentID: 1215028815
//      Lecture: CSE 205 (9am)
//  Description: This class reads an unspecified number of integers and performs calculations on the inputs.


import java.util.Scanner;

public class Assignment2
{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in); // create scanner object

        int maxNo = 0,  // largest integer
                maxEven = 0,  // largest even integer
                count = 0, // no of positive integer
                sum = 0; // sum of integers

        int input = scan.nextInt(); // read first value

        while (input != 0) // if input != 0
        {
            if(input > maxNo)  // store the largest integer
            {
                maxNo = input;
            }

            if(input % 2 == 0 && input > maxEven) // store the largest even integer
            {
                maxEven = input;
            }

            if(input > 0) // count positive integers
            {
                count++;
            }

            sum += input; // sum all integers

            input = scan.nextInt(); // read next input
        }

        // Print result
        System.out.println("The largest integer in the sequence is " + maxNo
                + "\nThe largest even integer in the sequence is " + maxEven
                + "\nThe count of positive integers in the sequence is " + count
                + "\nThe sum of all integers is " + sum + "\n");
    }
}
