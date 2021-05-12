import java.util.*;
import java.io.*;

public class maxSubArraySum
{
	public static int sum(int arr[], int n)
	{
		int maxi = arr[0];
		int curr = arr[0];

		for(int i = 1;i<n;i++)
		{
			curr = curr+arr[i]>arr[i]?curr+arr[i]:arr[i];
			maxi = Math.max(curr, maxi);
		}

		return maxi;
	}
	public static void main(String args[])
	{
		int arr[] = {-1,2,3,-2,-5};
		System.out.println(sum(arr, arr.length));

		int arr2[] = {-4,-3,-2,-1};
		System.out.println(sum(arr2, arr2.length));
	}
}