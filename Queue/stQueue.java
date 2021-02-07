import java.util.*;
public class stQueue
{
    static class Queue
    {
        static Stack<Integer> s1 = new Stack<Integer>();
        static Stack<Integer> s2 = new Stack<Integer>();

        static void enQueue(int x)
        {
            if(s1.isEmpty())
            {
                s1.push(x);
            }
            else
            {
                while(!s1.isEmpty())
                s2.push(s1.pop());

                s1.push(x);
                while(!s2.isEmpty())
                s1.push(s2.pop());
            }
            
        }

        static void deQueue()
        {
            if(s1.isEmpty())
            {
                System.out.println("Queue is Empty");
                return;
            }
            System.out.println(s1.pop());
        }
    }
    
    public static void main(String args[])
    {
        Queue q = new Queue();

        q.enQueue(1);  
        q.enQueue(2);  
        q.enQueue(3);  
    
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
    }
}