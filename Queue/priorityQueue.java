import java.util.*;
public class priorityQueue 
{
    Node head;
    class Node
    {
        int data;
        int priority;
        Node next;
        Node(int data,int pri)
        {
            this.data = data;
            priority = pri;
            next =null;
        }
    }

    public void push(int data,int p)
    {
        Node new_node = new Node(data,p);
        if(head == null)
        {
            head  = new_node;
            return;
        }

        else if(head.priority>p)
        {
            new_node.next = head;
            head = new_node;
            return;
        }

        Node t = head;
        while(t.next != null && t.next.priority < p)
        {
            t = t.next;
        }
        new_node.next = t.next;
        t.next = new_node;

    }
    public int pop()
    {
        int x = head.data;
        head = head.next;
        return x;
    }
    public void printList()
    {
        Node t = head;
        while(t != null)
        {
            System.out.print(t.data+"("+t.priority+") -> ");
            t=t.next;
        }
        System.out.println("NULL\n");
    }
    public static void main(String args[])
    {
        priorityQueue ob = new priorityQueue();
        ob.push(4,1);
        ob.push(9,3);
        ob.push(7,2);
        ob.push(3,0);
        ob.printList();
        System.out.println(ob.pop());
    }
    
}
