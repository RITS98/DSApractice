public class jumpSearch {

    public static void main(String args[])
    {
        int key = 3;
        int arr[] = { 1,2,3,4,5,6,7,8,9,10,12,13,14,15};
        long starttime = System.nanoTime();
        int pos = jump(arr,key);
        long estimatedtime = System.nanoTime() - starttime;

        System.out.println(pos);
        System.out.println("Time consumed - "+estimatedtime);
    }

    public static int jump(int[] arr, int key)
    {
        int n = arr.length;
        int step = (int)Math.floor(Math.sqrt(n));
        int prev=0;
        while(arr[Math.min(step,n-1)]<key)
        {
            prev = step;
            step += (int)Math.floor(Math.sqrt(n));

            if(prev>=n)
            return -1;
        }

        while(arr[prev]<key)
        {
            prev++;

            if(prev == Math.min(step,n))
            return -1;
        }

        return arr[prev]==key?prev:-1;
        
    }
    
}
