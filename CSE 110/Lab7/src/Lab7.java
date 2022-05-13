//---------------------------------------------------------------------------
// AUTHOR:          Munachimso Aneke
// FILENAME:        Lab7.java
// SPECIFICATION:   This program is for practicing the object oriented programming.
//                  You need to develop the setName() method of Student Class and construct a simple system
//                  that can manage a student's name and age
// LAB LETTER:    H
//-------------------------------------------------------------------------

import java.util.Scanner;

public class Lab7
{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);

        // Declare variables
        String username1, username2;
        int age1, age2;

        // Collecting Data
        System.out.println("Please input a username for student 1"); // student 1
        username1 = scan.nextLine();

        System.out.println("Please input an age for student 1");
        String temp = scan.nextLine();
        age1 = Integer.parseInt(temp);

        System.out.println("Please input a username for student 2"); // student 2
        username2 = scan.nextLine();

        System.out.println("Please input an age for student 2");
        temp = scan.nextLine();
        age2 = Integer.parseInt(temp);

        //Instantiate 2 Student objects
        Student student1 = new Student(username1, age1);
        Student student2 = new Student(username2, age2);

        // Constants
        final int PRINT = 0;
        final int MODIFY_USERNAME = 1;
        final int MODIFY_AGE = 2;
        final int QUIT = 3;

        int choice;

        do {
            System.out.println("\nThis program does the following:");
            System.out.println("0. Print information");
            System.out.println("1. Modify username");
            System.out.println("2. Modify age");
            System.out.println("3. Quit");

            // Store users choice
            temp = scan.nextLine();
            choice = Integer.parseInt(temp);

            switch (choice)
            {
                case PRINT:
                    // print objects data
                    System.out.println(student1.toString());
                    System.out.println(student2.toString());
                    break;
                case MODIFY_USERNAME:

                    System.out.println("Enter the student number that you wish to modify: (1/2)?");
                    temp = scan.nextLine();
                    int stu_num = Integer.parseInt(temp);

                    System.out.println("Please input the new name:");
                    String newName = scan.nextLine();   // store new name
                    if(stu_num == 1) // change name for student1 if stu_num is 1
                    {
                        student1.setName(newName);
                    }
                    else            // change name for student2 if stu_num is 2
                    {
                        student2.setName(newName);
                    }
                    break;
                case MODIFY_AGE:
                    System.out.println("Enter the student number that you wish to modify: (1/2)?");
                    temp = scan.nextLine();
                    int stu_num1 = Integer.parseInt(temp);

                    System.out.println("Please input the new age.");
                    temp = scan.nextLine();
                    int newAge = Integer.parseInt(temp); // store new age

                    if(stu_num1 == 1) // change name for student1 if stu_num is 1
                    {
                        student1.setAge(newAge);
                    }
                    else            // change name for student2 if stu_num is 2
                    {
                        student2.setAge(newAge);
                    }
                    break;
                case QUIT:
                    System.out.println("You choose to quit.");
                    break;
                default:
                    System.out.println("Please choose again.");

            }

        }while(choice != QUIT);
    }

}
