/*

This can be done in O(n) time by doing a single traversal of given array. The idea is based on the fact that if we make sure that all even positioned (at index 0, 2, 4, ..) elements are greater than their adjacent odd elements, we don’t need to worry about odd positioned element. Following are simple steps.
1) Traverse all even positioned elements of input array, and do following.
….a) If current element is smaller than previous odd element, swap previous and current.
….b) If current element is smaller than next odd element, swap next and current.

*/

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class sortLikeWave
{
	public static void sort(int arr[], int n)
	{
		for(int i = 1;i<n-1;i+=2)
		{
			if(arr[i]>arr[i-1])
				swap(arr, i, i-1);
			if(arr[i]>arr[i+1])
				swap(arr, i, i+1);
		}

		if(n%2 == 0)
		{
			if(arr[n-1]>arr[n-2])
				swap(arr, n-1, n-2);
		}

		System.out.println(Arrays.toString(arr));
	}

	public static void swap(int arr[], int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String args[])
    {
        int arr[] = {10, 90, 49, 2, 1, 5, 23};
        int n = arr.length;
        sort(arr, n);
    }
}