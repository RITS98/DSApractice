/*
Given two matrices A and B. The task is to multiply matrix A and matrix B recursively. If matrix A and matrix B are not multiplicative compatible, then generate output “Not Possible”.
*/


import java.io.*;
import java.util.*;
import java.util.stream.*;


public class matrixMulRecur
{
	public static int i = 0,  j =0, k = 0;
	public static void mulRecur(int row1, int col1, int A[][], int row2, int col2, int B[][], int C[][])
	{
		if(i>=row1)
			return;

		if(j<col2)
		{
			if(k<col1)
			{
				C[i][j] += A[i][k]*B[k][j];
				k++;
				mulRecur(row1, col1, A, row2, col2,B,C);
			}

			k = 0;
			j++;
			mulRecur(row1,col1,A,row2,col2,B,C);
		}

		j=0;
		i++;
		mulRecur(row1,col1,A,row2,col2,B,C);
	}

	public static void multiply(int A[][], int B[][])
	{
		int row1 = A.length;
		int col1 = A[0].length;

		int row2 = B.length;
		int col2 = B[0].length;

		int C[][] = new int[row1][col2];

		if(col1 != row2)
		{
			System.out.println("NOT possible");
			return;
		}

		mulRecur(row1, col1, A, row2, col2, B, C);
		printMatrix(C, row1, col2);

	}

	public static void printMatrix(int C[][], int r, int c)
	{
		for(int i = 0;i<r;i++)
		{
			for(int j = 0;j<c;j++)
			{
				System.out.print(C[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main (String[] args) 
    {
        int row1 = 3, col1 = 3, row2 = 3, col2 = 3;
        int A[][] = { {1, 2, 3},
                      {4, 5, 6},
                      {7, 8, 9}};
   
        int B[][] = { {1, 2, 3},
                      {4, 5, 6},
                      {7, 8, 9} };
   
        multiply(A, B);
    }


}
