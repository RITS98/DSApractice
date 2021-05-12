/*KADANE ALGORITHM
Given an array of integers of size ‘n’.
Our aim is to calculate the maximum sum of ‘k’ 
consecutive elements in the array.

Input  : arr[] = {100, 200, 300, 400}
         k = 2
Output : 700

Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
         k = 4 
Output : 39
We get maximum sum by adding subarray {4, 2, 10, 23}
of size 4.

Input  : arr[] = {2, 3}
         k = 3
Output : Invalid
There is no subarray of size 3 as size of whole
array is 2.

*/


import java.io.*;
import java.util.*;
import java.util.stream.*;

public class maxSumInSubarray
{
	public static void findMaxSum(int arr[], int k)
	{
		int n = arr.length;
		if(k>n)
		{
			System.out.println("INVALID");
			return;
		}	


		int max_sum = Integer.MIN_VALUE, cur_sum = 0;

		for(int i = 0;i<k;i++)
			cur_sum+=arr[i];
		max_sum = cur_sum;
		for(int i = k;i<n;i++)
		{
			cur_sum += arr[i] - arr[i-k];
			if(cur_sum>max_sum)
				max_sum = cur_sum;
		}

		System.out.println(max_sum);

	}

	public static void main(String args[])throws Exception
	{
		int arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20};
		int k = 4;

		findMaxSum(arr, k);
	}
}