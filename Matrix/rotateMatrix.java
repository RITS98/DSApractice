//Given a matrix, clockwise rotate elements in it.

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class rotateMatrix
{
	public static void rotateClockwise(int mat[][], int m, int n)
	{
		int row = 0, col = 0;
		int prev, curr;

		while(row<m && col< n)
		{
			if(row+1==m || col+1 ==n)
				break;

			//first row

			prev = mat[row+1][col];
			for(int i = col;i<n;i++)
			{
				curr = mat[row][i];
				mat[row][i] = prev;
				prev = curr; 
			}
			row ++;

			//last col
			for(int i = row;i<m;i++)
			{
				curr = mat[i][n-1];
				mat[i][n-1] = prev;
				prev = curr;
			}

			n--;
			//last row
			for(int i = n-1;i>=col ;i--)
			{
				curr = mat[m-1][i];
				mat[m-1][i] = prev;
				prev = curr; 
			}
			m--;
			//m = row<m?m-1:m;

			//first column
			for(int i = m-1;i>=row ;i--)
			{
				curr = mat[i][col];
				mat[i][col] = prev;
				prev = curr;
			}
			col++;
			//col = col<n?col+1:col;
		}

	}

	public static void prinMatrix(int mat[][], int r, int c)
	{
		for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            System.out.print( mat[i][j] + " ");
            System.out.print("\n");
        }
	}

	public static void main(String[] args) 
    {
    // Test Case 1
    int a[][] = { {1, 2, 3, 4,9},
                  {5, 6, 7, 8,7},
                {9, 10, 11, 12,8},
                {13, 14, 15, 16,0} };
  
    // Tese Case 2
    int ar[][] = new int[][] {{1}};
    prinMatrix(a, 4, 5);
    System.out.println("-----------------------");
    rotateClockwise(a, 4, 5);
    prinMatrix(a, 4, 5);
      
    System.out.println();
    rotateClockwise(ar, 1, 1);
    prinMatrix(ar,1,1);
    }
}