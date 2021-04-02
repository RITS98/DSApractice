/*
Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed
This method works for both sorted and unsorted array

Examples :  

Input: arr[] = {1, 20, 2, 10}
Output: 72
We can get 72 by rotating array twice.
{2, 10, 1, 20}
20*3 + 1*2 + 10*1 + 2*0 = 72

Input: arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9}
Output: 330
We can get 330 by rotating array 9 times.
{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
0*1 + 1*2 + 2*3 ... 9*10 = 330



## Theory

Let us calculate initial value of i*arr[i] with no rotation
R0 = 0*arr[0] + 1*arr[1] +...+ (n-1)*arr[n-1]

After 1 rotation arr[n-1], becomes first element of array, 
arr[0] becomes second element, arr[1] becomes third element
and so on.
R1 = 0*arr[n-1] + 1*arr[0] +...+ (n-1)*arr[n-2]

R1 - R0 = arr[0] + arr[1] + ... + arr[n-2] - (n-1)*arr[n-1]

After 2 rotations arr[n-2], becomes first element of array, 
arr[n-1] becomes second element, arr[0] becomes third element
and so on.
R2 = 0*arr[n-2] + 1*arr[n-1] +...+ (n-1)*arr[n-3]

R2 - R1 = arr[0] + arr[1] + ... + arr[n-3] - (n-1)*arr[n-2] + arr[n-1]

If we take a closer look at above values, we can observe 
below pattern

Rj - Rj-1 = arrSum - n * arr[n-j]

Where arrSum is sum of all array elements, i.e., 

arrSum = ∑ arr[i]
        0<=i<=n-1 



*/


import java.io.*;
import java.util.*;
import java.util.stream.*;


public class findMaxSum
{

	public static int maxSum(int arr[], int size)
	{
		int curSum  = 0;
		int maxSum = Integer.MIN_VALUE;
		int arrSum = 0
		for(int i = 0; i<size;i++)
		{
			arrSum = arrSum + arr[i];
			curSum = curSum + i*arr[i];
		}	

		if(curSum>maxSum)
			maxSum = curSum;
		for(int j = 1;j<size;j++)
		{
			curSum = curSum +arrSum - size * arr[size - j];

			if(curSum>maxSum)
				maxSum = curSum;

		}

		return maxSum;
	}

	public static void main(String args[])throws IOException
	{

	}
}
