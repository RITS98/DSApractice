import java.io.*;
import java.util.*;
import java.util.stream.*;

public class reverseQueue
{

	static Queue<Integer> q;
	public static void reversequeue()
	{
		Stack<Integer> st = new Stack<>();
		while(!q.isEmpty())
		{
			st.push(q.peek());
			q.remove();
		}

		while(!st.isEmpty())
		{
			q.add(st.pop());
		}
	}

	public static void Print()
	{
		while(!q.isEmpty())
		{
			System.out.print(q.peek()+" ");
			q.remove();

		}
		System.out.println();
	}
	public static void main(String args[])
	{
		q = new LinkedList<Integer>();
		q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);
  		
  		//Print();
        reversequeue();
        Print();
	}

}