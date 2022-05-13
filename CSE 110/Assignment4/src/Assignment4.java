//********************************************************************************************************
// Name: Munachimso Aneke
// Title: Assignment4.java
// Description: Practicing Object Oriented Programming - implementation, constructors, encapsulation...
// Date: 10/4/2021
// ********************************************************************************************************

import java.util.Scanner;

public class Assignment4
{
    public static void main(String [] arg)
    {
        char command;
        Scanner in = new Scanner(System.in); // user input scan

        FiveCards myCards = new FiveCards(); // initializing FiveCards Object

        do{
            System.out.println("Choose (A: make a new five cards), (B: change  one card), (C: display data), or (Q: quit)");
            String temp = in.nextLine();
            command = temp.toUpperCase().charAt(0);

            if(command == 'A'){
                System.out.println(" *** Make A new FiveCards *** ");
                System.out.println("Type five letters without space");
                String str = in.nextLine();
                myCards.setCards(str);
                myCards.calculateScore();
                System.out.println(myCards.displayData());

            }
            else if (command == 'B') {
                System.out.println(" *** Change One Card *** ");
                System.out.println("Type one position to change");
                int pos = in.nextInt();
                String lineBreak = in.nextLine(); //to skip the line break
                myCards.changeOne(pos);
                myCards.calculateScore();
                System.out.println(myCards.displayData());

            }
            else if (command == 'C') {
                System.out.println(" *** Display Data *** ");
                System.out.println(myCards.displayData());
            }
            else if (command == 'Q'){
                System.out.println(" *** End of Program *** ");
            }
            else  {
                System.out.println(" *** Invalid command.Try Again *** ");
            }
        } while(command != 'Q');
    } // end of main
}
