import java.io.*;
import java.util.*;
import java.util.stream.*;

public class mergeSort
{
	public static void merge(int arr[], int l, int m, int r)
	{
		//sizes of two partition
		int n1 = m - l + 1;
		int n2 = r-m;

		//creating temporary arrays
		int L[] = new int[n1];
		int R[] = new int[n2];

		for(int i = 0;i<n1;i++)
			L[i] = arr[l+i];
		for(int i=0;i<n2;i++)
			R[i] = arr[m+1+i];



		//combining the two tempoaray array after comparing them element wise
		int i =0, j=0;
		int k = l;



		while(i<n1 && j<n2)
		{
			if(L[i]<R[j])
			{
				arr[k] = L[i];
				i++;
			}
			else
			{
				arr[k] = R[j];
				j++;
			}
			k++;
		}


		//copying the rest of the elements in the final array
		while(i<n1)
		{
			arr[k++] = L[i++];
		}
		while(j<n2)
		{
			arr[k++] = R[j++];
		}
	}

	public static void sort(int arr[], int l, int r)
	{
		if(l<r)
		{
			int m = l + (r-l)/2;

			//dividing the array
			sort(arr,l, m);
			sort(arr, m+1, r);

			//merging the array
			merge(arr, l, m, r);
		}
	}

	public static void main(String args[])throws IOException
	{
		int arr[] = new int[]{12, 11, 13, 5, 6, 7};
		sort(arr, 0, arr.length - 1);

		Arrays.stream(arr).forEach(i -> System.out.print(i+ " "));
		System.out.println();
	}
}