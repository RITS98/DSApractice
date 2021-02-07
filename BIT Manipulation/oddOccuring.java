/*Given an array of positive integers.
 All numbers occur even number of times except one number which occurs odd number of times. 
 Find the number in O(n) time & constant space.*/

import java.util.*;
class oddOccuring
{
	public static void main(String args[])
	{
		int arr[]=new int[]{2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2}; 


		int res=0;
		for(int i:arr)
		{
			res^=i;
		}

		System.out.println("Odd occuring element : "+res);
	}
}