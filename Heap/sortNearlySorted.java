/*
We can sort such arrays more efficiently with the help of Heap data structure. Following is the detailed process that uses Heap. 
1) Create a Min Heap of size k+1 with first k+1 elements. This will take O(k) time (See this GFact) 
2) One by one remove min element from heap, put it in result array, and add a new element to heap from remaining elements.
Removing an element and adding a new element to min heap will take log k time. So overall complexity will be O(k) + O((n-k) * log(k)).

//The Min Heap based method takes O(n log k) time and uses O(k) auxiliary space. 

//https://www.geeksforgeeks.org/nearly-sorted-algorithm/

*/

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class sortNearlySorted
{
	public static void sort(int arr[], int n, int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for(int i =0;i<k+1;i++)
		{
			pq.add(arr[i]);
		}

		int index = 0;
		for(int i = k+1;i<n;i++)
		{
			arr[index++] = pq.poll();
			pq.add(arr[i]);
 		}

 		Iterator<Integer> it = pq.iterator();
 		while(it.hasNext())
 		{
 			arr[index++] = pq.poll();
 		} 

	}

	private static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int n = arr.length;
        sort(arr, n, k);
        System.out.println("Following is sorted array");
        printArray(arr, n);
        System.out.println();
    }
}