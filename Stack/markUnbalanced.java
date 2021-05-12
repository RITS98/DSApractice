import java.io.*;
import java.util.*;

public class markUnbalanced
{
	public static void mark(StringBuffer a)
	{
		Stack<Integer> st = new Stack<>();

		for(int i = 0; i<a.length(); i++)
		{
			char c = a.charAt(i);

			if(c == '(')
				st.push(i);
			else if(c == ')')
			{
				if(st.isEmpty())
					a.replace(i, i+1,"-1");

				else
				{
					a.replace(i,i+1,"1");
					a.replace(st.peek(), st.peek()+1,"0");
					st.pop();
				}
			}

		}

		while(!st.isEmpty())
		{
			a.replace(st.peek(),1,"-1");
			st.pop();
		}

		System.out.println(a);
	}

	public static void main(String[] args)
	{
	    StringBuffer str = new StringBuffer("(((abc))((d)))))");
	    mark(str);
	}
}