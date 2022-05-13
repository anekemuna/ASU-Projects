import java.awt.*;
import java.util.Locale;
import java.util.Scanner;
public class CommandTemplate {
    public static void main(String [] arg)
    {
        char command;
        Scanner in = new Scanner(System.in); // user input scan
        int num0 = 0;
        int num1 = 0;
        do{
            System.out.println("Choose (A: add data), (R: refresh data), (D: display data), or (Q: quit)");
            String temp = in.nextLine();
            command = temp.toUpperCase().charAt(0);

            System.out.println(command);
            if(command == 'A'){
                System.out.println("Input 0s and 1s in one line");
                temp = in.nextLine();
                Scanner s = new Scanner(temp);
                while (s.hasNext()){
                    int input = s.nextInt();
                    if(input == 0) num0++;
                    else if(input == 1) num1++;
                }
            }
            else if (command == 'R') {
                System.out.println("The data is refreshed");
                num0 = 0;
                num1 = 0;
            }
            else if (command == 'D') {
                System.out.println("Display the result");
                System.out.printf("\n%4s|", "Num 0");
                for(int i = 0; i < num0; i++) System.out.print("*");
                System.out.println();
                System.out.printf("\n%4s|", "Num 1");
                for(int i = 0; i < num1; i++) System.out.print("*");
                System.out.println();
            }
            else if (command == 'Q'){
                System.out.println("**** End of Program ***");
            }
            else  {
                System.out.println("Invalid command.Try Again");
            }
            System.out.println();
        } while(command != 'Q');
    } // end of main
} // end of class
