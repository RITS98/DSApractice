class sumBetweenK1andK2smallest 
{ 
    public static long sumBetweenTwoKth(long a[], long n, long k1, long k2)
    {
       PriorityQueue<Long> hp = new PriorityQueue<Long>(Comparator.reverseOrder());

        // max heap for k1 smallest
        PriorityQueue<Long> hp1 = new PriorityQueue<Long>(Comparator.reverseOrder());
        
        // return 0 if array is empty
        if(n == 0) return 0l;
        
        HashMap<Long,Integer> map = new HashMap<Long,Integer>();
        
        // hash map to remove the duplicate elements
        //and keep track of the count of the elements
        for(int i = 0 ;i < (int) n; i++){
        map.put(a[i], map.getOrDefault(a[i],0) + 1);
        }
        
        // in test case sometime k1 > k2 so just swap it
        if(k1>k2){
        long temp = k1;
        k1 = k2;
        k2 = temp;
        }
        
        // add element to find the k1th smallest and k2th smallest
        for (long key : map.keySet()) 
        {
            hp.add(key);
            if(hp.size() > k2)
            {
                hp.poll();
            }
            
            hp1.add(key);
            if(hp1.size() > k1)
            {
                hp1.poll();
            }
        
        }
        
        long sum = 0l;
        if(k2 > map.size())
        {
            for (long key : map.keySet()) 
            {
                if(key > hp1.peek())
                {
                    sum = sum + (key * map.get(key)) ;
                }
            }
        }
        else
        {
            for (long key : map.keySet()) 
            {
            
                if(key > hp1.peek() && key < hp.peek())
                {
                    sum = sum + key*map.get(key) ;
                }
            }
        }

        return sum;
        
        
    }
    
}
