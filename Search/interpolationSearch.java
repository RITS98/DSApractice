import java.util.*;
class interpolationSearch
{
    public static void main(String args[])
    {
        int key = 3;
        int arr[] = { 1,2,3,4,5,6,7,8,9,10,12,13,14,15};
        long starttime = System.nanoTime();
        int pos = interpolationS(arr,key,0, arr.length - 1);
        long estimatedtime = System.nanoTime() - starttime;
        System.out.println(pos);
        System.out.println("Time consumed - " + estimatedtime);
    }

    public static int interpolationS(int arr[],int key, int low, int high)
    {
        int pos;

        if(low<=high && arr[low]<=key && arr[high]>=key)
        {
            pos = low + (high - low)/(arr[high]-arr[low])*(key - arr[low]);


            if(arr[pos] == key)
            return pos;

            else if(arr[pos]<key)
            return interpolationS(arr, key, pos + 1, high);
            else
            return interpolationS(arr, key, low, pos - 1);
        }

        return -1;
    }
}