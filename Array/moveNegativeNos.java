/*
Given an unsorted array of both negative and positive integer. The task is place all negative element at the end of array without changing the order of positive element and negative element.

Examples:

Input : arr[] = {1, -1, 3, 2, -7, -5, 11, 6 }
Output : 1  3  2  11  6  -1  -7  -5 

Input : arr[] = {-5, 7, -3, -4, 9, 10, -1, 11}
Output : 7  9  10  11  -5  -3  -4  -1  
*/


import java.io.*;
import java.util.*;
import java.util.stream.*;

public class moveNegativeNos
{
	public static void segregateElements(int arr[], int n)
	{
		int pos[] = Arrays.stream(arr).filter(x -> x>=0).toArray();
		int neg[] = Arrays.stream(arr).filter(x->x<0).toArray();

		for(int i = 0;i<n;i++)
		{
			if(i<pos.length)
				System.out.print(pos[i]+" ");
			else
				System.out.print(neg[i - pos.length]+" ");
		}

		System.out.println("\n");
	}

	public static void main(String[] args) {
		int arr[] = { 1, -1, -3, -2, 7, 5, 11, 6 };
        int n = arr.length;
  
        segregateElements(arr, n);
	}
}