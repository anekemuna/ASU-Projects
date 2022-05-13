//*************************************************************
// Name: Munachimso Aneke
// Title: Quiz.java
// Time spent: 1.8 hrs
// Date: 10/15/21
//*************************************************************

/*
a. The program initializes an object called quiz with null values and 'F' for answer. Using a do-while loop, the program collects
   user inputs and store it in a variable (command).

   If command = 'A', the program would first display the values of the quiz object, ask the user for an input to check the values with.
   The program will display “No!” if the input is incorrect, and “Good Job!” if the input matches.

   If the command = 'B', the program lets you edit the set questions, which the user inputs.

   If command = 'C', the program lets you change the value of the choices and set the value of the correct answer.

   If command = 'S', the program shuffles the order of the choices to the questions.

   If command = '?', the program prints out the command options.

   If the command = 'Q', the program ends.

   Any other command is an invalid command, and the program will request another input.

   In general, quiz is an object which stores a question, the options for the answer, and the answer (properties of the Quiz class).
   The program allows manipulation of the quiz object.

b. quiz is an object, Quiz is the class.

c. Quiz(String q, String a, String b, String c, String d, char ans)     at line 16,
   displayQuiz()                                        at line 25,
   isCorrect(char input)                                at line 28,
   setQuestion(String q)                                at line 35,
   set4Choices(String A, String B, String C, String D)  at line 47,
   setCorrectAnswer(char ans)                           at line 50,
   shuffle()                                            at line 54,

d. next() reads inputs from users until it detects a space, " ". The nextLine() reads input from users until it detects
   a newline, "\n". When reading the question inout, we do not want the next word but the whole questions.

e. When the user's command = '?', runs the method called printMenu(). printMenu() prints our the command options
   for this program.

*/


public class Quiz
{
    // instance variables
    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private char answer;

    // Constructor
    public Quiz(String newQuestion, String newChoiceA, String newChoiceB, String newChoiceC, String newChoiceD,
                char newAnswer)
    {
        // initialize instance variables
        question = newQuestion;
        choiceA = newChoiceA;
        choiceB = newChoiceB;
        choiceC = newChoiceC;
        choiceD = newChoiceD;
        answer = newAnswer;
    }

    // Displays Quiz values
    public String displayQuiz()
    {
        return String.format("Q: %s\nA): %s\nB): %s\nC): %s\nD): %s\n", question, choiceA, choiceB, choiceC, choiceD);
    }

    // Sets the value of the Question
    public void setQuestion( String newQuestion)
    {
        question = newQuestion;
    }

    // Set the values of the Choices
    public void set4Choices(String a, String b, String c, String d)
    {
        choiceA = a;
        choiceB = b;
        choiceC = c;
        choiceD = d;
    }

    // Set the value of the correct answer
    public  void setCorrectAnswer(char ans)
    {
        answer = ans;
    }

    // Gets the value of a choice (private)
    private String getChoice(char choice)
    {
       /* String option;
        switch (choice)
        {
            case 'A':
                option = choiceA;
                break;
            case 'B':
                option = choiceB;
                break;
            case 'C':
                option = choiceC;
                break;
            case 'D':
                option = choiceD;
                break;
            default:
                option = "";
        }*/

        if(choice == 'A')
        {
            return choiceA;
        }
        else if(choice == 'B')
        {
            return choiceB;
        }
        else if(choice == 'C')
        {
            return choiceC;
        }
        else if(choice == 'D')
        {
            return choiceD;
        }
        //return option;
        return "";
    }

    // Checks if the answer is correct
    public boolean isCorrect(char input)
    {
        return input == answer; // returns false if  not true
    }

    // Shuffles the order of the choice options
    public  void shuffle()
    {
        String str = "ABCD";
        String randomStr = "";

        while(str.length() != 0)
        {
            int index = (int) (Math.random() * str.length());

            randomStr += str.charAt(index);

            if(index == str.length()-1)
            {
                str = str.substring(0,str.length()-1);
            }
            else
            {
                str = str.substring(0,index) + str.substring(index+1);
            }

        }

        // Set correct answer
        String oldAns = getChoice(answer);


        String tempA = getChoice(randomStr.charAt(0));
        String tempB = getChoice(randomStr.charAt(1));
        String tempC = getChoice(randomStr.charAt(2));
        String tempD = getChoice(randomStr.charAt(3));

        set4Choices(tempA, tempB,tempC, tempD);

        if(oldAns.equals(tempA))
        {
            setCorrectAnswer('A');
        }
        else if(oldAns.equals(tempB))
        {
            setCorrectAnswer('B');
        }
        else if(oldAns.equals(tempC))
        {
            setCorrectAnswer('C');
        }
        if(oldAns.equals(tempD))
        {
            setCorrectAnswer('D');
        }
    }

}

// Questions
// 1. For the getChoice function, is it possible for an invalid choice?
//    Also, will have to have an extra return.
// 2. Should the random list use a list or an array?
// 3. Do not understand Shuffle function
