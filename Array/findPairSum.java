/*

Given an array that is sorted and then rotated around an unknown point. Find if the array has a pair with a given sum ‘x’. It may be assumed that all elements in the array are distinct.

Examples :

Input: arr[] = {11, 15, 6, 8, 9, 10}, x = 16
Output: true
There is a pair (6, 10) with sum 16

Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 35
Output: true
There is a pair (26, 9) with sum 35

Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 45
Output: false
There is no pair with sum 45.


https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/
*/

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class findPairSum
{
	public static int findPivot(int arr[], int low, int high)
	{

		if(high<low)
			return -1;
		if(high == low)
			return low;

		int mid = (low+high)/2;
		if(arr[mid]<arr[high] && arr[mid+1]<arr[mid])
			return mid;

		if(mid>low && arr[mid-1]>arr[mid])
			return mid-1;

		if(arr[mid]>arr[high])
			return findPivot(arr, mid + 1 , high);
		return findPivot(arr, low, mid - 1);
	}

	public static boolean pairSumExists(int arr[], int size, int sum)
	{
		int pivot = findPivot(arr, 0, size - 1);

		int l = (pivot + 1)%size;			//stores the index of smallest element
		int r = pivot;					//stores the index of largest element

		while(l!=r)
		{
			if(arr[l] + arr[r] == sum)
				return true;


			if(arr[l] + arr[r] < sum)
				l = (l+1)%size;
			else
				r = (size + r - 1)%size;
		}

		return false;
	}

	public static int countPairSum(int arr[], int size, int sum)
	{
		int count = 0;
		int pivot = findPivot(arr, 0, size -1);

		int l = (pivot + 1)%size;			//stores the index of smallest element
		int r = pivot;					//stores the index of largest element

		while(l!=r)
		{
			if(arr[l]+arr[r] == sum)
			{
				count++;

				if(l == (r + size - 1)%size)
				{
					return count;
				}

				/*if(arr[l] == arr[(l+1)%size])
					count++;
				if(arr[r] == arr[(size+r-1)%size])
					count++;*/

				l = (l+1)%size;
				r = (size + r -1)%size;
			}

			else if(arr[l]+arr[r] < sum)
				l = (l+1)%size;

			else
				r = (r+size - 1)%size;
		}

		return count;
	}


	public static void main(String args[])throws IOException
	{
		int arr[] = new int[]{ 11, 15, 6, 7, 9, 10};
		int sum =  16;
		//does not work for duplicates
		System.out.println(pairSumExists(arr, arr.length - 1, sum));
		System.out.println(countPairSum(arr, arr.length - 1, sum));
	}
}