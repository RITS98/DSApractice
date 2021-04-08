/*
Algorithm for Prefix to Postfix: 

Read the Prefix expression in reverse order (from right to left)
If the symbol is an operand, then push it onto the Stack
If the symbol is an operator, then pop two operands from the Stack 
Create a string by concatenating the two operands and the operator after them. 
string = operand1 + operand2 + operator 
And push the resultant string back to Stack
Repeat the above steps until end of Prefix expression.

*/

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class PreToPos
{
public static boolean isOperand(char c)
{
	return ((c>='a' && c<='z') || (c>='A' && c<='Z'));
}
public static String createPrefix(String pre)
{
	int l = pre.length();
	Stack<String> st = new Stack<>();
	for(int i = l-1;i>=0;i--)			//<----------
	{
		char c = pre.charAt(i);
		if(isOperand(c))
		st.push(c+"");
		else
		{
			String op1 = st.pop();
			String op2 = st.pop();

			String temp = op1+op2+c;

			st.push(temp);
		}
	}

	return st.pop();

}


public static void main(String args[])
{
	String x = "*-A/BC-/AKL";
	System.out.println(createPrefix(x));

}

}
