//https://www.youtube.com/watch?v=Q_eia3jC9Ts

import java.io.*;
import java.util.*;
import java.util.stream.*;


public class heapSort
{
	public static void sort(int arr[], int n)
	{
		for(int i = n/2 - 1;i>=0;i--)
			heapify(arr, n, i);

		for(int i = n-1;i>=0;i--)
		{
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;


			heapify(arr, i, 0);
		}
	}

	public static void heapify(int arr[], int n, int i)
	{
		int largest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;

		if(l<n && arr[l]>arr[largest])
			largest = l;
		if(r<n && arr[r] > arr[largest])
			largest = r;


		if(largest != i)
		{
			int swap = arr[largest];
			arr[largest] = arr[i];
			arr[i] = swap;


			heapify(arr, n , largest);
		}
	}


	public static void main(String args[])throws Exception
	{
		int arr[] = new int[]{ 12, 11, 13, 5, 6, 7 };
		int n = arr.length;

		sort(arr, n);
		Arrays.stream(arr).forEach(i -> System.out.println(i+" "));
		System.out.println();

	}
}