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
public class mergeIntervals
{
	public static void merge(Interval arr[])
	{
		Stack<Interval> st = new Stack<Interval>();

		Arrays.sort(arr, new Comparator<Interval>(){

			public int compare(Interval i1, Interval i2)
			{
				return i2.start - i1.start;
			}
		});

		st.push(arr[0]);

		for(int i = 1;i<arr.length;i++)
		{
			Interval s = st.peek();
			if(s.end >= arr[i].start)
			{
				st.pop();
				s.end = Math.max(s.end, arr[i].end);
				s.start = Math.min(s.start, arr[i].start);
				st.push(s);
			}
			else
			{
				st.push(arr[i]);
			}

		}
		String s = "";
		while(!st.isEmpty())
		{
			Interval x = st.pop();
			s= "["+x.start+","+x.end+"]"+","+s;
		}

		System.out.println(s);
	}

	public static void main(String args[]) {
        Interval arr[]=new Interval[5];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        arr[4]= new Interval(5, 12);
        merge(arr);
    }
}