import java.io.*;
import java.util.*;
import java.util.Deque;

class sumMinMax
{
	public static void find(int arr[], int k)
	{
		int n = arr.length;
		Deque<Integer>  max = new ArrayDeque<>();
		Deque<Integer> min = new ArrayDeque<>();
		int i = 0;
		for(;i<k;i++)
		{
			while(!max.isEmpty() && arr[max.getLast()]<=arr[i])
				max.removeLast();

			while(!min.isEmpty() && arr[min.getLast()]>=arr[i])
				min.removeLast();

			max.addLast(i);
			min.addLast(i);
		}

		ArrayList<Integer> al = new ArrayList<>();
		for(;i<n;i++)
		{
			al.add(arr[max.getFirst().intValue()]+arr[min.getFirst().intValue()]);

			while(max.getFirst()<(i-k+1))
				max.removeFirst();

			while(min.getFirst()<(i-k+1))
				min.removeFirst();

			while(!max.isEmpty() && arr[max.getLast()]<=arr[i])
				max.removeLast();

			while(!min.isEmpty() && arr[min.getLast()]>=arr[i])
				min.removeLast();
			
			max.addLast(i);	
			min.addLast(i);		
		}
		al.add(arr[max.getFirst().intValue()]+arr[min.getFirst().intValue()]);

		Iterator it = al.iterator();
		while(it.hasNext())
			System.out.print(((Integer)it.next()).intValue()+" ");
		System.out.println();
	}

	public static void main(String args[])
	{
		int arr[] = {9,6,11,8,10,5,14,13,93,14};
		find(arr, 4);
	}
}