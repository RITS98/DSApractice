/*

Given a sequence of n strings, the task is to check if any two similar words come together then they destroy each other then print the number of words left in the sequence after this pairwise destruction.

Examples:

Input : ab aa aa bcd ab
Output : 3
As aa, aa destroys each other so, ab bcd ab is the
new sequence.

Input :  tom jerry jerry tom
Output : 0
As first both jerry will destroy each other.
Then sequence will be tom, tom they will also destroy
each other. So, the final sequence doesn't contain any
word.

*/


import java.io.*;
import java.util.*;
import java.util.stream.*;

public class delConsecutiveSameWords
{
	public static int delete(String sentence)
	{
		String words[] = sentence.split("\\s+");

		Stack<String> st = new Stack<String>();

		st.push(words[0]);

		for(int i =1;i<words.length;i++)
		{
			String s= st.peek();
			if(s.equalsIgnoreCase(words[i]))
			{
				st.pop();
			}
			else
			{
				st.push(words[i]);
			}
		}

		int size = st.size();

		return size;
	}
	public static void main(String args[])
	{
		String sentence = "tom jerry jerry tom";
		System.out.println(delete(sentence));

		sentence = "ab aa aa bcd ab";
		System.out.println(delete(sentence));

	}
}