import java.util.*;
import java.util.stream.*;
import java.io.*;


public class stringSelectionSort
{
	public static void selectionSort(String arr[])
	{
		int size = arr.length;

		for(int i = 0;i<size;i++)
		{
			int min_idx = i;
			for(int j = i+1;j<size;j++)
			{
				if(arr[j].compareToIgnoreCase(arr[min_idx])<0)
					min_idx = j;
			}

			String temp = arr[i];
			arr[i] = arr[min_idx];
			arr[min_idx]=temp;
		}
	}

	public static void main(String args[])throws IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		//int size = Integer.parseInt(br.readLine());

		String arr[] = br.readLine().split("\\s+");
		selectionSort(arr);

		Arrays.stream(arr).forEach(x -> System.out.print(x+" - "));

		System.out.printf("\n");
	}
}