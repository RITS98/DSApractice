/*

We are given a string having parenthesis like below 
     “( ((X)) (((Y))) )” 
We need to find the maximum depth of balanced parenthesis, like 4 in the above example. Since ‘Y’ is surrounded by 4 balanced parentheses. 
If parenthesis is unbalanced then return -1. 

Examples : 

Input : S = "( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";
Output : 4

Input : S = "( p((q)) ((s)t) )";
Output : 3

Input : S = "";
Output : 0

Input : S = "b) (c) ()";
Output : -1 

Input : S = "(b) ((c) ()"
Output : -1 


*/


import java.io.*;
import java.util.*;
import java.util.stream.*;


public class maxDepthParenthesis
{
	public static int maxDepth(String str)
	{
		int max_depth = 0;
		int current_depth = 0;

		for(int i = 0;i<str.length();i++)
		{
			char c = str.charAt(i);

			if(c=='(')
			{
				current_depth+=1;
				if(current_depth> max_depth)
					max_depth = current_depth;
			}
			else if(c == ')')
			{
				current_depth -=1;
			}

			if(current_depth<0)
			{
				return -1;
			}
		}


		return current_depth==0?max_depth:-1;
	}

	public static int maxDepthUsingStack(String str)
	{
		int max_depth = 0;
		Stack<Character> st = new Stack<>();
		for(int  i =0;i<str.length();i++)
		{
			char c = str.charAt(i);

			if(c=='(')
			{
				st.push(c);
				if(st.size()>max_depth)
					max_depth = st.size();
			}
			else if(c==')')
			{
				if(st.isEmpty())
					return -1;
				else
					st.pop();
			}
		}

		return st.size()==0?max_depth:-1;
	}

	public static void main(String args[])
	{
		String s = "( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";
		System.out.println(maxDepth(s)+" "+maxDepthUsingStack(s));

		 s = "( p((q)) ((s)t) )";
		System.out.println(maxDepth(s)+" "+maxDepthUsingStack(s));

		 s = "";
		System.out.println(maxDepth(s)+" "+maxDepthUsingStack(s));

		 s = "b) (c) ()";
		System.out.println(maxDepth(s)+" "+maxDepthUsingStack(s));

		s = "(b) ((c) ()";
		System.out.println(maxDepth(s)+" "+maxDepthUsingStack(s));


	}

}