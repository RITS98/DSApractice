/*
You are given a list of n-1 integers and these integers are in the range of 1 to n.
There are no duplicates in the list. One of the integers is missing in the list. 
Write an efficient code to find the missing integer.

Example: 

Input: arr[] = {1, 2, 4, 6, 3, 7, 8}
Output: 5
Explanation: The missing number from 1 to 8 is 5

Input: arr[] = {1, 2, 3, 5}
Output: 4
Explanation: The missing number from 1 to 5 is 4
*/

import java.util.*;
public class missingNo
{
    public static void xorMiss(int arr[])
    {
        int x1 = arr[0];
        int x2 = 1;
        int n =arr.length;
        for(int i = 1;i<n;i++)
        {
            x1=x1^arr[i];
            x2=x2^(i+1);
        }

        x2 = x2^(n+1);
        System.out.println("Misssing No. - "+(x1^x2));
    }

    public static void sumMiss(int arr[])
    {
        int sum = 0;
        int n = arr.length;
        int sum1 = n*(n+1)/2;

        for(int i =0;i<n;i++)
        {
            sum = sum + arr[i];
        }

        System.out.println("Missing No. 1 : - "+(sum1-sum));
    }

    public static void main(String args[])
    {
        int a[] = { 1, 2, 4, 5, 6 };
        xorMiss(a);
        sumMiss(a);
    }
}