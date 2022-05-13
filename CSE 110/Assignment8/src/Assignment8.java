//***********************************************************
// Name: Yoshi Kobayashi
// Title: CSE110 Instructor
// Author Info: Faculty ASU
// Description: Assignment8 Template
// Date: Fall 2021
//**********************************************************
import java.util.*;
import java.io.*;
public class Assignment8 {
   public static void main (String[] args) throws FileNotFoundException{

       Scanner console = new Scanner (System.in); // Read the user input
       String choice;
	   char command;

	   // numbers used for input in the various cases
	   int num1, num2;

	   // print the menu
	   System.out.println("*** Start of Program ***");
	   printMenu();
       Dungeon myDungeon=null;

	   do
	   {
		   // ask a user to choose a command
		   System.out.print("\nPlease enter a command or type ?");
		   choice = console.next().toLowerCase();
		   command = choice.charAt(0);

		   switch (command)
			{
				case 'a': // Generate a Dungeon object by reading two integers for the dimension
					System.out.print("\n\ta [Create a new dungeon]");
					System.out.print("\n\t[Input the width of dungeon]:");
					num1 = console.nextInt();
					System.out.print("\n\t[Input the heigh of dungeon]:");
					num2 = console.nextInt();
					myDungeon = new Dungeon(num1, num2);
					break;
				case 'b': // Read a text file including a list of monsters.
					System.out.print("\n\tb [set the monsters]");
					System.out.print("\n\t[Type the file name]:");
					String str1 = console.next();
					File file = new File(str1);        // file object for the monsters
					Scanner inFile= new Scanner(file); // scanner to read the contents of text file
					while (inFile.hasNextLine()){
						String tempLine = inFile.nextLine();
						String[] items = tempLine.split("[^a-zA-Z0-9]");  //split each line to 4 elements array
						int tempX = Integer.parseInt(items[0]);           // first element is for X position
						int tempY = Integer.parseInt(items[1]);			  // second element is for X position
						String tempName = items[2];						  // third element is for Monster's name
						int tempL = Integer.parseInt(items[3]);           // forth element is for Monster's level
						Monster tempMonster = new Monster(tempName, tempL);   // temporal Monster
						myDungeon.updateMonster(tempX, tempY, tempMonster);   // replace it with the one in the Dungeon
					}
					inFile.close(); // close the scanner's buffer.
					System.out.println(myDungeon.printInfo());
					break;
				case 'c': // shift all monsters to one next cell
					System.out.print("\n\tc [shift the monsters]");
					System.out.print("\n\t[Input the shift command ('w', 'a', 's', or 'd')]:");
					// w:move-up, a:move-left, s: move-down, d:move-right
					char cmd = console.next().charAt(0);
					myDungeon.shift(cmd);
					System.out.print(myDungeon.printInfo());
					break;
				case 'd': // shuffle all monsters.
					System.out.print("\n\td [shuffle the monsters]");
					myDungeon.shuffle();
					System.out.print(myDungeon.printInfo());
					break;
				case 'e':  // print the dungeon with Monster's initial and level
					System.out.print("\n\te [display the dungeon]");
					System.out.print(myDungeon.printInfo());
		            break;
				 case '?':
					  printMenu();
					  break;
				 case 'q':
					  break;
				 default:
					   System.out.println("Invalid input");
					   break;
			}
		} while (command != 'q');

		 System.out.println("\n*** End of Program ***");
	}  //end of the main method

   public static void printMenu()
   {
	System.out.print("\nCommand Options\n"
				   + "-----------------------------------\n"
				   + "a: create a new dungeon\n"
				   + "b: set the monsters\n"
				   + "c: shift the monsters\n"
				   + "d: shuffle the monsters\n"
				   + "e: display the dungeon\n"
				   + "?: display the menu again\n"
				   + "q: quit this program\n\n");
	} // end of the printMenu method
}


