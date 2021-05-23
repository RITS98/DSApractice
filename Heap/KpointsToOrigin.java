//SOLUTION 1


class KpointsToOrigin {
    public class Pair<K,V>
    {
        K one;
        V two;
        
        public Pair(K one, V two)
        {
            this.one = one;
            this.two = two;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<Pair<Integer, Pair<Integer, Integer>>>(new Comparator<Pair<Integer, Pair<Integer, Integer>>>(){
           
            public int compare(Pair<Integer, Pair<Integer, Integer>> p1, Pair<Integer, Pair<Integer, Integer>> p2)
            {
                return p2.one-p1.one;
            }
            
        });
        
        
        for(int i = 0;i<points.length;i++)
        {
            int distance = points[i][0]*points[i][0]+points[i][1]*points[i][1];
            Pair<Integer, Integer> pon = new Pair<>(points[i][0],points[i][1]);
            Pair<Integer, Pair<Integer, Integer>> close = new Pair<>(distance,pon);
            
            pq.add(close);
            if(pq.size()>k)
                pq.poll();
        }
        int clpoints[][] = new int[k][2];
        int index = 0;
        while(!pq.isEmpty() && index<k)
        {
            clpoints[index][0] = pq.peek().two.one;
            clpoints[index][1] = pq.peek().two.two;
            pq.poll();
            index++;
        }
        
        return clpoints;
    }
}



//Solution 2 Takes less time

public int[][] kClosest(int[][] points, int K) {
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
    for (int[] p : points) {
        pq.offer(p);
        if (pq.size() > K) {
            pq.poll();
        }
    }
    int[][] res = new int[K][2];
    while (K > 0) {
        res[--K] = pq.poll();
    }
    return res;
}