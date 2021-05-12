import java.io.*;
import java.util.*;

public class mergeIntervals
{
	public static int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        int x[] = intervals[0];
        ArrayList<int[]> arr = new ArrayList<>();
        
        for(int i = 1;i<intervals.length;i++)
        {
            if(x[1]<intervals[i][0])
            {
                arr.add(x);
                x = intervals[i];
            }
            else
            {
                x[1] = Math.max(intervals[i][1],x[1]);
            }
            
        }
        arr.add(x);
        
        return arr.toArray(new int[arr.size()][]);
        
    }

    public static void main(String args[])
    {
    	int arr[][] = {{1,3},{2,6},{8,14},{9,11},{18,20},{15,19}};

    	int x[][] = merge(arr);
    	for(int i[]:x)
    	{
    		System.out.print(Arrays.toString(i)+" ");

    	}

    	System.out.println();
    }
}