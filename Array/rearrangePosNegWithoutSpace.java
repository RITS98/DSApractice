/*
Given an array of positive and negative numbers, 
arrange them such that all negative integers appear before all the positive integers 
in the array without using any additional data structure like a hash table, arrays, etc. 

THE ORDER OF APPEARANCE SHOULD BE MAINTAINED.

Examples:

Input :  arr[] = [12, 11, -13, -5, 6, -7, 5, -3, -6]
Output : arr[] = [-13, -5, -7, -3, -6, 12, 11, 6, 5]

Input :  arr[] = [-12, 11, 0, -5, 6, -7, 5, -3, -6]
Output : arr[] =  [-12, -5, -7, -3, -6, 0, 11, 6, 5]

*/

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class rearrangePosNegWithoutSpace
{
	public static void printArray(int arr[], int n)
	{
		System.out.println(Arrays.toString(arr));
	}

	public static void reverse(int arr[], int i, int j)
	{
		while(i<j)
		{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		//System.out.println(i+" - "+j);
		printArray(arr, arr.length);

	}

	public static void rearrange(int arr[], int start, int end)
	{
		if(start == end)
			return;


		rearrange(arr, start+1, end);


		
		System.out.println(start+"  -  "+end);
		


		if(arr[start]>=0)
		{
			reverse(arr, start+1, end);
			reverse(arr, start, end);
		}
	}

	public static void main(String args[])throws IOException
	{
		int[] array = {-12, 11, 0, -5, 6, -7, 5, -3, -6};
		int length = array.length;
		int countNegative = 0;
		 
		for (int i = 0; i < length; i++)
		{
		    if (array[i] < 0)
		    countNegative++;
		}
		 
		System.out.print("array: ");
		printArray(array, length);
		rearrange(array, 0,(length - 1));
		reverse(array, countNegative,(length - 1));
		System.out.print("rearranged array: ");
		printArray(array, length);

	}
}

