/*
//https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/


Let AB are the two parts of the input array where A = arr[0..d-1] and B = arr[d..n-1]. The idea of the algorithm is : 
 

Reverse A to get ArB, where Ar is reverse of A.
Reverse B to get ArBr, where Br is reverse of B.
Reverse all to get (ArBr) r = BA.
Example : 
Let the array be arr[] = [1, 2, 3, 4, 5, 6, 7], d =2 and n = 7 
A = [1, 2] and B = [3, 4, 5, 6, 7] 
 

Reverse A, we get ArB = [2, 1, 3, 4, 5, 6, 7]
Reverse B, we get ArBr = [2, 1, 7, 6, 5, 4, 3]
Reverse all, we get (ArBr)r = [3, 4, 5, 6, 7, 1, 2]

*/

import java.io.*;
import java.util.*;
import java.util.stream.*;


public class arrayRotationReversalAlgorithm
{
	public static void reverseArray(int arr[], int start, int end)
	{
		while(start<end)
		{
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			start ++;
			end--;
		}
	}

	public static void rotateArray(int arr[], int d)
	{
	 	int size = arr.length;
	 	d = d%size;  //id d>=size

	 	reverseArray(arr, 0, d-1);
	 	reverseArray(arr, d, size -1);
	 	reverseArray(arr, 0, size - 1);
	}

	public static void main(String args[])throws IOException
	{
		int arr[] = {1, 2,3,4,5,6,7,8,9,10,11,12,13,14};
		int d = 3;

		rotateArray(arr, d);
		Arrays.stream(arr).forEach(i-> System.out.print(i+" "));
		System.out.println();
	}
}