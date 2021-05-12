import java.io.*;
import java.util.*;
import java.util.stream.*;

public class majorityEle
{
	public static int binarySearch(int arr[], int low, int high, int x)
	{
		if(low<=high)
		{
			int mid = (low+high)/2;

			if((mid == 0 || x > arr[mid - 1])&& (arr[mid] == x))
				return mid;
			else if(x>arr[mid])
				return binarySearch(arr, mid+1, high, x);
			else
				return binarySearch(arr, low, mid-1, x);
		}

		return -1;
	}

	public static boolean isMajority(int arr[], int n, int x)
	{
		int i = binarySearch(arr, 0, n-1, x);
		if(i == -1)
			return false;

		if((i+n/2)<=n-1 && arr[i+n/2] == x)
			return true;
		else
			return false;
	}
	public static void main (String[] args)  {
 
        int arr[] = {1, 2, 3, 3, 3, 3, 10};
        int n = arr.length;
        int x = 3;
        if (isMajority(arr, n, x)==true)
            System.out.println(x + " appears more than "+ n/2 + " times in arr[]");
        else
            System.out.println(x + " does not appear more than " + n/2 + " times in arr[]");
    }
}