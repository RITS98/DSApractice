import java.io.*;
import java.util.*;

class StackPermutation
{
	public static boolean findPermutation(int inp[], int out[])
	{
		if(inp.length != out.length)
			return false;
		Queue<Integer> input = new LinkedList<>(Arrays.asList(inp));
		Queue<Integer> output = new LinkedList<>(Arrays.asList(out));

		Stack<Integer> st = new Stack<>();
		while(!input.isEmpty())
		{
			int ele = input.poll();
			if(ele == output.peek())
			{
				output.poll();
				while(!st.isEmpty())
				{
					if(st.peek() == output.peek())
					{
						st.pop();
						output.poll();
					}
					else
					{
						break;
					}
				}
			}
			else
			{
				st.push(ele);
			}
		}

		return (input.isEmpty() && output.isEmpty());
	}

	public static void main(String args[])
	{
		int inp[] = {1,2,3};
		int out[] = {2,3,1};

		System.out.println(findPermutation(inp, out));
	}
}