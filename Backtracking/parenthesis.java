/*

the Remove Invalid Parenthesis problem using stacks and backtracking Java. In this problem:

1. You are given a string, which represents an expression having only opening and closing parenthesis.
2. You have to remove minimum number of parenthesis to make the given expression valid.
3. If there are multiple answers, you have to print all of them.

*/

import java.io.*;
import java.util.*;

public class parenthesis
{
	public static void solution(String str, int mra, HashSet<String> ans)
	{
		if(mra == 0)
		{
			int mrnow = getMin(str);
			if(mrnow == 0)
			{
				if(!ans.contains(str))
				{
					System.out.println(str);
					ans.add(str);
				}
			}

			return;
		}

		for(int i = 0;i<str.length();i++)
		{
			String left = str.substring(0, i);
			String right = str.substring(i+1);
			solution(left+right, mra - 1, ans);
		}
	}

	public static int getMin(String str)
	{
		Stack<Character> st = new Stack<>();

		for(int i =0 ;i<str.length();i++)
		{
			char ch = str.charAt(i);
			if(ch == '(')
				st.push(ch);
			else if(ch == ')')
			{
				if(st.size() == 0)
					st.push(ch);
				else if(st.peek() == ')')
					st.push(ch);
				else if(st.peek() == '(')
					st.pop();
			}

		}
		return st.size();
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println("Answer ---> ");
		solution(str, getMin(str), new HashSet<>());
	}
}