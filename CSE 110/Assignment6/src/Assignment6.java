//***********************************************************
// Name: Munachimso Aneke
// Title: Assignment6.java
// Author Info: Computer Science, 12115028815
// Lab Section: H
// Description: Application of the Fraction Class
// Date: 10/26/2021
//**********************************************************
import java.util.*;
public class Assignment6 {
   public static void main (String[] args) {

       Scanner console = new Scanner (System.in);
       String choice;
	   char command;

	   // numbers used for input in the various cases
	   int num1, num2;

	   // print the menu
	   System.out.println("*** Start of Program ***");
	   printMenu();


	   // **********************************//
	   // *** Construct a Fraction instance here
	   Fraction fraction = new Fraction(0,1);
	   System.out.println("Value:" + fraction.toString());

	   do
	   {
		   // ask a user to choose a command
		   System.out.println("\n[Please enter a command or type ?] ");
		   choice = console.next().toLowerCase();
		   command = choice.charAt(0);

		   switch (command)
			{
				case 'c':
					// *****************************//
					// *** Reset Fractions here
					fraction = new Fraction(0,1);
					System.out.println("Value:" + fraction.toString());
		            break;
				case '*':
					System.out.println("[Enter two numbers for a fraction to MULTIPLY] ");
					// **************************************//
					// *** Call Fraction Multiply Method
					num1 = console.nextInt();
					num2 = console.nextInt();
					Fraction fraction1 = new Fraction(num1,num2);
					System.out.print(fraction.toString() + " * " + fraction1.toString());
					fraction = Fraction.multiply(fraction,fraction1);
					System.out.println(" = " + fraction.toString());
					System.out.println("Value:" + fraction.toString());
					break;
				case '/':
					System.out.println("[Enter two numbers for a fraction to DIVIDE] ");
					// ************************************//
					// *** Call Fraction Divide Method
					num1 = console.nextInt();
					num2 = console.nextInt();
					Fraction fraction2 = new Fraction(num1,num2);
					System.out.print(fraction.toString() + " / " + fraction2.toString());
					fraction = Fraction.divide(fraction,fraction2);
					System.out.println(" = " + fraction.toString());
					System.out.println("Value:" + fraction.toString());

					break;
				case '+':
					System.out.println("[Enter two numbers for a fraction to ADD] ");
					// *********************************//
					// *** Call Fraction Add Method
					num1 = console.nextInt();
					num2 = console.nextInt();
					Fraction fraction3 = new Fraction(num1,num2);
					System.out.print(fraction.toString() + " + " + fraction3.toString());
					fraction = Fraction.add(fraction,fraction3);
					System.out.println(" = " + fraction.toString());
					System.out.println("Value:" + fraction.toString());
					break;
				case '-':
					System.out.println("[Enter two numbers for a fraction to SUBTRACT] ");
					// **************************************//
					// *** Call Fraction Subtract Method
					num1 = console.nextInt();
					num2 = console.nextInt();
					Fraction fraction4 = new Fraction(num1,num2);
					System.out.print(fraction.toString() + " - " + fraction4.toString());
					fraction = Fraction.subtract(fraction,fraction4);
					System.out.println(" = " + fraction.toString());
					System.out.println("Value:" + fraction.toString());
					break;
				case '?':
					 printMenu();
					 System.out.println("Value:" + fraction.toString());
					 break;
				case 'q':
					 break;
				default:
					 System.out.println("[Invalid input] " + command);
					 break;
			}
		} while (command != 'q');
		 System.out.println("*** End of Program ***");
	}  //end of the main method


   public static void printMenu()
   {
	System.out.print(
				   "\nCommand Options\n"
				   +"-----------------------------------\n"
				   +"c: reset the value\n"
				   +"+: add a fraction to the current value\n"
				   +"-: subtract a fraction from the current value\n"
				   +"*: multiply a fraction to the current value\n"
				   +"/: divide the current value by a fraction\n"
				   +"?: display the menu again\n"
				   +"q: quit this program\n\n");
	} // end of the printMenu method
}


