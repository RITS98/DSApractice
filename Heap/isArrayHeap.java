/*
Given an array, how to check if the given array represents a Binary Max-Heap.
Examples: 

Input:  arr[] = {90, 15, 10, 7, 12, 2} 
Output: True
The given array represents below tree
       90
     /    \
   15      10
  /  \     /
 7    12  2 
The tree follows max-heap property as every
node is greater than all of its descendants.

Input:  arr[] = {9, 15, 10, 7, 12, 11} 
Output: False
The given array represents below tree
       9
     /    \
   15      10
  /  \     /
 7    12  11
The tree doesn't follows max-heap property 9 is 
smaller than 15 and 10, and 10 is smaller than 11. 


A Simple Solution is to first check root if it’s greater than all of its descendants. Then check for children of the root. Time complexity of this solution is O(n2)
An Efficient Solution is to compare root only with its children (not all descendants), if root is greater than its children and the same is true for all nodes, then tree is max-heap (This conclusion is based on transitive property of > operator, i.e., if x > y and y > z, then x > z).
The last internal node is present at index (n-2)/2 assuming that indexing begins with 0.
Below is the implementation of this solution. 
*/

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class isArrayHeap
{
	public static boolean isHeap(int arr[], int n)
	{
		for (int i = 0; i <= (n - 2) / 2; i++) {
            // If left child is greater, return false
            if (arr[2 * i + 1] > arr[i]) {
                return false;
            }
 
            // If right child is greater, return false
            if (2 * i + 2 < n && arr[2 * i + 2] > arr[i]) {
                return false;
            }
        }
        return true;
	}

	public static void main(String args[])
	{
		int arr[] = { 90, 15, 10, 7, 12, 2, 7, 3 };
        int n = arr.length - 1;
        if (isHeap(arr,  n+1)) 
        {
            System.out.println("Yes");
        }
        else 
        {
            System.out.println("No");
        }

        int arr1[] = {90, 15, 10, 7, 12, 2, 7, 10};
        if (isHeap(arr1, arr1.length )) 
        {
            System.out.println("Yes");
        }
        else 
        {
            System.out.println("No");
        }

	}
}