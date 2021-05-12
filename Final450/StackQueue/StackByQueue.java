//Implement Stack using Queues

import java.io.*;
import java.util.*;

class StackByQueue
{
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	int curr_size;

	StackByQueue()
	{
		curr_size = 0;
	}
	public void insert(int data)
	{
		q1.add(data);
		curr_size++;
	}
	public int remove()
	{
		if(q1.isEmpty())
			return -1;

		while(q1.size()!=1)
		{
			q2.add(q1.remove());
		}

		int val = q1.remove();

		curr_size --;

		Queue<Integer> q = q1;

		q1 = q2;
		q2 = q;

		return val;
	}

	public int currentSize()
	{
		return curr_size;
	}

	public static void main(String[] args)
    {
        StackByQueue s = new StackByQueue();
        s.insert(1);
        s.insert(2);
        s.insert(21);
        s.insert(22);
  
        System.out.println("current size: " + s.currentSize());
        System.out.println(s.remove());
        System.out.println(s.remove());
        System.out.println("current size: " + s.currentSize());
    }
}