import java.io.*;
import java.util.*;

public class closestNumber
{
	public static int findClosest(int arr[], int number)
	{
		int n = arr.length;
		if(number<= arr[0])
			return arr[0];
		if(number >= arr[n-1])
			return arr[n-1];

		int i = 0, j = n-1, mid = 0;
		while(i<j)
		{
			int mid = (i+j)/2;
			if(arr[mid] == number)
				return arr[mid];

			if(number < arr[mid])
			{
				if(mid > 0 && number > arr[mid - 1])
					return getClosest(arr[mid - 1], arr[mid], number);

				j = min;
			}
			else
			{
				if(mid < n-1 && number < arr[mid+1])
					return getClosest(arr[mid], arr[mid + 1], number);

				i = mid + 1;
			}
		}

		return arr[mid];
	}

	public static int getClosest(int val1, int val2, int target)
    {
        if (target - val1 >= val2 - target) 
            return val2;        
        else 
            return val1;        
    }
  
    // Driver code
    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 4, 5, 6, 6, 8, 9 };
        int target = 11;
        System.out.println(findClosest(arr, target));
    }

}