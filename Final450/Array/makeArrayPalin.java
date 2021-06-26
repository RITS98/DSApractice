/*Given an array of positive integers. We need to make the given array a ‘Palindrome’. The only allowed operation is”merging” (of two adjacent elements). Merging two adjacent elements means replacing them with their sum. The task is to find the minimum number of merge operations required to make the given array a ‘Palindrome’.

Example : 

Input : arr[] = {15, 4, 15}
Output : 0
Array is already a palindrome. So we
do not need any merge operation.

Input : arr[] = {1, 4, 5, 1}
Output : 1
We can make given array palindrome with
minimum one merging (merging 4 and 5 to
make 9)

Input : arr[] = {11, 14, 15, 99}
Output : 3
We need to merge all elements to make
a palindrome.
The expected time complexity is O(n).

 
Let f(i, j) be minimum merging operations to make subarray arr[i..j] a palindrome. If i == j answer is 0. We start i from 0 and j from n-1.
 

If arr[i] == arr[j], then there is no need to do any merging operations at index i or index j. Our answer in this case will be f(i+1, j-1).
Else, we need to do merging operations. Following cases arise.
If arr[i] > arr[j], then we should do merging operation at index j. We merge index j-1 and j, and update arr[j-1] = arr[j-1] + arr[j]. Our answer in this case will be 1 + f(i, j-1).
For the case when arr[i] < arr[j], update arr[i+1] = arr[i+1] + arr[i]. Our answer in this case will be 1 + f(i+1, j).
Our answer will be f(0, n-1), where n is the size of array arr[].

*/

import java.io.*;
import java.util.*;

public class makeArrayPalin
{
	public static void main(String[] args)throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];

		for(int i = 0;i<n;i++)
			arr[i] = sc.nextInt();


		int count++;
		for(int i=0,j=n-1;i<=j;)
		{
			if(arr[i]==arr[j])
			{
				i++;
				j--;
			}
			else if(arr[i]>arr[j])
			{
				j--;
				arr[j] = arr[j]+arr[j+1];
				ans++;
			}
			else
			{
				i++;
				arr[i]+=arr[i-1];
				ans++;
			}
		}

		System.out.println(ans);


	}
}