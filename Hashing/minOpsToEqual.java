/*

Given an array with n positive integers. We need to find the minimum number of operation to make all elements equal. We can perform addition, multiplication, subtraction or division with any element on an array element.

Examples:

Input : arr[] = {1, 2, 3, 4}
Output : 3
Since all elements are different, 
we need to perform at least three
operations to make them same. For
example, we can make them all 1
by doing three subtractions. Or make
them all 3 by doing three additions.

Input : arr[] = {1, 1, 1, 1}
Output : 0

*/

/*

For making all elements equal you can select a target value and then you can make all 
elements equal to that. Now, for converting a single element to target value you can 
perform a single operation only once. In this manner you can achieve your task in maximum 
of n operations but you have to minimize this number of operation and for this your selection 
of target is very important because if you select a target whose frequency in array is x then 
you have to perform only n-x more operations as you have already x elements equal to your 
target value. So finally, our task is reduced to finding the element with maximum frequency.
This can be achieved by different means such as iterative method in O(n^2), 
sorting in O(nlogn) and hashing in O(n) time complexity.

*/

import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;
public class minOpsToEqual
{
	public static int minOps(int arr[])
	{
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>()
		for(int i : arr)
		{
			hm.put(i , hm.getOrDefault(i, 0)+1);
		}

		int max = Integer.MIN_VALUE;
		for(Entry<Integer, Integer> e: hm.entrySet())
		{
			if(max< e.getValue())
				max = e.getValue();
		}

		return arr.length - max;
	}

	public static void main(String[] args) 
    {
        int arr[] = {1, 5, 2, 1, 3, 2, 1};
        int n = arr.length;
        System.out.println(minOps(arr));
              
    }

}