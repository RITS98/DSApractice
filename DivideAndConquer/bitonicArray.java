import java.io.*;
import java.util.*;

public class bitonicArray
{
	public static int findElement(int arr[], int low, int high)
	{
		if(low<=high)
		{
			int mid = high/2+low/2;

			if(arr[mid] > arr[mid+1] && arr[mid]>arr[mid-1])
				return arr[mid];
			else if(arr[mid]<arr[mid+1])
				return findElement(arr, mid+1, high);
			else 
				return findElement(arr, low, mid-1);
		}

		return Integer.MIN_VALUE;
	}
	public static void main(String args[])
	{
		int arr[] = {6, 7, 8, 11, 9, 5, 2, 1};
        int n = arr.length;
        int ele = findElement(arr, 1, n - 2);
        if (ele != Integer.MIN_VALUE)
        System.out.println ( ele);
	}
}