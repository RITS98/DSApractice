import java.io.*;
import java.util.*;
import java.util.stream.*;

public class printRotation
{
	public static void leftRotate(int arr[], int k)
	{
		int temp[] = new int[2*arr.length];


		k=k%arr.length;

		for(int i = 0;i<arr.length;i++)
		{
			temp[i] = temp[i+ arr.length] = arr[i];
		}


		for(int i = k;i<k+arr.length;i++)
		{
			System.out.print(temp[i]+" ");
		}

		System.out.println();
	}

	public static void main(String args[])throws IOException
	{
		int arr[] = {1, 3, 5, 7, 9};
        int n = arr.length;
       
        
       
        int k = 2;
        leftRotate(arr,k);
       
        k = 3;
        leftRotate(arr, k);
       
        k = 4;
        leftRotate(arr, k);
	}
}