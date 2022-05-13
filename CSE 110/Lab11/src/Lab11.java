//--------------------------------------------------------------------------------
// AUTHOR:         Munachimso Aneke
// FILENAME:       Lab11.java
// SPECIFICATION:  Manipulating an array of objects.
// LAB LETTER:     H
// DATE:           11/10/2021
//--------------------------------------------------------------------------------


import java.util.Scanner;

public class Lab11
{
    // main method
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        String name;
        int marks, num, choice;

        System.out.println("Enter the total number of Students");
        num = in.nextInt();

        Student[] students = new Student[num];

        for(int i = 0; i < num; i++)
        {
            System.out.println("Enter name and marks of student(" + (i+1) + ")");
            name = in.next();
            marks = in.nextInt();

            students[i] = new Student(name, marks);
        }

        final int SUM = 1;
        final int UPDATE = 2;
        final int SWAP = 3;
        final int MAX_MARKS = 4;
        final int QUIT = 5;

       do
       {
           System.out.println("This program will do the following");
           System.out.println("1. Total marks");
           System.out.println("2. Update a student's marks");
           System.out.println("3. Swap marks");
           System.out.println("4. Find maximum marks");
           System.out.println("5. Exit");
           System.out.println("Give your choice for the above options");

           choice = in.nextInt();

           switch (choice)
           {
               case SUM:
                   System.out.println("The sum of marks is " + sum(students));
                   break;
               case UPDATE:
                   System.out.println("Enter student name");
                   String nName = in.next();

                   System.out.println("Enter student marks");
                   int nMarks = in.nextInt();

                   update(students, nName, nMarks);
                   break;
               case SWAP:
                   System.out.println("Enter first student's name");
                   String name1 = in.next();

                   System.out.println("Enter second student's name");
                   String name2 = in.next();

                   swap(students, name1, name2);
                   break;
               case MAX_MARKS:
                   System.out.println("Maximum marks obtained are: " + max(students));
                   break;
               case QUIT:
                   System.out.println("Exiting the program...");
                   break;
               default:
                   System.out.println("Invalid choice, try again!");
                   break;
           }

       } while(choice != QUIT);
    }


    // returns the sum of marks for a list of students
    public static int sum(Student[] _student)
    {
        int sum = 0;
        for(int i = 0; i < _student.length; i++)
        {
            sum += _student[i].getMarks(); // sum scores
        }

        return sum;
    }

    // update a student's mark
    public static void update(Student [] _student, String _name, int _value)
    {
        for(int i = 0; i < _student.length; i++)
        {
            if(_student[i].getName().equals(_name)) // check for matches
            {
                _student[i].setMarks(_value);
            }
        }

        print(_student); // print function return at the bottom
    }

    // max marks among a list of student
    public static int max(Student[] _student)
    {
        int max = _student[0].getMarks();

        for(int i = 1; i < _student.length; i++)
        {
            if(max < _student[i].getMarks())
            {
                max = _student[i].getMarks();
            }
        }

        return max;
    }

    // Swapping mark of 2 students
    public static void swap(Student[] _student, String name1, String name2)
    {
        int index1 = 0, index2 = 0;

        for(int i = 0; i < _student.length; i++)
        {
            if(_student[i].getName().equals(name1))
            {
                index1 = i;
            }

            if(_student[i].getName().equals(name2))
            {
                index2 = i;
            }
        }

        // Swapping
        int temp = _student[index1].getMarks();
        _student[index1].setMarks(_student[index2].getMarks());
        _student[index2].setMarks(temp);

        print(_student);
    }

    // print (display list of students
    public static void print(Student[] _student)
    {
        System.out.println("The list is: ");

        for(int i = 0; i < _student.length; i++)
        {
            System.out.println("Name : " + _student[i].getName() + ", Marks : " + _student[i].getMarks());
        }
    }
}

