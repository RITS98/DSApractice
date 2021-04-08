/*

Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.

Examples : 

Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3 
Output: 3 3 4 5 5 5 6
Explanation: 
Maximum of 1, 2, 3 is 3
Maximum of 2, 3, 1 is 3
Maximum of 3, 1, 4 is 4
Maximum of 1, 4, 5 is 5
Maximum of 4, 5, 2 is 5 
Maximum of 5, 2, 3 is 5
Maximum of 2, 3, 6 is 6

Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4 
Output: 10 10 10 15 15 90 90
Explanation:
Maximum of first 4 elements is 10, similarly for next 4 
elements (i.e from index 1 to 4) is 10, So the sequence 
generated is 10 10 10 15 15 90 90

*/

//https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/


import java.io.*;
import java.util.*;
import java.util.stream.*;


public class maxOfAllSubarrays
{
	public static void findMax(int arr[], int k)
	{
		for(int start = 0, end = k-1;end<arr.length;start++, end++)
		{
			int window[]= Arrays.copyOfRange(arr, start, end+1);

			int max = Arrays.stream(window).max().getAsInt();
			System.out.print(max+" ");
		}

		System.out.println();
	}


	//Wrongly done
	public static void maxFind(int arr[], int k)
	{
		Queue<Integer> q = new LinkedList<>();

		int start = 0, end = 0, n = arr.length;

		while(end<n)
		{
			int winlen = end - start +1;

			if(winlen<k)
			{
				if(q.isEmpty())
					q.add(end);
				else
				{
					if(arr[q.peek()]<arr[end])
					{
						q.poll();
					}

					q.add(end);
				}
				end++;
			}
			else
			{
				q.add(end);

				while(!q.isEmpty() && arr[q.peek()]<arr[end])       //<------
					q.poll();

				int max = q.peek();
				System.out.print(arr[max]+" ");

				start++;
				end++;

				if(max<start)
				{
					q.poll();
				}

			}
		}

		System.out.println();
	}

	public static void main(String args[])
	{
		int arr[] = {8, 10, 5, 7, 9, 4, 15, 12, 90, 13};
        int k = 3;
        findMax(arr, 4);

        int ar[] = new int[]{1,3,-1,-3,5,3,6,7};
        k = 3;
        maxFind(ar, k);
	}
}