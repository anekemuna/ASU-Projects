// Assignment #:  11
//         Name:  Munachimso Aneke
//   Student ID:  1215028815
//      Lecture:  TTh 9:00am (CSE 205)
//  Description:  Driver of the Easter Egg Hunt program

public class Assignment11 {

	public static void main(String[] args) {
		MazeSolver mazeSolver = new MazeSolver();
		mazeSolver.readMaze();

		System.out.println("Original maze: ");
		mazeSolver.printMaze();

		mazeSolver.depthFirstSearch();

		System.out.println("Maze after Easter Bunny traverse: ");
		mazeSolver.printMaze();

		if (mazeSolver.getEggFound() == 0)
			System.out.println("The Bunny was unable to recover the eggs, Easter is cancelled!");
		else
			System.out.println("The Easter Bunny found " + mazeSolver.getEggFound() + " egg(s)!");
	}
}