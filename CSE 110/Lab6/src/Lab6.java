//---------------------------------------------------------------------------------------
// AUTHOR: Munachimso Aneke
// FILENAME: Lab5.java
// SPECIFICATION: This program is for practicing the use of Object Oriented Programming.
//                It also reviews some previous topics.
// LAB LETTER: H
// DATE: 10/1/2021
// START TIME: 12:20pm
// END TIME:   1:10pm
//-----------------------------------------------------------------------------------------

import java.util.Scanner;

public class Lab6
{
    public static void main(String [] args)
    {
        //Declare a scanner
        Scanner scan = new Scanner(System.in);

        String username, accountNumber;
        double balance;

        System.out.println("Please Enter Username:");
        username = scan.nextLine();
        System.out.println("Please Enter Account Number:");
        accountNumber = scan.nextLine();
        System.out.println("Please Enter Initial Account Balance:");
        balance = scan.nextDouble();

        //Instantiate an Account using its constructor method
        Account account = new Account(username, accountNumber, balance);

        final int DISPLAY_BALANCE = 0;
        final int MODIFY_NAME = 1;
        final int DEPOSIT = 2;
        final int WITHDRAW = 3;
        final int QUIT = 4;

        //Create a choice variable
        int choice;
        do{
            // program options
            System.out.println("This program Does The Following:-");
            System.out.println("Press 0 to Display User Account Information.");
            System.out.println("Press 1 to modify User Name.");
            System.out.println("Press 2 to Make a Deposit.");
            System.out.println("Press 3 to Make a Withdrawal");
            System.out.println("Press 4 to Quit.");

            choice = scan.nextInt();

            switch (choice)
            {
                case DISPLAY_BALANCE:
                    System.out.println("User Account Information is: ");
                    System.out.println(account.toString());
                    break;
                case MODIFY_NAME:
                    System.out.println("Please enter new Name:");
                    String temp = scan.next();
                    account.setName(temp);
                    break;
                case DEPOSIT:
                    System.out.println("Please enter Deposit Amount");
                    double temp1 = scan.nextDouble();
                    account.toCredit(temp1);
                    break;
                case WITHDRAW:
                    System.out.println("Please enter Withdrawal Amount");
                    double temp2 = scan.nextDouble();
                    account.toDebit(temp2);
                    break;
                case QUIT:
                    System.out.println("Thank You. Have a nice day!");
                    break;
                default:
                    System.out.println("Please enter a valid Option");
            }

        }while (choice != QUIT);

        scan.close();
    }
}
