/*
In mathematics, a square matrix is said to be diagonally dominant if for every row of the matrix, the magnitude of the diagonal entry in a row is larger than or equal to the sum of the magnitudes of all the other (non-diagonal) entries in that row. 
More precisely, the matrix A is diagonally dominant if is diagonally dominant because
|a11| ≥ |a12| + |a13| since |+3| ≥ |-2| + |+1|
|a22| ≥ |a21| + |a23| since |-3| ≥ |+1| + |+2|
|a33| ≥ |a31| + |a32| since |+4| ≥ |-1| + |+2|

Given a matrix A of n rows and n columns. The task is tho check whether matrix A is diagonally dominant or not.

Examples :

Input : A = { { 3, -2, 1 },
              { 1, -3, 2 },
              { -1, 2, 4 } };
Output : YES
Given matrix is diagonally dominant
because absolute value of every diagonal
element is more than sum of absolute values
of corresponding row.

Input : A = { { -2, 2, 1 },
              { 1, 3, 2 },
              { 1, -2, 0 } };
Output : NO

*/



import java.io.*;
import java.util.*;
import java.util.stream.*;


public class diagonalDominantMatrix
{
	public static boolean checkIfDiagonallyDominant(int mat[][], int r, int c)
	{
		int sum = 0;
		int flag = 0;
		for(int i =0;i<r;i++)
		{
			sum = Arrays.stream(mat[0]).map(j->Math.abs(j)).sum();
			sum -= Math.abs(mat[i][i]);

			if(Math.abs(mat[i][i])>= sum)
				flag++;
		}

		if(flag == r)
			return true;
		return false;
	}

	public static void main(String args[])throws IOException
	{
			int n = 3;
	        int m[][] = { { 3, -2, 1 },
	                      { 1, -3, 2 },
	                      { -1, 2, 4 } };
	       
	        if (checkIfDiagonallyDominant(m, n, n))
	             System.out.println("YES") ;
	        else  
	            System.out.println("NO");

	        int mat[][]= new int[][]{{ -2, 2, 1 },{ 1, 3, 2 },{ 1, -2, 0 }};

            if (checkIfDiagonallyDominant(mat, n, n))
	             System.out.println("YES") ;
	        else  
	            System.out.println("NO");
	}

}

	
	
