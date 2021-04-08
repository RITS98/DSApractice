/*


Given an array and a positive integer k, find the first negative integer for each window(contiguous subarray) of size k. If a window does not contain a negative integer, then print 0 for that window.

Examples:  

Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
Output : -8 0 -6 -6
First negative integer for each window of size k
{-8, 2} = -8
{2, 3} = 0 (does not contain a negative integer)
{3, -6} = -6
{-6, 10} = -6

Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
Output : -1 -1 -7 -15 -15 0


*/


import java.io.*;
import java.util.*;
import java.util.stream.*;

public class firstNegativeEachWindow
{
	public static void printNegative(int arr[], int k)
	{
		int n = arr.length;
		int i = 0, j = 0;


		LinkedList<Integer> li = new LinkedList<Integer>();
		while(j<n)
		{
			int winSize = j-i+1;
			//System.out.println(li+" " + j+" "+i);
			if(arr[j]<0)
				li.add(j);
			if(winSize < k)
				j++;
			else if(winSize == k)
			{

				if(li.isEmpty())
					System.out.print(0+" ");
				else
				{
					System.out.print(arr[li.peek()]+" ");
				}
				

				i++;
				j++;
				//System.out.println(i+"  " + j);
				if(!li.isEmpty())
				{
					Integer x = li.peek();
					if(x<i)
						li.remove(li.peek());
				}
			}		

		}

		System.out.println();
	}

	public static void main(String args[])throws IOException
	{
		int arr[] = {-8, 2, 3, -6, 10};
		int k = 2;
		printNegative(arr, k);   //Ans: -8 0 -6 -6
		int arr1[] = {12, -1, -7, 8, -15, 30, 16, 28} ;
		k = 3;
		printNegative(arr1, k);		//Ans: -1 -1 -7 -15 -15 0
	}
}