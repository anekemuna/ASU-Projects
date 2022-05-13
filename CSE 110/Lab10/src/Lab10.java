//----------------------------------------------------------------------------------------------------------
// AUTHOR:         Munachimso Aneke
// FILENAME:       Lab10.java
// SPECIFICATION:  This program is for practicing 2D Arrays
// LAB LETTER:     H
//-----------------------------------------------------------------------------------------------------------


import java.util.Scanner;

public class Lab10 {
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);

        // create 4x4 arrays
        int[][] mat_A, mat_B, mat_C, mat_D;
        mat_A = new int[4][4];
        mat_B = new int[4][4];
        mat_C = new int[4][4];
        mat_D = new int[4][4];

        // read values int mat_A
        System.out.println("Enter values int mat_A: ");
        for (int j = 0; j < 4; j++)
        {
            for (int i = 0; i < 4; i++ )
            {
                mat_A[i][j] = in.nextInt();
            }
        }

        // Display mat_A
        //System.out.println("Matrix A is: ");
        for (int j = 0; j < 4; j++)
        {
            for (int i = 0; i < 4; i++ )
            {
                System.out.print(mat_A[i][j] + "\t\t");

            }
            System.out.println();
        }

        // read values into mat_B
        System.out.println("\nEnter values int mat_B: ");
        for (int j = 0; j < 4; j++)
        {
            for (int i = 0; i < 4; i++ )
            {
                mat_B[i][j] = in.nextInt();
            }
        }

        // Display mat_B
        //System.out.println("Matrix B is: ");
        for (int j = 0; j < 4; j++)
        {
            for (int i = 0; i < 4; i++ )
            {
                System.out.print(mat_B[i][j] + "\t\t");

            }
            System.out.println();
        }

        // Task 1:
        // Matrix Addition (store value in mat_C)
        for (int j = 0; j < 4; j++)
        {
            for (int i = 0; i < 4; i++ )
            {
                mat_C[i][j] = mat_A[i][j] + mat_B[i][j];

            }
        }

        // Display mat_C
        System.out.println("\nAddition of two matrices: Matrix C is");
        for (int j = 0; j < 4; j++)
        {
            for (int i = 0; i < 4; i++ )
            {
                System.out.print(mat_C[i][j] + "\t\t");

            }
            System.out.println();
        }

        // Task 2:
        // Sum of elements in mat_C
        int sum = 0;
        for (int j = 0; j < 4; j++)
        {
            for (int i = 0; i < 4; i++ )
            {
                sum += mat_C[i][j];

            }
        }

        // Display sum
        System.out.println("Sum of elements of matrix C is " + sum);

        // Task 3:
        // Transpose of matrix C (store in mat_D)
        for (int j = 0; j < 4; j++)
        {
            for (int i = 0; i < 4; i++ )
            {
                mat_D[i][j] = mat_C[j][i];

            }
        }

        // Display mat_D
        System.out.println("\nTranspose of matrix C is ");
        for (int j = 0; j < 4; j++)
        {
            for (int i = 0; i < 4; i++ )
            {
                System.out.print(mat_D[i][j] + "\t\t");

            }
            System.out.println();
        }


    }
}

