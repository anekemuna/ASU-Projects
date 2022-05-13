// Assignment #:  11
//         Name:  Munachimso Aneke
//   Student ID:  1215028815
//      Lecture:  TTh 9:00am (CSE 205)
//  Description:  Attributes of the MazeSolver used to navigate the maze

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MazeSolver {

	// instance variables
	private Stack <Node> stack;
	private char [][] maze;
	private int eggFound;
	private int mHeight;
	private int mWidth;

	// MazeSolver() constructor
	public MazeSolver()
	{
		stack = new Stack<>();
		stack.push(new Node(0,0));
		eggFound = 0;
	}

	// depthFirstSearch(): maze traverse algorithm
	public void depthFirstSearch()
	{
		int x = 0, y = 0;
		Node n1 = null;
		// while stack is not empty
		while (!stack.isEmpty())
		{
			// pop a node of the stack
			Node n = stack.pop();

			// if there's an egg
			if(maze[n.getX()][n.getY()] == 'E')
			{
				// increment egg count
				eggFound++;
			}

			// mark current node as visited
			maze[n.getX()][n.getY()] = 'x';

			// South
			// coordinate of the south
			x = n.getX();
			y = n.getY() + 1;
			if( x >= 0 && x  < mHeight && y >= 0 && y < mWidth)  // if the coordinates are in bound
			{
				// if node is  not visited (x) or node is not a wall (#)
				if(maze[x][y] != 'x' && maze[x][y] != '#')
				{
					n1 = new Node(x,y); // create a new node
					stack.push(n1); // push into the stack
				}
			}

			// East
			// coordinate of the east
			x = n.getX() - 1;
			y = n.getY();
			if( x >= 0 && x  < mHeight && y >= 0 && y < mWidth)  // if the coordinates are in bound
			{
				// if node is  not visited (x) or node is not a wall (#)
				if(maze[x][y] != 'x' && maze[x][y] != '#')
				{
					n1 = new Node(x,y); // create a new node
					stack.push(n1); // push into the stack
				}
			}

			// North
			// coordinate of the north
			x = n.getX();
			y = n.getY() - 1;
			if( x >= 0 && x  < mHeight && y >= 0 && y < mWidth)  // if the coordinates are in bound
			{
				// if node is  not visited (x) or node is not a wall (#)
				if(maze[x][y] != 'x' && maze[x][y] != '#')
				{
					n1 = new Node(x,y); // create a new node
					stack.push(n1); // push into the stack
				}
			}

			// West
			// coordinate of the west
			x = n.getX() + 1;
			y = n.getY();
			if( x >= 0 && x  < mHeight && y >= 0 && y < mWidth)  // if the coordinates are in bound
			{
				// if node is  not visited (x) or node is not a wall (#)
				if(maze[x][y] != 'x' && maze[x][y] != '#')
				{
					n1 = new Node(x,y); // create a new node
					stack.push(n1); // push into the stack
				}
			}
		}
	}

	// getEggFound(): returns number of egg found
	public int getEggFound()
	{
		return eggFound;
	}

	// printMaze(): print out the maze
	public void printMaze()
	{
		for (int i = 0; i < mHeight; i++)
		{
			for (int j = 0; j < mWidth; j++)
			{
				System.out.print(maze[i][j]);
			}

			System.out.println();
		}
		System.out.println();
	}


	// ************************************************************************************
	// ************** Utility method to read maze from user input *************************
	// ************************************************************************************
	public void readMaze() {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Height of the maze: ");
			String line = reader.readLine();
			mHeight = Integer.parseInt(line);

			System.out.println("Width of the maze: ");
			line = reader.readLine();
			mWidth = Integer.parseInt(line);
			maze = new char[mHeight][mWidth];

			for (int i = 0; i < mHeight; i++) {
				line = reader.readLine();
				for (int j = 0; j < mWidth; j++) {
					maze[i][j] = line.charAt(j);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
