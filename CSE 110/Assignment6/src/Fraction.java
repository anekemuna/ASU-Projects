//**********************************************************************
// Name: Munachimso Aneke
// Title: Fraction.java
// Description: Class Fraction- performs math operations as fractions
// Time spent: 1 hr 45 min
// Date: 10/26/2021
//***********************************************************************

public class Fraction
{
    // Instance variables
    private int numerator;
    private int denominator;

    // Fraction Methods
    // Constructor
    public Fraction(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;

        if(this.denominator == 0) // illegal for denominator to be 0
        {
            System.out.println("\nError: Denominator can't be 0!\n...Setting to Default (0/1)...");
            this.numerator = 0;
            this.denominator = 1;
        }
    }

    // toString()- converts data tto string format
    public String toString()
    {
        if(numerator == 0)
        {
            return "0";
        }
        else if(denominator == 1)
        {
            return String.format("%d", numerator);
        }
        else
        {
            return String.format("%d/%d", numerator, denominator);
        }
    }

    // greatestCommonDivisor(...) - returns the the gcd of 2 integers.
    private int greatestCommonDivisor(int num1, int num2)
    {
        int gcd = 0;  // lowest possible gcd value

        while(num1 != 0 && num2 != 0) // if neither are equal to 0
        {
            if(num1 < num2)      // when num1 is smaller
            {
                num2 -= num1;
            }
            else if(num2 < num1)  // when num2 is smaller
            {
                num1 -= num2;
            }
            else {                // if num1 == num2
                num2 -= num1;
            }

            if(num1 == 0 || num2 == 0) // if either  are equal to 0
            {
                if(num1 == 0)    // store gcd value
                {
                    gcd = num2;
                }
                else
                {
                    gcd = num1;
                }
            }
        }
        return gcd;
    }

    // simplify() - reduces a fraction to it's lowest form
    private void simplify()
    {
        int gcd;

        if(denominator < 0) // if the denominator is negative
        {
            denominator *= -1;
            numerator *= -1;  // make the numerator negative instead
        }

        if(numerator < 0)   // gcd function doesn't work if either numerator or denominator is negative
        {
            int num = numerator * -1; // fixes the problem of negative numerator
            gcd = greatestCommonDivisor(num, denominator);  // store gcd value
        }
        else
        {
            gcd = greatestCommonDivisor(numerator, denominator); // store gcd value
        }

        // simplify fraction
        numerator /= gcd;
        denominator /= gcd;

    }

    // multiply()- Multiplies 2 fractions
    public static Fraction multiply(Fraction a, Fraction b)
    {

        Fraction result = new Fraction((a.numerator * b.numerator),(a.denominator * b.denominator)); // multiply fraction
        result.simplify();   // simplify fraction
        return result;        // return result
    }

    // divide()- divides 2 fractions
    public static Fraction divide(Fraction a, Fraction b)
    {
        Fraction result = new Fraction((a.numerator * b.denominator),(a.denominator * b.numerator)); // multiply by the inverse of b
        result.simplify();   // simplify fraction
        return result;       // return result
    }

    // add()- adds 2 fractions
    public static Fraction add(Fraction a, Fraction b)
    {
        int num = (a.numerator * b.denominator) + (b.numerator * a.denominator);  // numerator
        int denom = a.denominator * b.denominator;                                // denominator

        Fraction result = new Fraction(num,denom);
        result.simplify();
        return result;
    }

    // subtracts()- subtracts 2 fractions
    public static Fraction subtract(Fraction a, Fraction b)
    {
        int num = (a.numerator * b.denominator) - (b.numerator * a.denominator);  // numerator
        int denom = a.denominator * b.denominator;                                // denominator

        Fraction result = new Fraction(num,denom);
        result.simplify();
        return result;
    }


}
//Remember
// 1. Test gcd and simplify method
// 2. Do I have to print out the value of the fraction after the print menu, to match with the sample?
// 3. Should there be a test case for if denominator is 0?
