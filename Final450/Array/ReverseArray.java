import java.io.*;
import java.util.*;
import java.util.stream.*;
public class ReverseArray
{
	static class FastReader
	{
		BufferedReader br;
		StringTokenizer st;
		FastReader()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next()
		{
			while(st == null || !st.hasMoreTokens())
			{
				try
				{
					st = new StringTokenizer(br.readLine());
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}

			return st.nextToken();
		}

		String nextLine()
		{
			String s="";
			try
			{
				s = br.readLine();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}

			return s;
		}

		int nextInt()
		{
			return Integer.parseInt(next());
		}

		long nextLong()
		{
			return Long.parseLong(next());
		}
		double nextDouble()
		{
			return Double.parseDouble(next());
		}

	}	


	public static void printReverse(int arr[])
	{
		for(int i = arr.length - 1;i>=0;i--)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void swapArray(int arr[], int start, int end)
	{
		if(start>= end)
			return;

		int temp = arr[start];
		arr[start]=arr[end];
		arr[end] = temp;

		swapArray(arr, start+1, end-1);
	}

	public static void printArray(int arr[])
	{
		int l = arr.length;

		Arrays.stream(arr).forEach(x -> System.out.print(x+" "));
		System.out.println();
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();

		System.out.println("Enter the 7 elements");
		int arr[] =new int[7];
		for(int i = 0;i<7;i++)
			arr[i]=fr.nextInt();

		printArray(arr);
		System.out.println("--------------------");
		printReverse(arr);
		System.out.println("--------------------");
		swapArray(arr, 0, arr.length - 1);
		printArray(arr);
		System.out.println("--------------------");
	}
}