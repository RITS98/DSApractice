/*
Given a matrix mat[][] having n rows and m columns. We need to find unique elements in matrix i.e, those elements which are not repeated in the matrix or those elements whose frequency is 1.

Examples:

Input :  20  15  30  2
         2   3   5   30
         6   7   6   8
Output : 3  20  5  7  8  15 

Input :  1  2  3  
         5  6  2
         1  3  5
         6  2  2
Output : No unique element in the matrix
*/

import java.util.*;
import java.util.stream.*;
import java.io.*;

public class uniqueEle
{
	public static void searchUnique(int mat[][], int r, int c)
	{
		Map<Integer, Integer> map =  new HashMap<>();
		for(int i = 0;i<r;i++)
		{
			for(int j = 0;j<c;j++)
			{
				Integer a = map.get(mat[i][j]);
				if(a!=null)
					map.put(mat[i][j],a+1);
				else
					map.put(mat[i][j],1);
			}
			
		}

		map.keySet().stream().filter(i -> map.get(i) == 1).forEach(System.out::println);

	}

	public static void main(String args[])throws IOException
	{
		int mat[][] = {{1, 2, 3, 20},
                   {5, 6, 20, 25},
                   {1, 3, 5, 6},
                   {6, 7, 8, 15}};
                      
    // function that calculate 
    // unique element
    searchUnique(mat, 4, 4);
	}
}