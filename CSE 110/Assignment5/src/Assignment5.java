//***********************************************************
// Name: CSE110 Instructor
// Title: Assignment5.java
// Description: Test code for Assignment5
// Date:  Posted on XX/XX/XXXX
//**********************************************************
import java.util.Scanner;
public class Assignment5 {
  public static void main(String[] arg){

	System.out.println(" ****** Tester Program ******");
	printMenu();
	Scanner in = new Scanner (System.in);
	char command;  		// command letter

	Quiz quiz = new Quiz(null, null, null, null, null, 'F');

	do{
		System.out.print("Please input a command:\n(A:Quiz, B:Edit question, C:Edit choices, S:Shuffle, Q:quit)");
		command = in.nextLine().toUpperCase().charAt(0);

		switch(command){
			case 'A':
				System.out.print("\n\t A [Test the quiz!] \n" );
				System.out.print(quiz.displayQuiz());
				System.out.print("\n\t [Type A, B, C or D] \n" );
				char input = in.nextLine().toUpperCase().charAt(0);
				if ( quiz.isCorrect(input) ) System.out.println("Good Job!");
				else System.out.println("No!");
				break;
			case 'B':
				System.out.print("\n\t B [Edit the question] " );
				System.out.print("\n\t [Type a question]: " );
				String q = in.nextLine();
				quiz.setQuestion(q);//read a line
				break;
			case 'C':
				System.out.print("\n\t C [Edit the first choice] " );
				System.out.print("\n\t [Type the first choice A]: " );
				String A = in.nextLine();//read a line
				System.out.print("\n\t [Type the second choice B]: " );
				String B = in.nextLine();
				System.out.print("\n\t [Type the third choice C]: " );
				String C = in.nextLine();
				System.out.print("\n\t [Type the forth choice D]: " );
				String D = in.nextLine();
				quiz.set4Choices(A, B, C, D);//read a line
				System.out.print("\n\t [Type the correct answer]: " );
				char ans = in.nextLine().toUpperCase().charAt(0);
				quiz.setCorrectAnswer(ans);
				break;
			case 'S':
				System.out.print("\n\t S [Shuffle the choices] " );
				quiz.shuffle();
				break;
			case '?': printMenu(); break;
			case 'Q': break;
			default: System.out.print("\n\t Invalid: *** Type '?' to get the commands***"); break;
		}
		System.out.println("\n");
	}while(command != 'Q');
	 System.out.println(" ****** End of Program ******");
} // end of main ()

   // Answer the
   // Display the command menu
   public static void printMenu(){
		System.out.println();
		System.out.println("Command Options --------------------");
		System.out.println("A: Test the quiz");
		System.out.println("B: Edit the question");
		System.out.println("C: Edit the choices");
		System.out.println("S: Shuffle the choices");
		System.out.println("Q: Quit the program");
		System.out.println("?: Display this menu ");
		System.out.println("------------------------------------");
	}
}