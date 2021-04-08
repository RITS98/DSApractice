//smallest is put in the correct position after each pass

import java.util.*;
public class Selection
{
    public static void selectionSort(int arr[])
    {
        int n = arr.length;
        for(int i = 0 ; i < n-1 ; i++)
        {
            int min_idx = i;
            for(int j = i+1 ; j< n ; j++)
            {
                if(arr[j] < arr[min_idx])
                min_idx = j;
            }

            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }

        System.out.println("Sorted Array - ");
        for(int  i : arr)
        System.out.print(i + "  -  ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc =  new Scanner(System.in);
        int arr[] = new int[]{98, 45, 65, 23, 89, 20, 64, 57, 16, 51, 36};

        selectionSort(arr);
    }    
}
