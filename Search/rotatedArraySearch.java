import java.util.*;
public class rotatedArraySearch 
{
    public static int search(int arr[],int l,int u,int key)
    {
        while(l<=u)
        {
            int mid = l + (u-l)/2;
            if(arr[mid] == key)
            return 1;
            else if(key>arr[mid])
            l=mid+1;
            else 
            u=mid-1;
        }
        return -1;
    }

    public static int findPivot(int arr[])
    {
        
    }
    
}
