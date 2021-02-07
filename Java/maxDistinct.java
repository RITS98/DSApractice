/*

*/


import java.util.*;
import java.util.stream.*;
public class maxDistinct {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
        }
        long max = 0;
        while(deque.size()>=m)
        {
            long countUnique = deque.stream()
                                .limit(m).distinct().count();
            if(countUnique>max)
            max = countUnique; 
            deque.removeFirst();
        }
        
        System.out.println(max);
    }
}



