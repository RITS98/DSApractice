/*

Given an array of n distinct elements and a number x, arrange array elements according to the absolute difference with x, i. e., an element having minimum difference comes first, and so on. 
Note: If two or more elements are at equal distance arrange them in the same sequence as in the given array.

*/

import java.io.*;
import java.util.*;

public class sortAbsDiff
{
	public static void sort(int arr[], int n, int k)
	{
		TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
		for(int i = 0;i<n;i++)
		{
			int diff = Math.abs(k - arr[i]);
			if(m.containsKey(diff))
			{
				ArrayList<Integer> al = m.get(diff);
				al.add(arr[i]);
				m.put(diff, al);
			}
			else
			{
				ArrayList<Integer> al = new ArrayList<>();
				al.add(arr[i]);
				m.put(diff, al);
			}
		}

		int index = 0;
		for(Map.Entry entry: m.entrySet())
		{
			ArrayList<Integer> al = m.get(entry.getKey());
			for(int i = 0;i<al.size();i++)
				arr[index++] = al.get(i);
		}
		
	}

	static void printArray(int[] arr, int n)
    {
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");

            System.out.println();
    }
 
    // Driver code
    public static void main(String args[])
    {
            int[] arr = {10, 5, 3, 9 ,2};
            int n = arr.length;
            int x = 7;
            sort(arr, n, x);
            printArray(arr, n);
    }
}