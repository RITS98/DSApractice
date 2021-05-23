/*

Given an array of integers. Write a program to find the K-th largest sum of contiguous subarray within the array of numbers which has negative and positive numbers.

Examples: 

Input: a[] = {20, -5, -1} 
         k = 3
Output: 14
Explanation: All sum of contiguous 
subarrays are (20, 15, 14, -5, -6, -1) 
so the 3rd largest sum is 14.

Input: a[] = {10, -10, 20, -40} 
         k = 6
Output: -10 
Explanation: The 6th largest sum among 
sum of all contiguous subarrays is -10.


An efficient approach is to store the pre-sum of the array in a sum[] array. We can find sum of contiguous subarray from index i to j as sum[j]-sum[i-1] 

Now for storing the Kth largest sum, use a min heap (priority queue) in which we push the contiguous sums till we get K elements, once we have our K elements, check if the element is greater than the Kth element it is inserted to the min heap with popping out the top element in the min-heap, else not inserted. In the end, the top element in the min-heap will be your answer.

*/

// Java program to find the k-th
// argest sum of subarray
import java.util.*;

class KlargestSum
{
	// function to calculate kth largest
	// element in contiguous subarray sum
	static int kthLargestSum(int arr[], int n, int k)
	{
		// array to store predix sums
		int sum[] = new int[n + 1];
		sum[0] = 0;
		sum[1] = arr[0];
		for (int i = 2; i <= n; i++)
			sum[i] = sum[i - 1] + arr[i - 1];
		
		System.out.println(Arrays.toString(sum));
		// priority_queue of min heap
		PriorityQueue<Integer> Q = new PriorityQueue<Integer> ();
		
		// loop to calculate the contiguous subarray
		// sum position-wise
		for (int i = 1; i <= n; i++)
		{
	
			// loop to traverse all positions that
			// form contiguous subarray
			for (int j = i; j <= n; j++)
			{
				// calculates the contiguous subarray
				// sum from j to i index
				int x = sum[j] - sum[i - 1];
				System.out.println(x);
				// if queue has less then k elements,
				// then simply push it
				/*if (Q.size() < k)
					Q.add(x);
	
				else
				{
					// it the min heap has equal to
					// k elements then just check
					// if the largest kth element is
					// smaller than x then insert
					// else its of no use
					if (Q.peek() < x)
					{
						Q.poll();
						Q.add(x);
					}
				}*/
				Q.add(x);

				System.out.println(Q);
			}
		}
		
		// the top element will be then kth
		// largest element
		return Q.poll();
	}
	
	// Driver Code
	public static void main(String[] args)
	{
		int a[] = new int[]{ 20,-5,-1 };
		int n = a.length;
		int k = 3;

		// calls the function to find out the
		// k-th largest sum
		System.out.println(kthLargestSum(a, n, k));

		int arr[] = {10, -10, 20, -40};
		System.out.println(kthLargestSum(arr, 4, 6));
	}
}


