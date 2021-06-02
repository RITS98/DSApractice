import java.io.*;
import java.util.*;

public class subsequence2
{
	public static void printSS(String ques, String ans)
	{
		if(ques.length() == 0)
		{
			System.out.println(ans);
			return;
		}

		char c = ques.charAt(0);
		String ros = ques.substring(1);

		printSS(ros, ans+"");
		printSS(ros, ans+c);
	}

	public static void main(String args[])
	{
		String str = "abc";
		printSS(str, "");
	}
}