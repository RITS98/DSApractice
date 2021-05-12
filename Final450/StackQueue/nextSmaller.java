import java.util.*;
import java.io.*;

class nextSmaller
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextSmallerElement(long[] arr, int n)
    { 
        Stack<Long> st = new Stack<>();
        long next[] = new long[n];
        next[n-1] = -1;
        st.push(arr[n-1]);
        for(int i = n-2;i>=0;i--)
        {
            if(arr[i]<=st.peek())
            {
                while(!st.isEmpty() && arr[i]<=st.peek())
                st.pop();
                
                next[i] = st.isEmpty()?-1:st.peek();
            }
            else
            {
                next[i] = st.peek();
            }
            st.push(arr[i]);
        }
        
        return next;
    } 

    public static void main(String args[])
    {
        long arr[] = {13,7,6,12};
        System.out.println(Arrays.toString(nextSmallerElement(arr, 4)));
        long val[] = {4,8,5,2,25};

        System.out.println(Arrays.toString(nextSmallerElement(val, 5)));
    }
}