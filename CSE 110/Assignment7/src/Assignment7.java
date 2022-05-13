//***********************************************************
// Name: Munachimso Aneke
// Title: Assignment7.java
// Lab Section: H
// Description: Manipulating arrays
// Time Spent: 30 mins
// Date: 11/9/2021
//**********************************************************

import java.util.Scanner;

public class Assignment7
{
    public static void main(String [] args)
    {
        // Start program and print menu
        System.out.println("*** Start of Program ***\n");
        printMenu();

        // Declare scanner and choice variable
        Scanner in = new Scanner(System.in);
        char choice;

        // Declare and initialize CardList variable
        CardList card = new CardList(0);

        do {

            // ask for user's command
            System.out.println("Please enter a command or type ? ");
            String temp = in.next();
            choice = temp.toLowerCase().charAt(0);

            // actions
            switch (choice)
            {
                case 'a':
                    System.out.println("\ta [Create new cards]");

                    // get size of cards
                    System.out.println("\t[Input the size of cards]: ");
                    int size = in.nextInt();

                    // initialize card
                    card = new CardList(size);

                    // print card history
                    System.out.println(card.getHistory());
                    break;
                case 'b':
                    System.out.println("\tb [flip the cards]");

                    // flip cards and print card history
                    card.flip();
                    System.out.println(card.getHistory());
                    break;
                case 'c':
                    System.out.println("\tc [shift the cards]");

                    // shift cards and print card history
                    card.shift();
                    System.out.println(card.getHistory());
                    break;
                case 'd':
                    System.out.println("\td [shuffle the cards]");

                    // shuffle cards and print card history
                    card.shuffle();
                    System.out.println(card.getHistory());
                    break;
                case 'e':
                    System.out.println("\te [Change the cards]");

                    // Collect number of cards to change
                    System.out.println("\t[Input the number of cards to change]: ");
                    int num = in.nextInt();

                    //change the cards and print the card history
                    card.change(num);
                    System.out.println(card.getHistory());
                    break;
                case '?':
                    // print menu
                    printMenu();
                    break;
                case 'q':
                    // quit program
                    System.out.println("*** End of Program ***");
                    break;
                default:
                    System.out.println("Invalid command. Enter a command or type:");

            }
        } while (choice != 'q');
    }
    public static void printMenu()
    {
        System.out.println("Command Options");
        System.out.println("-----------------------------------");
        System.out.println("a: Create new cards");
        System.out.println("b: flip the cards");
        System.out.println("c: shift the cards");
        System.out.println("d: shuffle the cards");
        System.out.println("e: change the cards");
        System.out.println("?: Display the menu again");
        System.out.println("q: Quit this program\n\n");
    }
}
