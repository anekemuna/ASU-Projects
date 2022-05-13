//--------------------------------------------------------------------------------
// AUTHOR:         Munachimso Aneke
// FILENAME:       Student.java
// SPECIFICATION:  Student class definitions for Lab11
// LAB LETTER:     H
// DATE:           11/10/2021
//--------------------------------------------------------------------------------

public class Student
{
    private String name;
    private int marks;

    // Student Constructor
    public Student (String someName, int someMarks)
    {
        name = someName;
        marks = someMarks;
    }

    // Mutator
    public void setMarks(int newMarks)
    {
        marks = newMarks;
    }

    // Accessors
    public int getMarks()
    {
        return marks;
    }

    public String getName()
    {
        return name;
    }

}
