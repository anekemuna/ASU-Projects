// Assignment #: 5
//         Name: Munachimso Aneke
//    StudentID: 1215028815
//      Lecture: TTh 9:00am (CSE 205)
//  Description: Driver program for Battle game

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList

public class Assignment5 {
    public static void main(String[] args){
        char input;
        String line;
        String inputInfo;

        // ArrayList used to store the hero objects
        ArrayList<PlayerEntity> playerList = new ArrayList<>();

        try{
            System.out.println("Welcome to the battle stats simulator!");
            printMenu();

            // create a BufferedREader object to read input from a keyboard
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do{
                System.out.println("\nWhat action would you like to perform?");
                line = stdin.readLine().trim();
                input = line.charAt(0);
                input = Character.toUpperCase(input);
                if(line.length() == 1){
                    switch (input){
                        case 'A': // add hero to the guild
                            System.out.println("Please enter your hero stats:");
                            inputInfo = stdin.readLine().trim();
                            /*************************************************************************************************
                            **  ADD code here to create a hero object (child of PlayerEntity) and add it to the player list **
                            **************************************************************************************************/
                            PlayerEntity obj = PlayerParser.parseNewPlayer(inputInfo);
                            playerList.add(obj);
                            break;

                        case 'C': // calculate combat points
                            /**************************************************************************
                            **  ADD code here to compute the combat power for all heroes in the list **
                            ***************************************************************************/
                            for (int i = 0; i < playerList.size(); i++)
                            {
                                PlayerEntity obj2 = playerList.get(i);
                                obj2.computeCombatPower();
                                playerList.set(i, obj2);

                            }
                            System.out.println("Combat points computed");
                            break;

                        case 'D': // how many heroes have combat points equal to or larger than a user-defined value
                            System.out.print("Please enter a minimum combat points you want to calculate:\n");
                            inputInfo = stdin.readLine().trim();
                            int min = Integer.parseInt(inputInfo);
                            int count = 0;
                            /********************************************************************************************************
                            **  ADD code here to count how many heroes in the list have combat points equal to or larger than input**
                            *********************************************************************************************************/
                            for (int i = 0; i < playerList.size(); i++)
                            {
                                if(playerList.get(i).getCombatPoints() >= min)
                                {
                                    count++;
                                }
                            }
                            System.out.println("The number of heroes with " + min
                                    + " combat points or more is: " + count);
                            break;

                        case 'L': // list heroes
                            /***********************************************************
                            **  ADD code here to print all heroes in the list 
                            **  If the list is empty print "No heroes in guild yet.\n"
                            ************************************************************/
                            for (int i = 0; i < playerList.size(); i++)
                            {
                                System.out.print(playerList.get(i).toString());
                            }

                            break;

                        case 'Q':
                            break;

                        case '?':
                            printMenu();
                            break;

                        default:
                            System.out.print("Unknown action\n");
                            break;
                    }
                }
                else
                    System.out.println("Unknown action");

            }while (input != 'Q');
            System.out.println("Thanks for playing!");
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
    }


    public static void printMenu(){
        System.out.print("Choice\t\tAction\n" +
                "------\t\t------\n" +
                "A\t\tAdd Hero\n" +
                "C\t\tCompute Combat Points\n" +
                "D\t\tCount Heroes with Minimum Combat Points\n" +
                "L\t\tList Heroes\n" +
                "Q\t\tQuit\n" +
                "?\t\tDisplay Help\n\n");
    }
}
