/*

Given a matrix, sort the rows of matrix in ascending order followed by sorting the columns in descending order.
Examples :

Input : a[3][3] = {{1, 2, 3},
                  {4, 5, 6}, 
                  {7, 8, 9}};
Output : 7 8 9
         4 5 6
         1 2 3

Input : a[3][3] = {{3, 2, 1},
                  {9, 8, 7}, 
                  {6, 5, 4}};
Output : 7 8 9
         4 5 6
         1 2 3

Algorithm
1) Traverse all rows one by one and sort rows in ascending order using simple array sort.
2) Convert matrix to its transpose
3) Again sort all rows, but this time in ascending order.
4) Again convert matrix to its transpose

*/

import java.io.*;
import java.util.*;
import java.util.stream.*;


public class sortRowsColumns
{
	public static void sortRow(Integer arr[][], int r, boolean flag)
	{
		for(int i =0;i<r;i++)
		{
			if(flag)
			Arrays.sort(arr[i]);
			else
			Arrays.sort(arr[i],Collections.reverseOrder());
		}
	}

	public static void transpose(Integer mat[][], int r, int c)
	{
		for(int i =0;i<r;i++)
		{
			for(int j = 0;j<i;j++)
			{
				Integer temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
	}

	public static void sort(Integer mat[][], int r, int c)
	{
		sortRow(mat, r, true);
		transpose(mat, r, c);
		sortRow(mat, r, false);
		transpose(mat, r, c);
	}

	public static void printMatrix(Integer mat[][], int r, int c)
	{
		for(int i =0;i<r;i++)
		{
			for(int j =0;j<c;j++)
			{
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}


	public static void main(String args[])
	{
		int n=3;
		Integer mat[][] = {{3, 2, 1},
                           {9, 8, 7}, 
                           {6, 5, 4}};
      
        System.out.print("Original Matrix:\n");
        printMatrix(mat, n, n);
      
        sort(mat, n, n);
      
        System.out.print("\nMatrix After Sorting:\n");
        printMatrix(mat, n, n);
	}
}