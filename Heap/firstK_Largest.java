import java.io.*;
import java.util.*;
import java.util.stream.*;


public class firstK_Largest
{
	public static void findLargest(int arr[], int k)
	{
		int size = arr.length;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0;i<k;i++)
		{
			pq.add(arr[i]);
		}

		for(int i = k;i<size;i++)
		{
			int ele = pq.peek();
			if(ele < arr[i])
			{
				pq.poll();
				pq.add(arr[i]);
			}
		}

		Iterator it = pq.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next()+" ");
		}

		System.out.println();
	}

	public static void main(String args[])
	{
		int arr[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
     
	    int size = arr.length;
	     
	    // Size of Min Heap
	    int k = 3;
	     
	    findLargest(arr, k);
	}

}