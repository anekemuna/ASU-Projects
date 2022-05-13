/*
  Assignment #: 4
  Name:         Munachimso Aneke
  StudentID:    1215028815
  Lecture:      CSE 205 (T Th 9am)
  Description: Team class describes a sports team
 */

public class Team
{
    private String name;  // name of team
    private Coach coach;  // coach of team
    private String city;  // city  of team

    // Default Constructor
    public Team()
    {
        // initialize instance variables
        name = "?";
        coach = null;
        city = "?";
    }

    // Constructor
    public Team (String name, Coach coach, String cityName)
    {
        // Initialize instance variables
        this.name = name;
        this.coach = coach;
        this.city = cityName;

    }

    // getName() - return name
    public String getName()
    {
        return name;
    }

    // getCoach() - return coach

    public Coach getCoach()
    {
        return coach;
    }

    // getCity() - return city
    public String getCity()
    {
        return city;
    }

    // setName() - set name
    public void setName(String someName)
    {
        name = someName;
    }

    // setCity() - set city
    public void setCity(String someCity)
    {
        city = someCity;
    }

    // setCoach() - set coach
    public void setCoach(String firstName, String lastName, int years)
    {
        coach.setFirstName(firstName);
        coach.setLastName(lastName);
        coach.setYears(years);
    }

    // toString() - return data in string format
    public String toString()
    {
        String result = String.format("Team's name:\t%s from %s\nCoach Information:", name,city) + coach.toString();

        return result;
    }

}
