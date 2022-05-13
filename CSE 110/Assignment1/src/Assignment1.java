//--------------------------------------------------------------------------------------------------
// Name: Munachimso Aneke
// Title: Assignment1.java
// Description: Practice variable declaration, arithmetic operations and using scanner class
// Date: 09/10/2021
//--------------------------------------------------------------------------------------------------

import java.util.Scanner;

public class Assignment1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        /*
            Question 1) First the input is read in with the scanner. The total number of hundred bills is calculated
            using integer division (/), the remainder value is calculated using modulus (%). The steps are repeated using
            the same technique for the other bill values in descending order (20, 10, 5, 1)- calculate the number of
            x bills using integer division and the remainder using modulus.
        */

        int moneyValue, value;
        int hundredBill, twentyBill,tenBill,fiveBill,oneBill;

        System.out.println("*** Question 1 ***");
        System.out.println("Please input the total amount of money: ");
        moneyValue = input.nextInt();

        value = moneyValue;

        hundredBill = value / 100;
        value = value % 100;

        twentyBill = value / 20;
        value = value % 20;

        tenBill = value / 10;
        value = value % 10;

        fiveBill = value / 5;
        value = value % 5;

        oneBill = value;

        System.out.println("\t$" + moneyValue + " is");
        System.out.printf("\t\t$100 Bills %4d \n", hundredBill);
        System.out.printf("\t\t$20  Bills %4d \n", twentyBill);
        System.out.printf("\t\t$10  Bills %4d \n", tenBill);
        System.out.printf("\t\t$5   Bills %4d \n", fiveBill);
        System.out.printf("\t\t$1   Bills %4d \n", oneBill);

         /*
            Question 2) First the number of days is calculated from the value read in using integer division (x/86400).
            The remainder is determined using modulus (x % 86400). Then the number of hours is calculated from the
            previous remainder using integer division (x /3600) and the modulus to calculate the remainder. The same
            technique is used to calculate the number of minutes and seconds. The remainder from the previous
            calculation is used to determine the next value.
        */

        System.out.println("\n*** Question 2 ***");

        int timeValue, value2;
        int daysValue, hrsValue, minsValue, secsValue;

        System.out.println("Please input the time in seconds: ");
        timeValue = input.nextInt();
        value2 = timeValue;

        daysValue = value2 / (24*60*60);
        value2 = value2 % (24 * 60 * 60 );

        hrsValue = value2 / (60*60);
        value2 = value2 % (60 * 60);

        minsValue = value2 / (60);
        value2 = value2 % 60;

        secsValue = value2;

        System.out.printf("\t%d seconds are\n", timeValue);
        System.out.printf("%13d    Days\n", daysValue);
        System.out.printf("%13d    Hours\n", hrsValue);
        System.out.printf("%13d    Minutes\n", minsValue);
        System.out.printf("%13d    Seconds\n", secsValue);

        System.out.println("\n*** End Program ***");
    }

}

/*
Questions
1. Do we have to print the comma with the seconds.
2. Should  I use \n or %n
 */