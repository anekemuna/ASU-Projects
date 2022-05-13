/*
  Assignment #: 4
  Name:         Munachimso Aneke
  StudentID:    1215028815
  Lecture:      CSE 205 (T Th 9am)
  Description: Coach Class describes information for a coach.
 */

// Describes information for a coach
public class Coach
{
    private String firstName; // first name
    private String lastName;  // last name
    private int years;        // Number of years coached

    // Default Constructor
    public Coach()
    {
        // initialize instance variables
        firstName = "?";
        lastName = "?";
        years = 0;
    }

    // Constructor
    public Coach(String first, String last, int years)
    {
        // initialize instance variables
        this.firstName = first;
        this.lastName = last;
        this.years = years;
    }

    // getFirstName()- returns the firstName
    public String getFirstName()
    {
        return firstName;
    }

    // getLastName()- returns the lastName
    public String getLastName()
    {
        return lastName;
    }

    // getYears()- returns the years
    public int getYears() {
        return years;
    }

    // setFirstName()- sets the firstName
    public void setFirstName(String someFirstName)
    {
        firstName = someFirstName;
    }

    // setLastName()-Sets the lastName
    public void setLastName(String someLastName)
    {
        lastName = someLastName;
    }

    // setYears()- Sets the years
    public void setYears(int years)
    {
        this.years = years;
    }

    // toString()- Returns the data in a string format
    public String toString()
    {
        return String.format("\nLast Name:\t%s" +
                "\nFirst Name:\t%s" +
                "\nYears of Experience:\t%d\n", lastName,firstName, years);
    }
}
