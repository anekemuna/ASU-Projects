//**********************************************************************************************************************
// Name: Munachimso Aneke
// Title: Assignment2.java
// Description: Incorporating if statements, relational operators, string methods(e.g indexOf, substring, compareTo...)
// Date: 09/21/2021
//**********************************************************************************************************************

/*

Part 1

a.) For input (1, 6, 4) returned the wrong output as (1, 0, 6), because the if statements comparing the value of c (in
    this case 4), does not account for when the 4 is the middle value. Similar to (1, 6, 4), for input (6, 1, 4)
    returned the wrong output (1, 0, 6) because the middle value is 4, and if else statements does not account for when
    c is the middle value. It only accounts for when a/b is the middle value.
b.) middle = c;
c.) The "str1.compareTo(str2) > 0" will be true if str1 = "Yoshi" and str2 = "Mario". According to the lexicographic
    order of strings in java, "Yoshi", will come after "Mario". therefore the result of str1.compareTo(str2) is a
    positive number.
d.) The result will be -32. The implementation  of compareTo() uses the ascii code of to compare the characters of two
    strings. In the case "Yoshi" and "yoshi". The ascii code os 'Y' and 'y' is 89 and 121 respectively. The calculation
    will be 89 - 121, which is equal to -32.
e.) if( (str.toUpperCase().compareTo("A") >= 0) && (str.toUpperCase().compareTo("Z") <= 0))

*/

import java.util.Scanner;

public class Assignment2
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        String s1, s2, s3;
        String firstName, secondName, thirdName;

        System.out.println("*** TASK: Read name and display them in alphabetic order ***");

        System.out.println("Please input the first name: ");
        s1 = in.next();
        s1 = s1.toUpperCase();

        if(!(s1.substring(0,1).compareTo("A") >= 0 && s1.substring(0,1).compareTo("Z") <= 0)) //makes first char is a letter
        {
            System.out.println("\tError: The first letter should be an alphabet");
            s1 = " ";
        }
        else  // print name
        {
            System.out.println("\t" + s1);
        }

        System.out.println("Please input the second name: ");
        s2 = in.next();
        s2 = s2.toUpperCase();

        if(!(s2.substring(0,1).compareTo("A") >= 0 && s2.substring(0,1).compareTo("Z") <= 0)) //make sure first letter is a letter
        {
            System.out.println("\tError: The first letter should be an alphabet");
            s2 = " ";

        }
        else if(!s1.equals(" "))  //if s1 was not an error, sort s1 and s2
        {
            if(s1.compareTo(s2) <= 0) //if s1 comes before s2
            {
                firstName = s1;
                secondName = s2;
            }
            else
            {
                firstName = s2;
                secondName = s1;
            }
            System.out.printf("\t%s, %s\n",firstName,secondName); // print names in order
        }
        else //if s1 is an error, print s2 only
        {
            System.out.println("\t" + s2);
        }

        System.out.println("Please input the third name: ");
        s3 = in.next();
        s3 = s3.toUpperCase();

        if(!(s3.substring(0,1).compareTo("A") >= 0 && s3.substring(0,1).compareTo("Z") <= 0)) //makes sure s3 is a name
        {
            System.out.println("\tError: The first letter should be an alphabet");
            s3 = " ";

        }
        else if (!s1.equals(" ") && !s2.equals(" ")) // if s1 and s2 are not errors
        {
            if(s1.compareTo(s2) <= 0) //sort s1 and s2
            {
                firstName = s1;
                thirdName = s2;
            }
            else
            {
                firstName = s2;
                thirdName = s1;
            }

            if(s3.compareTo(firstName) <= 0) // sort s3 if it's smaller that the firstName
            {
                secondName = firstName;
                firstName = s3;
            }
            else if(s3.compareTo(thirdName) >= 0) //sort s3 if it's bigger than thirdName
            {
                secondName = thirdName;
                thirdName = s3;
            }
            else // if s3 is the middleName(failed the last 2 conditions)
            {
                secondName = s3;
            }

            System.out.printf("\t%s, %s, %s\n", firstName, secondName, thirdName); //print names
        }
        else if(s2.equals(" ") && !s1.equals(" ")) //to avoid extra commas in the output, sort the strings that are not errors
        {
            if(s1.compareTo(s3) <= 0)
            {
                firstName = s1;
                thirdName = s3;
            }
            else
            {
                firstName = s3;
                thirdName = s1;
            }
            System.out.printf("\t%s, %s\n",firstName,thirdName);
        }
        else if(s1.equals(" ") && !s2.equals(" "))
        {
            if(s2.compareTo(s3) <= 0)
            {
                firstName = s2;
                thirdName = s3;
            }
            else
            {
                firstName = s3;
                thirdName = s2;
            }
            System.out.printf("\t%s, %s\n",firstName,thirdName);
        }
        else // is s1 and s2 are errors
        {
            System.out.println("\t" + s3);
        }


        System.out.println("\n*** END OF Assignment#2 ***");

    }
}
