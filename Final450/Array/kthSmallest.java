/* Quick Select ALGORITHM
https://www.youtube.com/watch?v=BP7GCALO2v8&t=0s
*/

import java.util.stream.*;
import java.io.*;
import java.util.*;
public class kthSmallest
{
	// partition function similar to quick sort
    // Considers last element as pivot and adds
    // elements with less value to the left and
    // high value to the right and also changes
    // the pivot position to its respective position
    // in the final array.
	public static int partition(int arr[], int low, int high)
	{
		int pivot = arr[high], pivotloc = low;
		for(int i = low;i<=high;i++)
		{
			// inserting elements of less value
            // to the left of the pivot location
			if(arr[i]<pivot)
			{
				int temp = arr[i];
				arr[i] = arr[pivotloc];
				arr[pivotloc] = temp;
				pivotloc++;
			}
		}

		// swapping pivot to the final pivot location

		int temp = arr[high];
		arr[high] = arr[pivotloc];
		arr[pivotloc] = temp;


		return pivotloc;
	}

	// finds the kth position (of the sorted array)
    // in a given unsorted array i.e this function
    // can be used to find both kth largest and
    // kth smallest element in the array.
    // ASSUMPTION: all elements in arr[] are distinct
	public static int findKthSmallest(int arr[], int low, int high, int k)
	{
		int partition = partition(arr, low, high);

		// if partition value is equal to the kth position,
        // return value at k.
		if(partition == k-1)
			return arr[partition];
		// if partition value is less than kth position,
        // search right side of the array.
		else if(partition < k-1)
			return findKthSmallest(arr, partition+1, high, k);
		// if partition value is more than kth position,
        // search left side of the array.
		else
			return findKthSmallest(arr, low, partition-1, k);
	}

	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		System.out.println("Enter the array - ");
		int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		System.out.println("Enter the Kth value - ");
		int k = Integer.parseInt(br.readLine());

		bw.write(""+findKthSmallest(arr, 0, arr.length - 1, k));
		bw.flush();

		System.out.println("\n"+findKthSmallest(arr, 0, arr.length-1, k));

	}
}