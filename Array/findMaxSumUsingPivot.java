/*

The method discusses the solution using pivot in O(n) time. 
The pivot method can only be used in the case of a sorted or a rotated sorted array. 
For example: {1, 2, 3, 4} or {2, 3, 4, 1}, {3, 4, 1, 2} etc.

Approach: Let’s assume the case of a sorted array. 
As we know for an array the maximum sum will be when the array is sorted in ascending order. 
In case of a sorted rotated array, we can rotate the array to make it in ascending order. 
So, in this case, the pivot element is needed to be found following which the maximum sum can be calculated.
Algorithm: 
Find the pivot of the array: if arr[i] > arr[(i+1)%n] then it is the pivot element. 
(i+1)%n is used to check for the last and first element.
After getting pivot the sum can be calculated by finding the difference with the pivot 
which will be the multiplier and multiply it with the current element while calculating 
the sum

*/
// Java program to find maximum sum
// of all rotation of i*arr[i] using pivot.
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
public class findMaxSumUsingPivot
{
 
// function definition
    static int maxSum(int arr[], int n)
    {
        int sum = 0;
        int i;
        int pivot = findPivot(arr, n);
     
        // difference in pivot and index of
        // last element of array
        int diff = n - 1 - pivot;
        for(i = 0; i < n; i++)
        {
            sum= sum + ((i + diff) % n) * arr[i];
        }
        return sum;
    }
     
    // function to find pivot
    static int findPivot(int arr[], int n)
    {
        int i;
        for(i = 0; i < n; i++)
        {
            if(arr[i] > arr[(i + 1) % n])
                return i;
        }
        return 0;
    }
     
    // Driver code
    public static void main(String args[])
    {
        // rotated input array
        int arr[] = {8, 9, 1, 2};
        int n = arr.length;
        int max = maxSum(arr,n);
        System.out.println(max);
         
    }
}