/*

Given an array of numbers, arrange them in a way that yields the largest value. 
For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 
gives the largest value. And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, 
then the arrangement 998764543431 gives the largest value.


*/

import java.io.*;
import java.util.*;
import java.util.stream.*;


public class arrangeToBiggestNumber
{
	public static void arrange(String arr[],int n)
	{
		Arrays.sort(arr, new Comparator<String>()
		{
			public int compare(String X, String Y)
			{
				String XY = X+Y;
				String YX = Y+X;

				return XY.compareTo(YX)>0?-1:1;
			}
		});

		System.out.println(Arrays.toString(arr));
	}

	public static void main(String args[])
	{
		String arr[] = {"54", "546", "548", "60"};
		arrange(arr, arr.length);
		arr = new String[]{"1", "34", "3", "98", "9", "76", "45", "4"};
		arrange(arr, arr.length);
	}
}