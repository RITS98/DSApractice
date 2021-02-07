import java.util.*;
public class linked
{
    Node head;
    class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            next=null;
        }
    }

    //Add node at front
    //Time complexity O(1)
    public void push(int data)
    {
        Node newNode =new Node(data);

        newNode.next = head;
        head=newNode;
    }
    //Insert after a node O(1)

    public void insertAfter(Node prevNode, int data)
    {
        if(prevNode == null)
        {
            System.out.println("The previous node can't be null");
            return;
        }

        Node newNode = new Node(data);
        newNode.next=prevNode.next;
        prevNode.next=newNode;
    }

    //Insert at last O(n)
    public void append(int data)
    {
        Node newNode = new Node(data);

        if( head == null)
        {
            head = newNode;
            return;
        }

        newNode.next = null;
        Node last = head;
        while( last.next != null)
        {
            last = last.next;
        }

        last.next = newNode;
        return;
    }

    //Printing the Linked List
    public void printList()
    {
        Node n = head;
        while( n.next != null )
        {
            System.out.print( n.data + " - > " );
            n = n.next;
        }
        System.out.print(n.data);
    }

    //To delete a node when data is passed
    public void deleteNode(int key)
    {
        Node temp = head;
        if(temp != null && temp.data == key)
        {
            head = temp.next;
            return;
        }

        Node prev=null;
        
        while(temp != null && temp.data != key)
        {
            prev = temp;
            temp = temp.next;
        }

        if(temp == null)
        return;

        prev.next = temp.next;
    }
    
}