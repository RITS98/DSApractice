import java.util.*;
public class constructStackUsingQueue 
{
    static class construct
    {
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        void enQueue(int data)
        {
            if(q1.isEmpty())
            q2.add(data);
            else
            q1.add(data);
        }

        void deQueue()
        {
            int ele = Integer.MIN_VALUE;
            if(!q1.isEmpty())
            {
                int size = q1.size();
                int t = 0;
                while(t++<size - 1)
                {
                    q2.add(q1.poll());
                }
                ele = q1.poll();
            }
            else
            {
                int size = q2.size();
                int t = 0;
                while(t++<size - 1)
                {
                    q1.add(q2.poll());
                }
                ele = q2.poll();
            }

            System.out.println(ele);
        }
    }

    public static void main(String args[])
    {
        construct ob = new construct();
        ob.enQueue(1);
        ob.enQueue(2);
        ob.enQueue(3);
        ob.enQueue(4);
        ob.deQueue();
        ob.deQueue();
    }
    
}
