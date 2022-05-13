// Assignment #:  9
//         Name:  Munachimso Aneke
//   Student ID:  1215028815
//      Lecture:  TTh 9:00am (CSE 205)
//  Description:  Collection recursive static methods to perform different tasks

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Assignment9 {

    public static void main(String[] args) {
        char command = ' '; // store users command
        int[] numArray;    // array needed for option 1,2, & 3
        String inputLine;   // line from buffer reader

        try {
            // Create input stream
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);


            do {
                // print menu options
                printMenu();

                // read user command
                inputLine = br.readLine().trim();

                if (inputLine.isEmpty()) {
                    continue;
                }
                command = inputLine.charAt(0);

                switch (command) {
                    case '1': // find the largest number in array
                        // read integers
                        numArray = parseInts(br);
                        // find max number
                        int max = largestNumber(numArray, numArray.length - 1);
                        // print result
                        System.out.printf("The largest number in the array is: %d\n", max);
                        break;

                    case '2': // product of all prime
                        // read integers
                        numArray = parseInts(br);
                        // find sum of prime numbers
                        int product = productPrimeNumber(numArray, numArray.length - 1, 1);
                        // print result
                        System.out.printf("The product of all prime numbers in the array is: %d", product);
                        break;

                    case '3': // find element with the largest sum of digits
                        // read integers
                        numArray = parseInts(br);
                        // find the largest sum of digits
                        int sum = largestSumOfDigits(numArray, numArray.length - 1, 0);
                        // print result
                        System.out.printf("The largest sum of digits in the array is: %d\n", sum);
                        break;

                    case '4':
                        // read user input
                        System.out.println("Please enter String:");
                        inputLine = br.readLine().trim();
                        // clean string
                        String str = cleanString(inputLine, inputLine.charAt(0));
                        // print result
                        System.out.printf("String after adjacent duplicate characters were removed: %s\n", str);
                        break;

                    case '5': // quit
                        break;

                    default:  // wrong inputs
                        System.out.println("Please choose a number between 1 and 5.");
                        break;

                }


            } while (command != '5' || inputLine.length() != 1);
        } catch (IOException exception) {
            System.out.print("IO Exception\n");
        }

    }


    // Method to clean adjacent duplicate characters in a string
    public static String cleanString(String str, char prevChar)
    {
        if(str.isEmpty()) // base case 1: if empty string (might not be needed)
        {
            return "";
        }
        else if(str.length() == 1) // base case 2, if only one character
        {

            return ""+prevChar;
        }
        else if(str.length() == 2) // base case 3: if only 2 characters
        {
            if(prevChar != str.charAt(1))
            {
                return str;
            }
            return ""+prevChar;
        }
        else
        {
            if(prevChar != str.charAt(1)) // str = one less character string
            {
                str = str.substring(1);
            }
            else
            {
                str = str.substring(2);  // str 2 less character (remove duplicate)
            }

        }
        if(prevChar == str.charAt(0)) // recursive case: if the current prevChar == nextPrevChar
        {
            return cleanString(str,str.charAt(0));
        }
        return prevChar + cleanString(str,str.charAt(0)); // recursive case: if current prevChar != nextPrevChar
    }

    // Method to find the largest sum of digits in an array
    public static int largestSumOfDigits(int [] arr, int index, int max)
    {
        if(index == 0) // base case
        {
           return Math.max(max, sumOfDigits(arr[index]));
        }
        else // recursive case
        {
            return Math.max(sumOfDigits(arr[index]), largestSumOfDigits(arr, index-1, max));
        }
    }

    // Method to sum up the digits of a number
    public static int sumOfDigits(int num)
    {
        if(num < 10) // base case: if number is less than 10
        {
            return num;
        }
        else // recursive case: add to one less digit to result;
        {
            return (num % 10) + sumOfDigits(num/10);
        }
    }

    // Method to find the product of prime numbers in an array
    public static int productPrimeNumber(int [] arr, int index, int product)
    {
        //int product = 1;

        if(index == 0) // base case
        {
            if(isPrimeNumber(arr[index], (arr[index]/2)))
            {
                product *= arr[index];
            }
            return product;
        }
        else
        {
            if(isPrimeNumber(arr[index], arr[index]/2))
            {
                product *= arr[index];
            }

        }

        // recursive case
        // apply to one less the original array
        return productPrimeNumber(arr, index -1, product);

    }

    // Method to check if a number is a prime number
    public static boolean isPrimeNumber(int num, int divisor)
    {
        // base cases
        if(num < 2) // base case 1: deals with 0, 1
        {
            return false;
        }
        else if (num <= 3) // base case 2: deals 2, 3
        {
            return true;
        }
        else if (divisor <= 1) // base case 3: deals with when it's not divisible by another number
        {
            return true;
        }
        else if(num % divisor == 0) // base case 4: deals when it's divisible by another number
        {
            return false;
        }

        // recursive case
        return isPrimeNumber(num, divisor-1);
    }

    // Method to find the largest number in an array
    public static int largestNumber(int [] arr, int index)
    {
        //int max = 0;

        // base case
        if (index == 0)
        {
            return arr[index];
        }
        else // recursive case
        {
            return Math.max(arr[index], largestNumber(arr, index - 1));
        }
    }

    // Utility method for printing the menu 
    public static void printMenu()
    {
        System.out.print("\nWhat would you like to do?\n\n");
        System.out.print("1: Find the largest number in an array of integers\n");
        System.out.print("2: Calculate the product of all prime numbers in an array of integers\n");
        System.out.print("3: Find the element with the largest sum of digits in an array of integers\n");
        System.out.print("4: Remove adjacent duplicate characters in a String\n");
        System.out.print("5: Quit\n\n");
    }

    // utility method for parsing integers from standard input
    public static int[] parseInts(BufferedReader reader)
    {
        String line = "";
        ArrayList<Integer> container = new ArrayList<>();
        try {
            System.out.print("Please enter integers:\n");
            line = reader.readLine();
            int num = Integer.parseInt(line);

            while (num > 0) {
                container.add(num);
                line = reader.readLine();
                num = Integer.parseInt(line);
            }

        } catch (IOException ex) {
            System.out.println("IO Exception");
        }

        int[] result = new int[container.size()];
         for(int i = 0; i < container.size(); i++){
             result[i] = container.get(i);
         }
        return result;
    }

}
