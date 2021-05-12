import java.io.*;
import java.util.*;
import java.util.stream.*;

public class findMinInSortedRotatedArray
{
	public static int pivotedBinarySearch(int arr[],int low, int high)
	{
		if(high < low)
			return arr[0];

		if(high == low)
			return arr[low];

		int mid = (high + low)/2;
		//System.out.println(mid);
		if(mid< high && arr[mid + 1]<arr[mid])
			return arr[mid + 1];

		if(mid > low && arr[mid]< arr[mid-1])
			return arr[mid];

		
		if(arr[high] > arr[mid])
			return pivotedBinarySearch(arr, low, mid - 1);
		return pivotedBinarySearch(arr, mid + 1 , high);
	}

	public static int findMin(int arr[], int low, int high) 
	{ 
	    while(low < high)
	    {
	        int mid = low + (high - low) / 2;
	        if (arr[mid] == arr[high])
	            high--;
	              
	        else if(arr[mid] > arr[high])
	            low = mid + 1;
	        else
	            high = mid;
	    }
	    return arr[high];
	} 
  

	public static void main(String args[])throws IOException
	{
		int arr[] = new int[]{ 5,6,7,8,9,10,11,1,2,3,4,};

		System.out.println(pivotedBinarySearch(arr, 0, arr.length - 1));
		System.out.println(findMin(arr, 0, arr.length - 1));
		
	}
}