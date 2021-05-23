import java.io.*;
import java.util.*;

public class heapSortDescending
{
	public static void buildHeap(int arr[], int n)
	{
		for(int i = n/2-1;i>=0;i--)
			heapify(arr, n, i);
	}

	public static void heapify(int arr[], int n, int i)
	{
		int root = i;
		int left = 2*i+1;
		int right = 2*i+2;

		if(left<n && arr[left]<arr[root])
			root = left;
		if(right<n && arr[right]<arr[root])
			root = right;

		if(root != i)
		{
			int swap = arr[root];
			arr[root] = arr[i];
			arr[i] = swap;

			heapify(arr, n, root);
		}
	}

	public static void heapSort(int arr[], int n)
	{
		buildHeap(arr, n);

		for(int i = n-1;i>0;i--)
		{
			int swap = arr[0];
			arr[0] = arr[i];
			arr[i] = swap;

			heapify(arr, i, 0);
		}
	}

	public static void main(String args[])
	{
		int arr[] = {6,4,9,10,3,5,1,2,8};
		System.out.println(Arrays.toString(arr));

		heapSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
}