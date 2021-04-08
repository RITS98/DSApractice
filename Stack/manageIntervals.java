/*

Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals. Let the intervals be represented as pairs of integers for simplicity. 
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8}}. The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}. Similarly, {5, 7} and {6, 8} should be merged and become {5, 8}

*/


import java.io.*;
import java.util.*;
import java.util.stream.*;

class Interval
{
	int start, end;
	Interval(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
}
public class manageIntervals
{

	public static void mergeIntervals(Interval arr[])
	{
		Arrays.sort(arr, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2)
			{
				return i2.start - i1.start;
			}
		});

		int index = 0;

		for(int i = 0 ;i< arr.length;i++)
		{
			if(arr[index].end >= arr[i].start)
			{
				arr[index].end =  Math.max(arr[index].end, arr[i].end);
				arr[index].start = Math.min(arr[index].start, arr[i].start); 
			}
			else
			{
				index++;
				arr[index] = arr[i];
			}
		}

		for(int i = 0;i<=index;i++)
		{
			System.out.println("[" + arr[i].start + "," + arr[i].end + "]");
		}
	}

	public static void main(String args[])
	{
		Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        mergeIntervals(arr);
	}

}