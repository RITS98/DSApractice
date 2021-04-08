/*

n Array of integers is given, both +ve and -ve. You need to find the two elements such that their sum is closest to zero.

Algorithm 
1) Sort all the elements of the input array. 
2) Use two index variables l and r to traverse from left and right ends respectively. Initialize l as 0 and r as n-1. 
3) sum = a[l] + a[r] 
4) If sum is -ve, then l++ 
5) If sum is +ve, then r– 
6) Keep track of abs min sum. 
7) Repeat steps 3, 4, 5 and 6 while l < r

*/

import java.io.*;
import java.util.*;

public class sumCloseToZero
{
	public static void find(int arr[], int n)
	{
		Arrays.sort(arr);

		int l = 0, r = n-1;
		int min_l = l, min_r = r;
		int min_sum = Integer.MAX_VALUE;
		while(l<r)
		{
			int sum = arr[l]+arr[r];
			if(Math.abs(sum)<min_sum)
			{
				min_sum = sum;
				min_l = l; min_r = r;
			}	

			if(sum < 0)
				l++;
			else if(sum > 0)
				r--;
			else
			{
				break;
			}
		}

		System.out.println(arr[min_l] + " "+ arr[min_r]);
	}

	public static void main(String[] args)
	{
	    int[] arr = { 60, -10,5, -5,2 , -1, 70, -80, 85 };
	    int n = arr.length;
	     
	    find(arr, n);
	}
}