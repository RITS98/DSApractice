/*

Given an array of n numbers and a positive integer k. The problem is to find k numbers with most occurrences, i.e., the top k numbers having the maximum frequency. If two numbers have the same frequency then the larger number should be given preference. The numbers should be displayed in decreasing order of their frequencies. It is assumed that the array consists of k numbers with most occurrences.

Examples: 

Input: 
arr[] = {3, 1, 4, 4, 5, 2, 6, 1}, 
k = 2
Output: 4 1
Explanation:
Frequency of 4 = 2
Frequency of 1 = 2
These two have the maximum frequency and
4 is larger than 1.

Input : 
arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9},
k = 4
Output: 5 11 7 10
Explanation: 
Frequency of 5 = 3
Frequency of 11 = 2
Frequency of 7 = 2
Frequency of 10 = 1
These four have the maximum frequency and
5 is largest among rest.


//https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/

//https://www.geeksforgeeks.org/find-k-most-frequent-in-linear-time/

*/

import java.io.*;
import java.util.*;

public class kFrequent
{
	public static void show(int arr[], int n, int k)
	{
		LinkedHashMap<Integer, Integer> hs = new LinkedHashMap<>();

		for(int i = 0;i<n;i++)
		{
			hs.put(arr[i], hs.getOrDefault(arr[i], 0)+1);
		}
		System.out.println(hs);
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((m1,m2) -> m2.getValue() - m1.getValue());
		for(Map.Entry<Integer, Integer> i : hs.entrySet())
		{
			pq.add(i);
		}

		for(int i = 0;i<k;i++)
		{
			System.out.println(pq.poll().getKey());
		}
	}

	public static void main(String[] args)
    {
        int arr[] = {7, 7, 6, 6, 6, 7, 5, 4, 4, 10, 5};
        int n = arr.length;
        int k = 2;
       
        // Function call
        show(arr, n, k);
    }


}