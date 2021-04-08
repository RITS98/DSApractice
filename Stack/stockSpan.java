/*

The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day. 


For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6} 



*/

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class stockSpan
{
	public static void span(int arr[])
	{
		int n = arr.length;

		Stack<Integer> st = new Stack<>();

		int S[] = new int[n];

		st.push(0);
		S[0] = 1;

		for(int i =1;i<n;i++)
		{
			while(!st.isEmpty() && arr[st.peek()]<=arr[i])
				st.pop();

			S[i] = st.isEmpty()? (i+1):i - st.peek();
			st.push(i);
		}

		System.out.println(Arrays.toString(S));
	}


	public static void main(String args[])
	{
		int arr[] = {100, 80, 60, 70, 60, 75, 85};

		span(arr);
	}
}