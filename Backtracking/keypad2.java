import java.io.*;
import java.util.*;

public class keypad2
{

	static String keypad[] = {".?","abc","def","ghi","jkl","mno","pqr","stu","vw","xyz"};

	public static void printWords(String ques, String ans)
	{
		if(ques.length() == 0)
		{
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String ros = ques.substring(1);

		String comb = keypad[ch-'0'];

		for(int i = 0;i<comb.length();i++)
		{
			char d = comb.charAt(i);
			printWords(ros, ans + d);
		}
	}

	public static void main(String args[])
	{
		String nos = "573";
		printWords(nos, "");
		
	}
}