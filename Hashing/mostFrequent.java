import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class mostFrequent
{
	public static void frequency(int arr[])
	{
		int n = arr.length;

		HashMap<Integer, Integer> hm = new HashMap<>();

		for(int i:arr)
		{
			hm.put(i, hm.getOrDefault(i, 0)+1);
		}

		int max_count = 0, res = -1;

		for(Entry<Integer, Integer> e: hm.entrySet())
		{
			if(max_count < e.getValue())
			{
				max_count = e.getValue();
				res = e.getKey();
			}
		}

		System.out.println(res);
	}

	public static void main (String[] args) {
         
        int arr[] = {1, 5, 2, 1, 3, 2, 1, 5, 3, 5, 6, 5};
        int n = arr.length;
         
        frequency(arr);
    }
}