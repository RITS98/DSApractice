/*
For a given array of n integers and assume that ‘0’ as an invalid number 
and all other as a valid number. Convert the array in such a way that if 
both current and next element is valid then double current value and replace 
the next number with 0. 
After the modification, rearrange the array such that all 0’s shifted to the end. 

*/

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class double1stMoveZeroEnd
{
	public static void rearrange(int arr[], int n)
	{
		for(int i = 0;i<n-1;i++)
		{
			if(arr[i]!=0 && arr[i] == arr[i+1])
			{
				arr[i] = 2*arr[i];
				arr[i+1] = 0;
			}
		}

		for(int i = 0, j = 0;i<n;i++)
		{
			if(arr[i] != 0)
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				j++;
			}
		}
	}


	public static void main(String args[])throws IOException
	{
		int arr[] = { 0, 2, 2, 2, 0, 6, 6, 0, 0, 8 };
        int n = arr.length;
 
        System.out.println("Original array: "+Arrays.toString(arr));
        
 
        rearrange(arr, n);
 
        System.out.println("Modified array: "+Arrays.toString(arr));
        
	}
}