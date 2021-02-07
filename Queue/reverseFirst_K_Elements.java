import java.util.*;
public class reverseFirst_K_Elements 
{
    static class construct
    {
        Queue<Integer> q1 = new LinkedList<Integer>();
        Stack<Integer> st1 = new Stack<Integer>();

        void enQueue(int data)
        {
            q1.offer(data);
        }

        void reverse(int k)
        {
            System.out.println(q1);
            int t = 0;
            while(t++<k)
            st1.add(q1.poll());

            Queue<Integer> q2 = new LinkedList<Integer>();
            while(!st1.isEmpty())
            q2.add(st1.pop());

            while(!q1.isEmpty())
            q2.add(q1.poll());

            System.out.println(q2);
        }
    }

    public static void main(String args[])
    {
        construct ob =new construct();
        ob.enQueue(10);
        ob.enQueue(20);
        ob.enQueue(30);
        ob.enQueue(40);
        ob.enQueue(50);
        ob.enQueue(60);
        ob.enQueue(70);
        ob.enQueue(80);
        ob.enQueue(90);
        ob.reverse(4);
    }
    
}
