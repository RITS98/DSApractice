class firstnegative {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Queue<Long> q = new LinkedList<Long>();
        long j = 0;
        
        ArrayList<Long> arr = new ArrayList<>();
        while(j<K)
        {
            if((int)A[(int)j]<0)
            q.add(j);
            j++;
        }
        
        for(long i = K;i<N;i++)
        {
            if(!q.isEmpty())
            {
                arr.add(A[Math.toIntExact(q.peek())]);
            }
            else
            arr.add(0l);
            
            while(!q.isEmpty() && q.peek() <= (i-K))
            q.poll();
            
            if((int)A[(int)i]<0)
            q.add(i);
        }
        
        if(!q.isEmpty())
        {
             arr.add(A[Math.toIntExact(q.peek())]);
        }
        else
        arr.add(0l);
        
        long val[] = new long[arr.size()];
        for(int m = 0;m<val.length;m++)
        val[m] = arr.get(m);
        
        return val;
    
        
    }
}