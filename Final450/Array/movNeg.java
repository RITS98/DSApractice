import java.io.*;
import java.util.*;

public class movNeg
{
	public static void moveNegative(int arr[], int n)
	{
		int x[] = new int[n];
		int j = 0;
		for(int i = 0;i<n;i++)
		{
			if(arr[i]<0)
				x[j++] =arr[i]; 
		}
		for(int i = 0;i<n;i++)
		{
			if(arr[i]>=0)
				x[j++] = arr[i];
		}

		System.out.println(Arrays.toString(x));
	}

	//Order is not important
	public static void usingQuickPartition(int arr[], int n)
	{
		int j = 0;
		for(int i = 0;i<n;i++)
		{
			if(arr[i]<0)
			{
				if(i!=j)
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	//Order is not important
	public static void usingTwoPartition(int arr[], int n)
	{
		int left = 0, right = n-1;
		while(left<=right)
		{
			if(arr[left]<0 && arr[right]<0)
				left++;

			else if(arr[left]>0 && arr[right]<0)
			{
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
			else if(arr[left]>0 && arr[right]>0)
				right --;
			else
			{
				left++;
				right--;
			}
		}

		System.out.println(Arrays.toString(arr));
	}
	public static void main(String args[])
	{
		int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
        int n = arr.length;
 		
 		moveNegative(arr, n);
 		usingQuickPartition(arr, n);
 		usingTwoPartition(arr, n);
	}
}