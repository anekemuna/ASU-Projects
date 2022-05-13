//**************************************************************************
// Name: Munachimso Aneke
// Title: Assignment3.java
// Description: Practicing the use of Loops
// Date: 9/30/2021
//***************************************************************************

/*
    PART 1

    a.) i: input 'a'  : output: A
                                Input 0s and 1s in one line
       ii: input 'b'  : output: B
                                Invalid command. Try Again
      iii: input 'r'  : output: R
                                The data is refreshed
       iv: input 'q'  : output: A
                                *** End of Program ***

    b.) else if (command == 'D') {
                System.out.println("Display the result");
            }
    c.) num0 will be equal to 3, and num1 will be equal to 4;
    d.) System.out.printf("\n%4s|", "Num 0");
        for(int i = 0; i < num0; i++) System.out.print("*");
        System.out.println();
        System.out.printf("\n%4s|", "Num 1");
        for(int i = 0; i < num1; i++) System.out.print("*");
        System.out.println();
    e.) num0 = 0;
        num1 = 0;
*/

/* PART 2 */
import java.util.Scanner;

public class Assignment3
{
    public static void main(String[] args)
    {
        char command;
        Scanner in = new Scanner(System.in);
        double a = 0, b = 0, c = 0;

        do{
            System.out.println("Choose (A: add grades), (N: new grades), or (Q: quit)");
            String temp = in.nextLine();
            command = temp.toUpperCase().charAt(0);

            if( command == 'A')
            {
                System.out.println("Type the additional input in single line");
                temp = in.nextLine();
                Scanner s = new Scanner(temp);
                while(s.hasNext()){
                    String sGrade = s.next();
                    char cGrade = sGrade.charAt(0);

                    if(cGrade == 'A')
                    {
                        a++;
                    }
                    else if(cGrade == 'B')
                    {
                        b++;
                    }
                    else if(cGrade == 'C')
                    {
                        c++;
                    }
                }
                double gpa = ((a * 4) +(b * 3) + (c * 2))/ (a + b + c);

                System.out.println("\n--------------------------------");
                System.out.print("\t A|");
                for(int i = 0; i < a; i++) System.out.print("*");
                System.out.println();

                System.out.print("\t B|");
                for(int i = 0; i < b; i++) System.out.print("*");
                System.out.println();

                System.out.print("\t C|");
                for(int i = 0; i < c; i++) System.out.print("*");
                System.out.println();

                System.out.println("--------------------------------");

                System.out.printf("GPA = %.2f\n\n", gpa);

            }
            else if( command == 'N')
            {
                System.out.println("Type a new list of input in single line");
                temp = in.nextLine();
                Scanner s = new Scanner(temp);
                a = 0;
                b = 0;
                c = 0;

                while(s.hasNext()){
                    String sGrade = s.next();
                    char cGrade = sGrade.charAt(0);

                    if(cGrade == 'A')
                    {
                        a++;
                    }
                    else if(cGrade == 'B')
                    {
                        b++;
                    }
                    else if(cGrade == 'C')
                    {
                        c++;
                    }
                }
                double gpa = ((a * 4) +(b * 3) + (c * 2))/ (a + b + c);

                System.out.println("\n--------------------------------");
                System.out.print("\t A|");
                for(int i = 0; i < a; i++) System.out.print("*");
                System.out.println();

                System.out.print("\t B|");
                for(int i = 0; i < b; i++) System.out.print("*");
                System.out.println();

                System.out.print("\t C|");
                for(int i = 0; i < c; i++) System.out.print("*");
                System.out.println();

                System.out.println("--------------------------------");

                System.out.printf("GPA = %.2f\n\n", gpa);

            }
            else if( command == 'Q')
            {
                System.out.println("*** End of program ***");
            }
            else
            {
                System.out.println("Invalid command was input!\n");
            }
        } while(command != 'Q');
    }
}
