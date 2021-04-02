
/*
Input : arr[] = {12, 10, 5, 6, 52, 36}
            k = 2
Output : arr[] = {5, 6, 52, 36, 12, 10}
Explanation : Split from index 2 and first 
part {12, 10} add to the end .

Input : arr[] = {3, 1, 2}
           k = 1
Output : arr[] = {1, 2, 3}
Explanation : Split from index 1 and first
part add to the end.


Time Complexity - O(n)

*/


import java.util.*;
import java.io.*;
import java.util.stream.*;

public class splitAndAdd
{

	public static void reverseArray(int arr[], int start, int end)
	{
		while(start<end)
		{
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start ++;
			end --;
		}
	}

	public static void split(int arr[], int d)
	{
		int size = arr.length;
		d = d%size;

		reverseArray(arr, 0, d-1);
		reverseArray(arr, 0, size - 1);
		reverseArray(arr, 0, size - d - 1);

	}

	public static void main(String args[])throws IOException
	{

		int arr[] = new int[]{1,2,3,4,5,6,7,8,9};
		int d = 3;

		split(arr, d);

		Arrays.stream(arr).forEach(i -> System.out.print(i+" "));
		System.out.println();

	}
}