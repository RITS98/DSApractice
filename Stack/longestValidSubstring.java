/*

Given a string consisting of opening and closing parenthesis, find the length of the longest valid parenthesis substring.

Examples: 

Input : ((()
Output : 2
Explanation : ()

Input: )()())
Output : 4
Explanation: ()() 

Input:  ()(()))))
Output: 6
Explanation:  ()(())

*/

//https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/

import java.util.*;
import java.util.stream.*;
import java.io.*;

public class longestValidSubstring
{
	public static int findLongest(String str)
	{
		int maxlength = 0;
		int l = str.length();
		int store_len = 0;
		int curr_len = 0;
		Stack<Integer> st = new Stack<>();
		st.push(-1);

		for(int i = 0;i<l;i++)
		{
			char c = str.charAt(i);
			if(c=='(')
				st.push(i);

			if(c == ')')
			{
				if(!st.isEmpty())
					st.pop();
				if(!st.isEmpty())
				{
					maxlength = Math.max(maxlength, i - st.peek());
				}
				else
					st.push(i);
			}
		}

		return maxlength;
	}

	//Without stack
	public static int findMaxLen(String str)
	{
		int maxlength = 0;

		int left = 0, right = 0;

		for(int i =0;i<str.length();i++)
		{
			char c = str.charAt(i);
			if(c=='(')
				left++;
			else if(c == ')')
				right++;

			if(left == right)
				maxlength = Math.max(maxlength, 2*right);
			else if(right > left)
				left = right = 0;
		}

		left = right = 0;

		for(int i = str.length() -1;i>=0;i--)
		{
			char c = str.charAt(i);
			if(c=='(')
				left++;
			else if(c == ')')
				right++;

			if(left == right)
				maxlength = Math.max(maxlength, 2*left);
			else if(right < left)
				left = right = 0;
		}


		return maxlength;
	}

	public static void main(String[] args)
    {
        String str = "((()()";
       
        // Function call
        System.out.println(findLongest(str));
        System.out.println(findMaxLen(str));
 
        str = "()(()))))";
       
        // Function call
        System.out.println(findLongest(str));
        System.out.println(findMaxLen(str));
    }
}