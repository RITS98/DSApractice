// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class TernarySearch
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String s[] = read.readLine().trim().split("\\s+");
            
            int N = Integer.parseInt(s[0]);
            int K = Integer.parseInt(s[1]);
            
            int arr[] = new int[N];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            for(int i = 0; i < N; i++)
            {
                arr[i] = Integer.parseInt(st[i]);
            }
            
            SearchElement obj = new SearchElement();
            
            System.out.println(obj.ternarySearch(arr, N, K));
        }
    }
}// } Driver Code Ends


class SearchElement
{
    private static int tS(int l, int r, int arr[], int k)
    {
        while(l<=r)
        {
            int mid1 = l+(r-l)/3;
            int mid2 = r-(r-l)/3;
            
            if(arr[mid1]==k)
            return mid1;
            if(arr[mid2]==k)
            return mid2;
            
            if(k<arr[mid1])
            return tS(l,mid1 -1, arr, k);
            else if(k>arr[mid2])
            return tS(mid2+1,r,arr,k);
            else
            return tS(mid1+1, mid2-1, arr, k);
        }
        return -1;
    }
    static int ternarySearch(int arr[], int N, int K)
    {
        return tS(0, N-1, arr, K)==-1?-1:1;
        
        
    }
}