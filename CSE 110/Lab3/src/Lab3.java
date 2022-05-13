//-----------------------------------------------------------------------------------------------------------
// AUTHOR : Munachimso Aneke
// FILENAME : Lab3.java
// SPECIFICATION: This program is for practicing the use of if-else conditional expressions
//               It also reviews some previous topics. It also finds the dictionary order of two strings.
// LAB LETTER: H
// START TIME: 12:20pm
// END TIME: 1:10pm
//------------------------------------------------------------------------------------------------------------

import java.util.Scanner;     // importing Scanner class from java.util package


public class Lab3
{
    public static void main(String[] args)
    {
        double n1, n2, n3, n4, ans = 0, max, min;
        String s1;

        Scanner in = new Scanner(System.in);

        System.out.println("Input four integers on which we want to perform Mathematical Operations!");

        n1 = in.nextDouble();
        n2 = in.nextDouble();
        n3 = in.nextDouble();
        n4 = in.nextDouble();

        /* if else statement to find the maximum and minimum */
        // finding the maximum

        max = n1;       // let the max value be n1
        if(max < n2)    // compare the value of n2 with the current max and swap if n2 is larger
            max = n2;
        if(max < n3)    // swap max if n3 is larger
            max = n3;
        if( max < n4)   // swap max if n4 is larger
            max = n4;

        // testing: System.out.println("max: " + max);
        // finding the minimum

        min = n1;       // let the min value be n1
        if(min > n2)    // compare the value of n2 with the current min and swap if n2 is smaller
            min = n2;
        if(min > n3)    // swap min if n3 is smaller
            min = n3;
        if( min > n4)   // swap min if n4 is smaller
            min = n4;

        // testing: System.out.println("min: " + min);

        System.out.println("Please input pne of the following operations:");
        System.out.println("Type a to Add the numbers.");
        System.out.println("Type b to Multiply the numbers.");
        System.out.println("Type c to find Avg.");
        System.out.println("Type d to find Max.");
        System.out.println("Type e to find Min.");

        s1 = in.next();

        /* if else statement to find which operation to perform */
        // compare the string and run the respective operation is s1 is equal to either a, b, c, d, or e

        if(s1.equals("a"))
        {
            ans = n1 + n2 + n3 + n4;
            System.out.println("Answer is: " + ans);
        }
        else if (s1.equals("b"))
        {
            ans = n1 * n2 * n3 * n4;
            System.out.println("Answer is: " + ans);
        }
        else if (s1.equals("c"))
        {
            ans = (n1 + n2 + n3 + n4) / 4;
            System.out.println("Answer is: " + ans);
        }
        else if (s1.equals("d"))
        {
            ans = max;
            System.out.println("Answer is: " + ans);
        }
        else if(s1.equals("e"))
        {
            ans = min;
            System.out.println("Answer is: " + ans);
        }
        else
        {
            System.out.println("Please input the correct option.");
        }

        String str1, str2;

        System.out.println("We are now comparing 2 strings and finding which one will come first in a dictionary!!");

        System.out.println("Please enter 2 strings of length 4.");
        System.out.println("Enter string 1:");
        str1 = in.next();
        System.out.println("Enter string 2:");
        str2 = in.next();

        String firstString = "", secondString = "";

        /* if else statement determining which string comes first */
        // Use str.compareTo() to determine which string is first. Determine based on the return value of the
        //      method(0 if equal, 1 if greater and -1 less)

        if(str1.compareTo(str2) > 0)
        {
            firstString = str2;
            secondString = str1;
        }
        else if(str1.compareTo(str2) < 0)
        {
            firstString = str1;
            secondString = str2;
        }
        else
        {
            firstString = str1;
            secondString = str2;
        }

        System.out.println("First String is: " + firstString);
        System.out.println("Second String is: " + secondString);

        in.close();
    }
}
