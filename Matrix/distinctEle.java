/*
Given a n x n matrix. The problem is to find all the distinct elements common to all rows of the matrix. The elements can be printed in any order.
Examples: 

Input : mat[][] = {  {2, 1, 4, 3},
                     {1, 2, 3, 2},  
                     {3, 6, 2, 3},  
                     {5, 2, 5, 3}  }
Output : 2 3

Input : mat[][] = {  {12, 1, 14, 3, 16},
                     {14, 2, 1, 3, 35},  
                     {14, 1, 14, 3, 11},  
                     {14, 25, 3, 2, 1},
                     {1, 18, 3, 21, 14}  }
Output : 1 3 14
*/

//https://www.geeksforgeeks.org/find-distinct-elements-common-rows-matrix/

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class distinctEle
{
	public static void searchDistinct(int mat[][], int r, int c)
	{
		Map<Integer, Integer> m = new HashMap<>();
		for(int j = 0;j<c;j++)
			m.put(mat[0][j],1);

		for(int i =1;i<r;i++)
		{
			for(int j = 0;j<c;j++)
			{
				if(m.get(mat[i][j])!=null && m.get(mat[i][j]) == i)
					m.put(mat[i][j],i+1);
			}
		}

		m.keySet().stream().filter(i-> m.get(i) == r).forEach(System.out::println);
	}

	public static void main(String args[])throws IOException
	{
		int matrix[][] = { { 2, 1, 4, 3 },
                      { 1, 2, 3, 2 },
                      { 3, 6, 2, 3 },
                      { 5, 2, 5, 3 } };
    	int n = 4;
    	searchDistinct(matrix, 4,4);
	}
}