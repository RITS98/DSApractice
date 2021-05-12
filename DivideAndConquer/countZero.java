import java.io.*;
import java.util.*;
import java.util.stream.*;

public class countZero
{
	public static int findIndex(int arr[], int low, int high, int n)
	{
		if(arr[0] == 0)
			return 0;
		if(arr[n-1] == 1)
			return -1;

		while(low<=high)
		{
			int mid = (low+high)/2;

			if(arr[mid] == 0 && arr[mid-1]==1)
				return mid;
			else if(arr[mid]==1)
				low = mid+1;
			else
				high = mid-1;
		}

		return -1;
	}

	public static void main(String args[])
	{
		int arr[] = {1,0,0};
		int index = findIndex(arr, 0, arr.length - 1, arr.length);
		if(index == -1)
			System.out.println("No zeros present");
		else
			System.out.println(arr.length - index +" no. of zeros present");
	}
}