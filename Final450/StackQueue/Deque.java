import  java.io.*;
import java.util.*;

class Deque
{
	static class Node
	{
		int value;
		Node next;
		Node prev;
	}

	static class dequeSQ
	{
		private Node head, tail;

		public dequeSQ()
		{
			head = tail = null;
		}

		public boolean isEmpty()
		{
			if(head == null)
				return true;

			return false;
		}

		public int size()
		{
			Node temp = head;
			int len = 0;
			while(temp!=null)
			{
				len++;
				temp = temp.next;
			}

			return len;
		}

		public void insert_first(int data)
		{
			Node temp = new Node();

			if(!isEmpty())
			{
				temp.value = data;
				temp.next = head;
				head.prev = temp;
				temp.prev = null;
				head = temp;
			}
			else
			{
				temp.value = data;
				head = tail = temp;
				temp.next = temp.prev = null;
			}
		}
		public void insert_last(int data)
		{
			Node temp= new Node();
			temp.value = data;
			temp.next = null;
			if(!isEmpty())
			{
				tail.next = temp;
				temp.prev = tail;
				tail = temp;
			}
			else
			{
				head = tail = temp;
				temp.next = temp.prev = null;
			}
		}

		public int remove_first()
		{
			if(!isEmpty())
			{
				Node temp = head;
				head = head.next;
				head.prev = null;

				return temp.value;
			}
			else
			{
				return -1;
			}
		}
		public int remove_last()
		{
			if(!isEmpty())
			{
				Node temp = tail;
				tail = tail.prev;
				tail.next = null;

				return temp.value;
			}
			else
			{
				return -1;
			}
		}

		void display()
	    {
	         
	        // If list is not empty
	        if (!isEmpty())
	        {
	            Node temp = head;
	             
	            while (temp != null)
	            {
	                System.out.print(temp.value + " ");
	                temp = temp.next;
	            }
	 
	            return;
	        }
	        System.out.print("List is Empty");
	    }
	}

	static class Stack
	{
	    dequeSQ d = new dequeSQ();
	 
	    // push to push element at top of stack
	    // using insert at last function of deque
	    public void push(int element)
	    {
	        d.insert_last(element);
	    }
	 
	    // Returns size
	    public int size()
	    {
	        return d.size();
	    }
	     
	    // pop to remove element at top of stack
	    // using remove at last function of deque
	    public void pop()
	    {
	        d.remove_last();
	    }
	 
	    // Display
	    public void dispaly()
	    {
	        d.display();
	    }
	}
	 
	// Class to implement queue using deque
	static class Queue
	{
	    dequeSQ d = new dequeSQ();
	     
	    // enqueue to insert element at last
	    // using insert at last function of deque
	    public void enqueue(int element)
	    {
	        d.insert_last(element);
	    }
	 
	    // dequeue to remove element from first
	    // using remove at first function of deque
	    public void dequeue()
	    {
	        d.remove_first();
	    }
	 
	    // display
	    public void display()
	    {
	        d.display();
	    }
	     
	    // size
	    public int size()
	    {
	        return d.size();
	    }
	}
	 
	// Driver Code
	public static void main(String[] args)
	{
	     
	    // Object of Stack
	    Stack stk = new Stack();
	 
	    // push 7 and 8 at top of stack
	    stk.push(7);
	    stk.push(8);
	    System.out.print("Stack: ");
	    stk.dispaly();
	 
	    // For new line
	    System.out.println();
	     
	    // pop an element
	    stk.pop();
	    System.out.print("Stack: ");
	    stk.dispaly();
	 
	    // For new line
	    System.out.println();
	 
	    // Object of Queue
	    Queue que = new Queue();
	 
	    // Insert 12 and 13 in queue
	    que.enqueue(12);
	    que.enqueue(13);
	    System.out.print("Queue: ");
	    que.display();
	 
	    // New line
	    System.out.println();
	     
	    // Delete an element from queue
	    que.dequeue();
	    System.out.print("Queue: ");
	    que.display();
	 
	    // New line
	    System.out.println();
	    System.out.println("Size of stack is " +
	                       stk.size());
	    System.out.println("Size of queue is " +
	                       que.size());
	}
}