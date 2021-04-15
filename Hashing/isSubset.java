// Is the given array a subset of the other array

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class isSubset
{
	public static boolean isArraySubset(int arr1[], int arr2[])
	{
		HashMap<Integer, Integer> hm = new HashMap<>();

		for(int i : arr1)
		{
			hm.put(i, hm.getOrDefault(i, 0)+1);
		}

		for(int i: arr2)
		{
			if(hm.getOrDefault(i, 0)>0)
				hm.put(i, hm.get(i)-1);
			else
				return false;
		}

		return true;
	}

	public static void main(String args[])
	{
		int[] arr1 = { 11, 1, 13, 21, 3, 7 };
	    int[] arr2 = { 11, 3, 7, 1};
	     
	    int m = arr1.length;
	    int n = arr2.length;
	 
	    if (isArraySubset(arr1, arr2))
	        System.out.println("arr2[] is subset of arr1[] ");
	    else
	        System.out.println("arr2[] is not a subset of arr1[] ");
	}
}