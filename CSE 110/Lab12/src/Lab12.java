//---------------------------------------------------------------------------
// AUTHOR:      Munachimso Aneke
// FILENAME:    Lab12.java
// SPECIFICATION:  This program is for practicing File I/O.
// LAB LETTER:     H
//-------------------------------------------------------------------------

import java.util.Scanner;

public class Lab12
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int choice;
        String name, number;
        boolean EXIT = false;
        String path = "test.txt";
        PhoneBook pb = new PhoneBook(path);

        while(!EXIT)
        {
            System.out.println("Select the action that you want to perform:");
            System.out.println("\t1. Add a record");
            System.out.println("\t2. Delete a record.");
            System.out.println("\t3. Read records from file");
            System.out.println("\t4. Save your records.");
            System.out.println("\t5. Exit");
            System.out.println("Enter action number (1-5):");

            choice = in.nextInt();

            switch (choice)
            {
                case 3:
                    pb.read();
                    pb.show();
                    break;
                case 1:
                    System.out.println("Input the name of the records:");
                    name = in.next();
                    System.out.println("Input the phone number of the record:");
                    number = in.next();
                    pb.add(name,number);
                    pb.show();
                    break;
                case 2:
                    System.out.println("Input the name of the record you want to delete:");
                    name = in.next();
                    pb.delete(name);
                    pb.show();
                    break;
                case 4:
                    pb.save();
                    break;
                case 5:
                    EXIT = true;
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid input!");
            }
        }
    }
}
