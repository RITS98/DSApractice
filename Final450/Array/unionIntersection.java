//https://www.geeksforgeeks.org/find-union-and-intersection-of-two-unsorted-arrays/

import java.io.*;
import java.util.*;

public class unionIntersection
{
	public static void union(int arr1[], int arr2[])
	{
		int n = arr1.length;
		int m = arr2.length;

		TreeSet<Integer> hs = new TreeSet<>();
		for(int i = 0;i<n;i++)
		{
			hs.add(arr1[i]);
		}
		for(int i = 0;i<m;i++)
		{
			hs.add(arr2[i]);
		}

		System.out.println("union - ");
		Iterator it = hs.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next()+" ");
		}
	}
	public static void intersection(int arr1[], int arr2[])
	{
		int n = arr1.length;
		int m = arr2.length;
		HashSet<Integer> hs = new HashSet<>();
		TreeSet<Integer> hs1 = new TreeSet<>();

		for(int i = 0;i<n;i++)
			hs.add(arr1[i]);

		for(int i = 0;i<m;i++)
		{
			if(hs.contains(arr2[i]))
				hs1.add(arr2[i]);
		}

		Iterator it = hs1.iterator();
		System.out.println("\nintersection");
		while(it.hasNext())
		{
			System.out.print(it.next()+" ");
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		int arr1[] = { 7, 1, 5, 2, 3, 6 };
        int arr2[] = { 3, 8, 6, 20, 7 };
 		
 		union(arr1, arr2);
 		intersection(arr1, arr2);
	}
}