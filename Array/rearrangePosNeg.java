/*

An array contains both positive and negative numbers in random order. 
Rearrange the array elements so that positive and negative numbers are placed alternatively. 
Number of positive and negative numbers need not be equal. 
If there are more positive numbers they appear at the end of the array. 
If there are more negative numbers, they too appear in the end of the array.

*/


import java.io.*;
import java.util.*;
import java.util.stream.*;


public class rearrangePosNeg
{
	public static void rearrange(int arr[],int n)
	{
		int i = -1;
		for(int j = 0;j<n;j++)
		{
			if(arr[j]<0)
			{
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		printArray(arr,n);

		int pos = i+1, neg = 0;

		while(pos<n && neg<pos && arr[neg] < n)
		{
			int temp = arr[neg];
			arr[neg] = arr[pos];
			arr[pos] = temp;

			pos++;
			neg+=2;
		}
	}

	static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + "   ");

        System.out.println("\n-------------------");
    }

	public static void main(String args[])throws IOException
	{
		int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        int n = arr.length;
        rearrange(arr,n);
        System.out.println("Array after rearranging: ");
        printArray(arr,n);
	}
}