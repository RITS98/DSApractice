/*
Given an array of integers, update every element with multiplication of previous and next elements with following exceptions.
a) First element is replaced by multiplication of first and second.
b) Last element is replaced by multiplication of last and second last.

*/


import java.io.*;
import java.util.*;
import java.util.stream.*;


public class replaceMultiplyPrevNext
{
	public static void modify(int arr[], int n)
	{
		int prev = arr[0];
		for(int i =0;i<n;i++)
		{
			if(i == 0)
			{
				arr[i] = arr[i]*arr[i+1];
			}
			else if(i == n-1)
			{
				arr[i] = prev*arr[i];
			}
			else
			{
				int x = arr[i];
				arr[i] = prev*arr[i+1];

				prev = x;
			}
		}
	}

	public static void main(String args[])throws IOException
	{
		int arr[] = {2, 3, 4, 5, 6};
        int n = arr.length;

        System.out.println(Arrays.toString(arr));
        modify(arr, n);
        System.out.println(Arrays.toString(arr));
	}
}