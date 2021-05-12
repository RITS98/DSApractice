/*
Given a sorted array in which all elements appear twice (one after one) and one element appears only once. Find that element in O(log n) complexity.

Example: 

Input:   arr[] = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8}
Output:  4

Input:   arr[] = {1, 1, 3, 3, 4, 4, 5, 5, 7, 7, 8}
Output:  8

*/

import java.io.*;
import java.util.*;

public class onlyOnce
{
	public static void search(int[] arr, int low, int high)
    {
        if (low > high)
            return;
        if (low == high) {
            System.out.println("The required element is " + arr[low]);
            return;
        }
 
        // Find the middle point
        int mid = (low + high) / 2;
 
        // If mid is even and element next to mid is
        // same as mid, then output element lies on
        // right side, else on left side
        if (mid % 2 == 0) 
        {
            if (arr[mid] == arr[mid + 1])
                search(arr, mid + 2, high);
            else
                search(arr, low, mid);
        }
        // If mid is odd
        else if (mid % 2 == 1) {
            if (arr[mid] == arr[mid - 1])
                search(arr, mid + 1, high);
            else
                search(arr, low, mid - 1);
        }
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        int[] arr = { 1, 1, 2, 4, 4, 5, 5, 6, 6 };
        search(arr, 0, arr.length - 1);
    }
}