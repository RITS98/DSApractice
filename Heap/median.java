//https://www.baeldung.com/java-stream-integers-median-using-heap


class Median {

    static PriorityQueue<Integer> min = new PriorityQueue<>();
    static PriorityQueue<Integer> max = new PriorityQueue<>((n1,n2) -> n2-n1);
    public static void insertHeap(int x)
    {
        if(max.size() == 0 || x<max.peek())
        max.add(x);
        else
        min.add(x);
        
        
        balanceHeaps();
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       if(min.size() - max.size() > 1)
       max.offer(min.poll());
       else if(max.size() - min.size()>1)
       min.offer(max.poll());
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        double median = 0.0;
        if(min.size()<max.size())
        median = max.peek();
        else if(min.size()>max.size())
        median = min.peek();
        else
        median = (min.peek()+max.peek())/2.0;
        
        return median;
    }
}