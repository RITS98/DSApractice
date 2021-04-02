import java.io.*;
import java.util.*;
import java.util.stream.*;
public class maxMin
{
	static class Pair
	{
		int min;
		int max;
	}

	static Pair getMinMax(int arr[], int n)
	{
		Pair minmax = new Pair();
		int i;

		if(n%2 == 0)
		{
			if(arr[0]>arr[1])
			{
				minmax.min = arr[1];
				minmax.max = arr[0];
			}	
			else
			{
				minmax.min = arr[0];
				minmax.max = arr[1];
			}
			i=2;

		}
		else
		{
			minmax.min = arr[0];
			minmax.max = arr[0];
			i = 1;
		}

		while(i<n-1)
		{
			if(arr[i] >arr[i+1])
			{
				if(arr[i]>minmax.max)
					minmax.max = arr[i];
				if(arr[i+1]<minmax.min)
					minmax.min = arr[i+1];
			}

			else
			{
				if(arr[i+1]>minmax.max)
					minmax.max = arr[i+1];
				if(arr[i]<minmax.min)
					minmax.min = arr[i];
			}

			i+=2;
		}

		return minmax;
	}

	public static void main(String args[])throws IOException
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter 7 numbers - ");
		int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Pair minmax = getMinMax(arr, 7);
		System.out.println("MAX-"+minmax.max +" \n Min - "+minmax.min);
		System.out.println("---------------------------");
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();

		System.out.println(max+" ----- "+min);
		

	}
}