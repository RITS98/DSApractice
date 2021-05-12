import java.io.*;
import java.util.*;
import java.util.stream.*;

public class peakEle
{
	public static int findUntil(int arr[], int low, int high, int n)
	{
		if(low<=high)
		{
			int mid = (low+high)/2;

			if((mid == 0 || arr[mid-1]<=arr[mid]) && (mid == n-1 || arr[mid+1]<=arr[mid]))
				return mid;
			else if(mid>0 && arr[mid+1]>arr[mid])
				return findUntil(arr, mid+1, high, n);
			else
				return findUntil(arr, low, mid-1, n);

		}

		return -1;
	}

	public static void main(String args[])
	{
		int arr[] = { 1, 3, 20, 4, 1, 0 };
        int n = arr.length;
        System.out.println("Index of a peak point is " + findUntil(arr,0, n-1, n));
	}
}