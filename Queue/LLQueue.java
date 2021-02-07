public class LLQueue
{
    Node front, rear;
    static class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            next = null;
        }    
    }

    public void enqueue(int x)
    {
        Node new_node = new Node(x);

        if(rear == null)
        {
            front = rear = new_node;
            return;
        }

        rear.next = new_node;
        rear = new_node;
        return;
    }

    public int dequeue()
    {
        if(front == null)
        {
            rear = null;
            System.out.println("Queue is Empty!");
            return Integer.MIN_VALUE;
        }

        int x = front.data;
        front = front.next;
        if(front == null)
        rear = null;
        return x;
    }

    public static void main(String[] args) {
        
        LLQueue q = new LLQueue();
        q.enqueue(10); 
        q.enqueue(20); 
        System.out.println(q.dequeue()); 
        System.out.println(q.dequeue());  
        q.enqueue(30); 
        q.enqueue(40); 
        q.enqueue(50); 
        System.out.println(q.dequeue());  
    }
}