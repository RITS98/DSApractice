import java.io.*;
import java.util.*;

public class medianEqualSize
{
	public static int getMedian(int a[], int b[], int startA, int endA, int startB, int endB)
	{
		if(endA - startA == 1)
		{
			return Math.max(a[startA],b[startB])/2 +Math.min(a[endA], b[endB])/2;
		}

		int m1 = medianCal(a, startA, endA);
		int m2 = medianCal(b, startB, endB);

		if(m1 == m2)
			return m2;

		else if(m1<m2)
		{
			return getMedian(a, b,(endA + startA+1)/2,endA, startB, (endB+startB+1)/2);
		}
		else
		{
			return getMedian(a, b, startA, (endA+startA+1)/2, (endB+startB+1)/2, endB);
		}


	}

	public static int medianCal(int arr[], int s, int e)
	{
		int n = e - s + 1;
		if(n%2 == 0)
		{
			return (arr[s+n/2]+arr[s+n/2-1])/2;
		}
		else
			return arr[s+n/2];
	}

	public static void main(String args[])
	{
		int ar1[] = { 1, 2, 3, 6 };
        int ar2[] = { 4, 6, 8, 10 };
        int n1 = ar1.length;
        int n2 = ar2.length;
        if (n1 != n2) {
            System.out.println("Doesn't work for arrays "+ "of unequal size");
        }
        else if (n1 == 0) 
        {
            System.out.println("Arrays are empty.");
        }
        else if (n1 == 1) 
        {
            System.out.println((ar1[0] + ar2[0]) / 2);
        }
        else {
            System.out.println("Median is " + getMedian(ar1, ar2, 0, ar1.length - 1,0, ar2.length - 1));
        }
	}
}