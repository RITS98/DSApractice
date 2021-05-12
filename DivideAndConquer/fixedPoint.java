/*

Given an array of n distinct integers sorted in ascending order, write a function that returns a Fixed Point in the array, if there is any Fixed Point present in array, else returns -1. Fixed Point in an array is an index i such that arr[i] is equal to i. Note that integers in array can be negative. 
Examples: 
 

  Input: arr[] = {-10, -5, 0, 3, 7}
  Output: 3  // arr[3] == 3 

  Input: arr[] = {0, 2, 5, 8, 17}
  Output: 0  // arr[0] == 0 


  Input: arr[] = {-10, -5, 3, 4, 7, 9}
  Output: -1  // No Fixed Point

*/

import java.io.*;
import java.util.*;

public class fixedPoint
{
	static ArrayList<Integer> al = new ArrayList<>();
	//for sorted increasing array 
	public static int findPosition(int arr[], int low, int high)
	{
		if(low<=high)
		{
			int mid = (low+high)/2;
			if(arr[mid]==mid)
				return mid;
			else if(arr[mid]<mid)
				return findPosition(arr, mid+1, high);
			else
				return findPosition(arr, low, mid-1);
		}

	return -1;
	}
	//for unsorted array
	public static void findPos(int arr[], int low, int high)
	{
		if(low<=high)
		{
			int mid = (low+high)/2;
			if(arr[mid] == mid)
			al.add(mid);

			findPos(arr, low, mid-1);
			findPos(arr, mid+1, high);
		}
	}
	public static void main(String args[])
	{
		int arr[] = {-10, -1, 0, 3 , 10, 11, 30, 50, 100};
		int n = arr.length;
		System.out.println("Fixed Point is "+ findPosition(arr,0, n-1));    

		int ar[] = {0,1,3,5,7,2,6,8,10,9};
		findPos(ar, 0, ar.length-1);
		Collections.sort(al);
		Iterator it = al.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next()+" ");
		} 
		System.out.println();  
	}
}