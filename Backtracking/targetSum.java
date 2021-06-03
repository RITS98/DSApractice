//the problem where we are required to find all the subsets from an array which sum up to a given target

import java.io.*;
import java.util.*;

public class targetSum
{
	public static void printSets(int arr[], int idx, String ans, int sum, int target)
	{
		if(idx == arr.length)
		{
			if(sum == target)
			{
				System.out.println(ans.substring(0, ans.length()-2));
			}
			return;
		}

		printSets(arr, idx + 1, ans + arr[idx]+", ", sum + arr[idx], target);
		printSets(arr, idx + 1, ans, sum, target);
	}

	public static void main(String args[])
	{
		int arr[] = new int[]{10,20,30,40,50};
		int target = 70;

		printSets(arr, 0, "", 0, target);
	}
}