/*
https://media.geeksforgeeks.org/wp-content/uploads/arra.jpg
*/


import java.io.*;
import java.util.*;
import java.util.stream.*;


public class arrayRotation
{
	public static int gcd(int a, int b)
	{
		if(b==0)
			return a;
		else
			return gcd(b, a%b);
	}

	public static void rotation1(int arr[], int d)
	{
		int size =arr.length;

		for(int i = 0;i<d;i++)
		{
			int temp = arr[0];
			for(int j = 0 ;j<size-1;j++)
			{
				arr[j] = arr[j+1];
			}
			arr[size -1]=temp;
		}

		Arrays.stream(arr).forEach(i -> System.out.print(i+" "));
		System.out.println();
	}

	public static void rotation2(int arr[], int d)
	{
		int size = arr.length;
		d = d%size;			//if d>=n

		int gcd = gcd(size, d);

		for(int i = 0;i<gcd ;i++)
		{
			int temp = arr[i];
			int j = i;

			while(true)
			{
				int k = j+d;
				if(k>=size)
					k = k-size;
				if(k == i)
					break;

				arr[j] = arr[k];
				j=k;
			}

			arr[j] = temp;
		}

		Arrays.stream(arr).forEach(i->System.out.print(i+" "));
		System.out.println();
	}

	public static void main(String args[])throws IOException
	{
		int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int arr2[] = arr.clone();
		rotation1(arr,3);
		rotation2(arr2,3);

	}

}