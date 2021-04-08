/*

In pre-order traversal of BST, first element is the root element of the tree. Iterate through given pre-order traversal of BST and compare each element with first element of the array till the index where elements are less than the first element. Store the value of index in variable called as ‘Pivot’. Print elements of pre-order array from ‘Pivot’ index to index 1. Print elements of pre-order array from ‘array,length’ index – 1 to ‘Pivot’ index + 1. Print first element of pre-order array.
*/

import java.io.*;
import java.util.*;

import java.util.stream.*;

public class preToPost
{
	public static void ToPost(int arr[])
	{
		int n = arr.length;
		int pivot = 0;
		for(int i = 1;i<n;i++)
		{
			if(arr[i]>arr[0])
			{
				pivot = i;
				break;
			}	

		}

		for(int i = pivot - 1;i>=1;i--)
		{
			System.out.print(arr[i]+" ");
		}
		for(int i = n-1;i>=pivot;i--)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println(arr[0]);
	}

	public static void main(String args[])
	{
		int pre[] = { 40, 30, 32, 35, 80, 90, 100, 120 };
		ToPost(pre);
	}
}