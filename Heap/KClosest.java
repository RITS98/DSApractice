//Solution 1 : Using Binary Search for sorted array

class Solution{   
public:
    // Function to find the cross over point the point 
    // before which elements are smaller than or equal 
    // to x and after which greater than x
    int findCrossOver(vector<int>arr, int low, int high, int x) {
    
        // Base cases
        if (arr[high] <= x) 
            return high;
        if (arr[low] > x) 
            return low;

        // Find the middle point
        int mid = (low + high) / 2; 


        if (arr[mid] <= x && arr[mid + 1] > x) 
            return mid;

        else if (arr[mid] < x) 
            return findCrossOver(arr, mid + 1, high, x);
        
        else
            return findCrossOver(arr, low, mid - 1, x);
    }

    vector<int> printKClosest(vector<int> arr, int n, int k, int x) {
        int l = findCrossOver(arr, 0, n - 1, x); // Find the crossover point
        int r = l + 1; // Right index to search
        int count = 0; // To keep track of count of elements already printed

        // If x is present in arr[], then reduce left index
        if (arr[l] == x) l--;

        vector<int> closest;
        // Compare elements on left and right of crossover
        // point to find the k closest elements
        while (l >= 0 && r < n && count < k) {
            if (x - arr[l] < arr[r] - x)
                closest.push_back(arr[l--]);
            else
                closest.push_back(arr[r++]);
            count++;
        }

        // If there are no more elements on right side, 
        // then print left elements
        while (count < k && l >= 0) closest.push_back(arr[l--]), count++;

        // If there are no more elements on left side
        // print right elements
        while (count < k && r < n) closest.push_back(arr[r++]), count++;
        return closest;
    }
};



// Solution 2 for unsorted array


class Solution {
    
    public class Pair<K,V>
    {
        K val1;
        V val2;
        
        public Pair(K val1, V val2)
        {
            this.val1 = val1;
            this.val2 = val2;
        }
        
        public void setFirst(K val1)
        {
            this.val1 = val1;
        }
        
        public void setSecond(V val2)
        {
            this.val2 = val2;
        }
        
        public K getFirst()
        {
            return this.val1;
        }
        
        public V getSecond()
        {
            return this.val2;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<Pair<Integer, Integer>> pq 
            = new PriorityQueue<Pair<Integer, Integer>>(new Comparator<Pair<Integer, Integer>>(){
           
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2)
            {
                
                return p2.getSecond()-p1.getSecond() == 0?p1.getFirst()-p2.getFirst():p2.getSecond()-p1.getSecond();
            }
        });
        
        
        for(int i = 0;i<k;i++)
        {
            int diff = Math.abs(arr[i] - x);
            Pair<Integer, Integer> p = new Pair<>(arr[i], diff);
            pq.add(p);
        }
        
        for(int i = k;i<arr.length;i++)
        {
            int diff = Math.abs(arr[i] - x);
            Pair<Integer, Integer> p = new Pair<>(arr[i], diff);
            if(diff < pq.peek().getSecond())
            {
                pq.poll();
                pq.add(p);
            }
        }
        
        List<Integer>  l = new ArrayList<>();
        while(!pq.isEmpty())
        {
            l.add(pq.poll().getFirst());
        }
        
        Collections.sort(l);
        
        return l;
    }
}


//Solution 3 Sorted array using stream

public List<Integer> findClosestElements(int[] A, int k, int x) {
        int left = 0, right = A.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - A[mid] > A[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        return Arrays.stream(A, left, left + k).boxed().collect(Collectors.toList());
    }



// Solution 4 Using two pointers for sorted array

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        while (hi - lo >= k) {
            if (Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)) {
                lo++;
            } else {
                hi--;
            }
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = lo; i <= hi; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}