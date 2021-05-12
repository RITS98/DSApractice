class nextGreater
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        Stack<Long> st = new Stack<>();
        long next[] = new long[n];
        next[n-1] = -1;
        st.push(arr[n-1]);
        for(int i = n-2;i>=0;i--)
        {
            if(arr[i]>=st.peek())
            {
                while(!st.isEmpty() && arr[i]>=st.peek())
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
}