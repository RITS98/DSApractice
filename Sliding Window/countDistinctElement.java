/*
Given an array of size n and an integer k, return the count of distinct numbers in all windows of size k.

Example:

Input: arr[] = {1, 2, 1, 3, 4, 2, 3};
       k = 4
Output: 3 4 4 3

Explanation:
First window is {1, 2, 1, 3}, count of distinct numbers is 3
Second window is {2, 1, 3, 4} count of distinct numbers is 4
Third window is {1, 3, 4, 2} count of distinct numbers is 4
Fourth window is {3, 4, 2, 3} count of distinct numbers is 3

Input: arr[] = {1, 2, 4, 4};
       k = 2
Output: 2 2 1

Explanation:
First window is {1, 2}, count of distinct numbers is 2
First window is {2, 4}, count of distinct numbers is 2
First window is {4, 4}, count of distinct numbers is 1

*/


//https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/


import java.io.*;
import java.util.*;
import java.util.stream.*;

public class countDistinctElement
{
	public static void countDistinct(int arr[], int k)
	{
		int n = arr.length;
		if(k>n)
		{
			System.out.println("INVALID");
			return;
		}

		ArrayList<Integer> ar = new ArrayList<Integer>();
		for(int i = 0, j = k-1;j<n;i++,j++)
		{
			int count = (int)Arrays.stream(Arrays.copyOfRange(arr, i, j+1)).distinct().count();
			ar.add(count);
		}


		Iterator<Integer> it = ar.iterator();

		while(it.hasNext())
		{
			System.out.print(it.next()+" ");
		}
		System.out.println();
	}

	public static void main(String args[])
	{
		int arr[] = {1, 2, 1, 3, 4, 2, 3};
		int k = 4;

		countDistinct(arr, k);

	}
}