import java.io.*;
import java.util.*;

public class maxInSubarray
{
	public static void findMax(int arr[], int k)
	{
		int n = arr.length;
		ArrayList<Integer> ans = new ArrayList<>();
		//creating max heap
		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
		PriorityQueue<Integer> toDrop = new PriorityQueue<>((n1,n2) -> n2-n1);


		int i = 0;
		for(;i<k;i++)
		{
			pq.add(arr[i]);
		}

		ans.add(pq.peek());

		for(;i<n;i++)
		{
			if(arr[i-k] == pq.peek())
				pq.poll();
			else
			{
				toDrop.add(arr[i-k]);
			}

			while(!toDrop.isEmpty() && toDrop.peek() == pq.peek())
			{
				pq.poll();
				toDrop.poll();
			}

			pq.add(arr[i]);
			ans.add(pq.peek());
		}

		ans.stream().forEach(j -> System.out.print(j+" "));
		System.out.println();
	}
	public static void main(String args[])
	{
		int arr[] = {1, 2, 3, 4, 10, 6, 9, 8, 7, 5};
		int k = 3;

		findMax(arr, k);
	}
}