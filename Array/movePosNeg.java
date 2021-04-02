/*
Move all negative numbers to beginning and positive to end with constant extra space.

An array contains both positive and negative numbers in random order. 
Rearrange the array elements so that all negative numbers appear before all positive numbers.
Examples : 

Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
Output: -12 -13 -5 -7 -3 -6 11 6 5

*/

import java.io.*;
import java.util.*;
import java.util.stream.*;


public class movePosNeg
{
	public static void moveNos(int arr[], int n)
	{
		int left = 0, right = n-1;

		while(left< right)
		{
			if(arr[left]<0 && arr[right]<0)
				left++;

			else if(arr[left]>0 && arr[right]<0)
			{
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				right --;
				left ++;
			}
			else
				right --;

		}

	}

	public static void main(String args[])throws IOException
	{
		int arr[] = new int[]{ -12, 11, -13, -5,
                   6, -7, 5, -3, 11 };

        System.out.println(Arrays.toString(arr));
        moveNos(arr, arr.length);
        System.out.println(Arrays.toString(arr));

	}
}