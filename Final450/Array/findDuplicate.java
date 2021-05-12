import java.io.*;
import java.util.*;
public class findDuplicate
{
	public static int find(int arr[], int n)
	{
		HashSet<Integer> hs = new HashSet<>();
		for(int i:arr)
		{
			if(hs.contains(i))
				return i;

			hs.add(i);
		}

		return -1;
	}
	public static void main(String args[])
	{
		int arr[] = {3,1,4,5,2,7,2};
		int n = arr.length;

		System.out.println(find(arr, n));
	}
}