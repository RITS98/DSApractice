import java.io.*;
import java.util.*;
import java.util.stream.*;


public class findInSortedRotatedArray
{
	public static int findPivot(int arr[], int low, int high)
	{

		//largest element is the pivot
		if(high < low)
			return -1;
		if(high == low)
			return low;

		int mid = (high + low)/2;
		if(mid<high && arr[mid+1]<arr[mid])
			return mid;
		if(mid>low && arr[mid]<arr[mid - 1])
			return mid-1;


		if(arr[mid]>arr[high])
			return findPivot(arr, mid + 1, high);
		return findPivot(arr, low, mid - 1);

	}


	public static int binarySearch(int arr[], int low, int high, int key)
	{
		while(low<high)
		{
			int mid = (low+high)/2;

			if(arr[mid] ==key)
				return mid;
			else if(key>arr[mid])
				return binarySearch(arr, mid+1, high,key);
			else
				return binarySearch(arr, low, mid-1, key); 
		}

		return -1;
	}

	public static int pivotedbinarySearch(int arr[], int key)
	{
		int pivot = findPivot(arr, 0, arr.length - 1);
		if(pivot == -1)
			return binarySearch(arr, 0, arr.length - 1, key);

		else if(arr[pivot] == key)
			return pivot;
		else if(key> arr[pivot] && key<arr[arr.length - 1])
			return binarySearch(arr, pivot+1, arr.length - 1, key);
		else
			return binarySearch(arr, 0, pivot-1, key);
	}




	//Find in Rotated Array Compiled in GFG  Easier Method
	int search(int A[], int low, int high, int key)
    {
        while(low<=high)
        {
            int mid = (low+high)/2;
            
            if(A[mid] == key)
            return mid;
            else if(A[low]<A[mid])
            {
                if(key>=A[low] && key<A[mid])
                high = mid - 1;
                else
                low = mid + 1;
            }
            else
            {
                if(key > A[mid] && key<=A[high])
                low = mid + 1;
                else
                high = mid - 1;
            }
        }
        
        return -1;
        
    }




	public static int search(int arr[], int l, int h, int key)
    {
        if (l > h)
            return -1;
  
        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;
  
        /* If arr[l...mid] first subarray is sorted */
        if (arr[l] <= arr[mid]) {
            /* As this subarray is sorted, we 
               can quickly check if key lies in 
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);
            /*If key not lies in first half subarray, 
           Divide other half  into two subarrays,
           such that we can quickly check if key lies 
           in other half */
            return search(arr, mid + 1, h, key);
        }
  
        /* If arr[l..mid] first subarray is not sorted, 
           then arr[mid... h] must be sorted subarry*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid + 1, h, key);
  
        return search(arr, l, mid - 1, key);
    }



	public static void main(String args[])throws IOException
	{
		int arr[] = new int[]{5,6,7,8,9,10,12, 1,2,3,4};
		System.out.println(pivotedbinarySearch(arr, 5));
		System.out.println(pivotedbinarySearch(arr, 30));

		int i = search(arr, 0, arr.length - 1, 3);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");

	}
}