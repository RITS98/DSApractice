/*

Given a queue, write a recursive function to reverse it.
Standard operations allowed :
enqueue(x) : Add an item x to rear of queue.
dequeue() : Remove an item from front of queue.
empty() : Checks if a queue is empty or not.

Examples :

Input : Q = [5, 24, 9, 6, 8, 4, 1, 8, 3, 6]
Output : Q = [6, 3, 8, 1, 4, 8, 6, 9, 24, 5]

Explanation : Output queue is the reverse of the input queue.

Input : Q = [8, 7, 2, 5, 1]
Output : Q = [1, 5, 2, 7, 8]
Recursive Algorithm :

The pop element from the queue if the queue has elements otherwise return empty queue.
Call reverseQueue function for the remaining queue.
Push the popped element in the resultant reversed queue.

*/

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class revQueueRecur
{
	public static void print(Queue<Integer> q)
	{
		while(!q.isEmpty())
		{
			System.out.print(q.peek()+" ");
			q.remove();
		}
		System.out.println();
	}
	public static Queue<Integer> reverse(Queue<Integer> q)
	{
		if(!q.isEmpty())
		{
			int no = q.peek();
			q.remove();

			q = reverse(q);

			q.add(no);
		}

		return q;
		
	}

	public static void main(String args[])
	{
	    Queue<Integer> queue = new LinkedList<Integer>();
	    queue.add(56);
	    queue.add(27);
	    queue.add(30);
	    queue.add(45);
	    queue.add(85);
	    queue.add(92);
	    queue.add(58);
	    queue.add(80);
	    queue.add(90);
	    queue.add(100);
	    queue = reverse(queue);
	    print(queue);
	}
}