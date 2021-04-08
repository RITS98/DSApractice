/*

Given a string with brackets. If the start index of the open bracket is given, find the index of the closing bracket.

Examples:

Input : string = [ABC[23]][89]
        index = 0
Output : 8
The opening bracket at index 0 corresponds
to closing bracket at index 8.

*/


import java.io.*;
import java.util.*;
import java.util.stream.*;

public class findCloseBracket
{
	public static void find(String str, int k)
	{


		Stack<Integer> st = new Stack<>();
		int l = str.length();

		if(k>=l)
		{
			System.out.println(-1);
			return;
		}

		for(int i =0;i<l;i++)
		{
			char c = str.charAt(i);

			if(c == '[')
				st.push(i);
			else if(c==']')
			{
				int num = st.pop();
				if(num == k)
				{
					System.out.println(i);
					return;
				}	
			}
			else
				continue;
		}

		System.out.println(-1);
		return;
	}

	public static void main(String[] args) {
        find("[ABC[23]][89]", 0); // should be 8 
        find("[ABC[23]][89]", 4); // should be 7 
        find("[ABC[23]][89]", 9); // should be 12 
        find("[ABC[23]][89]", 1); // No matching bracket 
        find("[ABC[23]][89]", 8);
    }


}
