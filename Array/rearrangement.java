/*
Given an array, rearrange the array such that : 

If index i is even, arr[i] <= arr[i+1]
If index i is odd, arr[i] >= arr[i+1]
Note : There can be multiple answers.
Examples:  

Input  : arr[] = {2, 3, 4, 5} 
Output : arr[] = {2, 4, 3, 5}
Explanation : Elements at even indexes are
smaller and elements at odd indexes are greater
than their next elements

Note : Another valid answer
is arr[] = {3, 4, 2, 5}

Input  :arr[] = {6, 4, 2, 1, 8, 3}
Output :arr[] = {4, 6, 1, 8, 2, 3}

fg
This problem is similar to sort an array in wave form.
A simple solution is to sort the array in decreasing order, then starting from second element, swap the adjacent elements.
An efficient solution is to iterate over the array and swap the elements as per the given condition. 
If we have an array of length n, then we iterate from index 0 to n-2 and check the given condition. 
At any point of time if i is even and arr[i] > arr[i+1], then we swap arr[i] and arr[i+1]. Similarly, if i is odd and 
arr[i] < arr[i+1], then we swap arr[i] and arr[i+1].

*/

import java.io.*;
import java.util.*;
import java.util.stream.*;


public class rearrangement
{
	public static void swap(int arr[], int i ,int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void rearrange(int arr[])
	{
		int n = arr.length;

		for(int i = 1;i<n;i++)
		{
			int j = i - 1;
			if(j%2 == 0)
			{
				if(arr[j] > arr[i])
					swap(arr, i, j);
				else
					continue;
			}
			else
			{
				if(arr[j]<arr[i])
					swap(arr, i, j);
				else
					continue;
			}
		}

		System.out.println(Arrays.toString(arr));
	}

	public static void main(String args[])
	{
		int arr[] =  {6, 4, 2, 1, 8, 3};
		rearrange(arr);
	}
}