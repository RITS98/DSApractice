import java.io.*;
import java.util.*;

public class LLbinarySearch
{
	static class Node
	{
		int key;
		Node next;
		Node(int key)
		{
			this.key = key;
			next = null;
		}
	}
	static Node push(Node head, int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return head;
    }
    static Node middleNode(Node start, Node last)
    {
    	if(start == null)
    		return null;

    	Node slow = start;
    	Node fast = start.next;
    	while(fast!=last)
    	{
    		fast = fast.next;
    		if(fast!=last)
    		{
    			slow = slow.next;
    			fast = fast.next;
    		}
    	}
    	return slow;
    }
    static Node binarySearch(Node head, int value)
    {
    	Node start = head;
    	Node last = null;
    	do
    	{
    		Node mid = middleNode(start, last);
    		if(mid == null)
    			return null;
    		if(mid.key == value)
    			return mid;
    		else if(mid.key > value)
    			start = mid.next;
    		else
    			last = mid;
    	}while(last!=null || start!=last);

    	return null;
    }
    public static void main(String[] args) 
    {
        Node head = null;
  
        // Using push() function to
        // convert singly linked list
        // 10 -> 9 -> 8 -> 7 -> 4 -> 1
        head = push(head, 1);
        head = push(head, 4);
        head = push(head, 7);
        head = push(head, 8);
        head = push(head, 9);
        head = push(head, 10);
        int value = 7;
  
        if (binarySearch(head, value) == null)
        {
            System.out.println("Value not present");
        } 
        else
        {
            System.out.println("Present");
        }
    }
}