//---------------------------------------------------------------------------
// AUTHOR:         Munachimso Aneke
// FILENAME:       Student.java
// SPECIFICATION:  Student Class
// LAB LETTER:     H
//-------------------------------------------------------------------------

public class Student
{
    private String name;
    private int age;

    public Student (String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public void setAge(int newAge)
    {
        age = newAge;
    }

    public String toString()
    {
        return String.format("Name is\t:%s\nAge is\t\t:%d\n", name, age);
    }

    public  String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }


}
 /*public void toString()
    {
        System.out.printf("Name is\t:%s\n, Age is\t\t:%d\n", name, age);
    }*/

// questions
// 1. I changed the format of toString to avoid errors, is that okay?
// 2. Do we need the accessor methods?