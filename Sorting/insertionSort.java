import java.io.*;
import java.util.*;
import java.util.stream.*;

public class insertionSort
{
	public static void insertion(int arr[])
	{
		int size = arr.length;

		for(int i = 1;i<size;i++)
		{
			int key = arr[i];
			int j = i-1;

			while(j>=0 && arr[j]>key)
			{
				arr[j+1] = arr[j];
				j--;
			}

			arr[j+1] = key;
		}
	}


	public static void main(String args[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int arr[] = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		insertion(arr);
		Arrays.stream(arr).forEach(i -> System.out.print(i+" - "));
		System.out.printf("\n%2.2f\n",46.4634);
	}
}