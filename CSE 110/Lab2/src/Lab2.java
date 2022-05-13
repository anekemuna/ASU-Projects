//------------------------------------------------------------------------------------------------
// Name: Munachimso Aneke
// Lab:  H
// Title: Lab2.java
// Description: Practicing using primitive data types & expressions and assigning variables
// Date: 09/3/2021
//----------------------------------------------------------------------------------------------

import java.util.Scanner; // import Scanner package

public class Lab2
{
    public static void main(String[] args)
    {
        /* PART 1 */

        int age;
        int n1, n2, n3, n4;
        double avg;

        String firstName;
        String lastName;
        String fullName;

        /* PART 2 */

        age = 20;
        firstName = "Munachimso";
        lastName = "Aneke";
        System.out.println(firstName + " is years old " + age);

        fullName = firstName + " " + lastName;
        System.out.println(fullName);

        /* PART 3 */

        Scanner input = new Scanner(System.in);

        System.out.println("Input integer value for n1, n2, n3, n4: ");
        n1 = input.nextInt();
        n2 = input.nextInt();
        n3 = input.nextInt();
        n4 = input.nextInt();

        System.out.println("The Value of n1 is: " + n1);
        System.out.println("The Value of n2 is: " + n2);
        System.out.println("The Value of n3 is: " + n3);
        System.out.println("The Value of n4 is: " + n4);

        avg = (double) (n1 + n2 + n3 + n4)/4;
        System.out.println("Average of n1, n2, n3, and n4 is: " + avg);
    }
}
