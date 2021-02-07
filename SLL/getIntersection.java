import java.util.*;
public class getIntersection
{
    static Node head1,head2;
    static class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data=data;
            next = null;
        }
    }
    void printList(Node t)
    {
        while(t!=null)
        {
            System.out.print(t.data+" -> ");
            t=t.next;
        }
        System.out.println("NULL");

    }

    int getCount(Node curr)
    {
        Node t = curr;
        int count = 0;
        while(t!=null)
        {
            count++;
            t=t.next;
        }
        return count;
    }

    int getNode()
    {
        int c1 = getCount(head1);
        int c2 = getCount(head2);

        if(c1>c2)
        {
            int d = c1 - c2;
            return getIntersectionNode(d,head1,head2);
        }
        else
        {
            int d = c2 - c1;
            return getIntersectionNode(d,head2,head1);
        }
    }

    int getIntersectionNode(int d,Node t1,Node t2)
    {
        Node current1 = t1;
        Node current2 = t2;
        for(int i = 0;i<d;i++)
        {
            if(current1 == null)
            return -1;

            current1 = current1.next;
        }

        while(current1 !=null && current2!=null)
        {
            if(current1 == current2)
            return current1.data;

            current1=current1.next;
            current2 = current2.next;
        }

        return -1;
    }

    // 2 pointer method (Important and very good way)
    public int getMeetingPoint()
    {
        Node ptr1 = head1;
        Node ptr2 = head2;

        if(ptr1 == null || ptr2 == null)
        return -1;

        while(ptr1 != ptr2)
        {
            ptr1 = ptr1 == null? head2:ptr1.next;
            ptr2 = ptr2 == null? head1: ptr2.next;
        }
        return ptr1.data;
    }

    public static void main(String args[])
    {
        getIntersection list = new getIntersection();
 
        // creating first linked list
        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);
 
        // creating second linked list
        list.head2 = new Node(10);
        list.head2.next = list.head1.next.next.next;
        // list.head2.next.next = new Node(30);
 
        System.out.println("The node of intersection is " + list.getNode());

        System.out.println("2 pointer method - "+list.getMeetingPoint());
    }
}