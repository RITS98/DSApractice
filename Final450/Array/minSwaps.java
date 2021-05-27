// Method 1 - O(nlogn)
// Java program to find
// minimum number of swaps
// required to sort an array
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.*;

class GfG
{
	public static int minSwaps(int[] arr)
	{
		int n = arr.length;

		// Create two arrays and
		// use as pairs where first
		// array is element and second array
		// is position of first element
		ArrayList <Pair <Integer, Integer> > arrpos =
				new ArrayList <Pair <Integer,
									Integer> > ();
		for (int i = 0; i < n; i++)
			arrpos.add(new Pair <Integer,
							Integer> (arr[i], i));

		// Sort the array by array element values to
		// get right position of every element as the
		// elements of second array.
		arrpos.sort(new Comparator<Pair<Integer,
										Integer>>()
		{
			@Override
			public int compare(Pair<Integer, Integer> o1,
							Pair<Integer, Integer> o2)
			{
				if (o1.getKey() > o2.getKey())
					return -1;

				// We can change this to make
				// it then look at the
				// words alphabetical order
				else if (o1.getKey().equals(o2.getKey()))
					return 0;

				else
					return 1;
			}
		});

		// To keep track of visited elements. Initialize
		// all elements as not visited or false.
		Boolean[] vis = new Boolean[n];
		Arrays.fill(vis, false);

		// Initialize result
		int ans = 0;

		// Traverse array elements
		for (int i = 0; i < n; i++)
		{
			// already swapped and corrected or
			// already present at correct pos
			if (vis[i] || arrpos.get(i).getValue() == i)
				continue;

			// find out the number of node in
			// this cycle and add in ans
			int cycle_size = 0;
			int j = i;
			while (!vis[j])
			{
				vis[j] = true;

				// move to next node
				j = arrpos.get(j).getValue();
				cycle_size++;
			}

			// Update answer by adding current cycle.
			if(cycle_size > 0)
			{
				ans += (cycle_size - 1);
			}
		}

		
		return ans;
	}
}

class MinSwaps
{
	public static void main(String[] args)
	{
		int []a = {1, 5, 4, 3, 2};
		GfG g = new GfG();
		System.out.println(g.minSwaps(a));
	}
}



//Using HashMap - O(nlogn)
// Java program to find
// minimum number of swaps
// required to sort an array
import java.util.*;
import java.io.*;

class GfG
{

	// Return the minimum number
	// of swaps required to sort the array
	public int minSwaps(int[] arr, int N)
	{

		int ans = 0;
		int[] temp = Arrays.copyOfRange(arr, 0, N);

		// Hashmap which stores the
		// indexes of the input array
		HashMap<Integer, Integer> h
			= new HashMap<Integer, Integer>();

		Arrays.sort(temp);
		for (int i = 0; i < N; i++)
		{
			h.put(arr[i], i);
		}
		for (int i = 0; i < N; i++)
		{

			// This is checking whether
			// the current element is
			// at the right place or not
			if (arr[i] != temp[i])
			{
				ans++;
				int init = arr[i];

				// If not, swap this element
				// with the index of the
				// element which should come here
				swap(arr, i, h.get(temp[i]));

				// Update the indexes in
				// the hashmap accordingly
				h.put(init, h.get(temp[i]));
				h.put(temp[i], i);
			}
		}
		return ans;
	}
	public void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

class Main
{
	public static void main(String[] args)
						throws Exception
	{
		int[] a = { 101, 758, 315, 730, 472,
						619, 460, 479 };
		int n = a.length;
		System.out.println(new GfG().minSwaps(a, n));
	}
}

