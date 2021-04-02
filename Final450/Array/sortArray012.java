import java.util.*;
import java.io.*;
import java.util.stream.*;
public class sortArray012
{
	public static void sorting(int arr[], int low, int high)
	{
		int mid = 0;
		while(mid<=high)
		{
			
			if(arr[mid] == 0)
			{
				int temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				low ++;mid++;
			}
			else if(arr[mid] == 2)
			{
				int temp = arr[high];
				arr[high] = arr[mid];
				arr[mid] = temp;
				high --;
			}
			else
			{
				mid++;
			}
		}
	}

	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the 7 numbers of 0  1 2");

		int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		sorting(arr, 0, 6);
		for(int i = 0;i<7;i++)
			System.out.print(arr[i]+" - ");
		System.out.println();
	}
}