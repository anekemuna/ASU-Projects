/*
  Assignment #: 4
  Name: Munachimso Aneke
  StudentID: 1215028815
  Lecture: CSE 205 (T Th 9am)
  Description: Assignment 4 class displays a menu of choices to a user
               and performs the chosen task. It will keep asking a user to
               enter the next choice until the choice of 'Q' (Quit) is entered.
 */

import java.util.*;

public class Assignment4
 {
  public static void main (String[] args)
   {
       // local variables, can be accessed anywhere from the main method
       char input1 = 'Z';
       //String inputInfo= "";
       String name,  firstName, lastName,  city ;
       int years = 0;
       String line = new String();

       // instantiate a Team object
       Team suns = null;

       printMenu();

       //Create a Scanner object to read user input
       Scanner scan = new Scanner(System.in);

       do  // will ask for user input
        {
            System.out.println("What action would you like to perform?");
            line = scan.nextLine();

            if (line.length() == 1)
            {
                input1 = line.charAt(0);
                input1 = Character.toUpperCase(input1);

                // matches one of the case statement
                switch (input1)
                {
                    case 'A':   //Add a coach


					    System.out.print("Please enter the Coach's information:\n");
					    System.out.print("Enter coach's first name:\t");
					    firstName = scan.nextLine();
					    System.out.print("Enter coach's last name:\t");
					    lastName = scan.nextLine();
					    System.out.print("Enter coach's years of experience:\t");
					    years = scan.nextInt();
					    scan.nextLine();
                        Coach sunsCoach = new Coach(firstName, lastName, years);

                        System.out.print("\nPlease enter the Team's information:");
                        System.out.print("\nEnter teams name:\t");
                        name = scan.nextLine();

                        System.out.print("Enter Team's city:\t");
                        city = scan.nextLine();
                        suns = new Team(name, sunsCoach, city);
                        break;
                    case 'D':   //Display course
                        System.out.print(suns.toString());
                        break;
                    case 'Q':   //Quit
                        break;
                    case '?':   //Display Menu
                        printMenu();
                        break;
                    default:
                        System.out.print("Unknown action\n");
                        break;
                }
          }
         else
          {
              System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q' || line.length() != 1);
       scan.close();
   }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "A\t\tAdd Team\n" +
                        "D\t\tDisplay Team\n" +
                        "Q\t\tQuit\n" +
                        "?\t\tDisplay Help\n\n");
  }

}
