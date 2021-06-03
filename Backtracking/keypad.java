import java.io.*;
import java.util.*;

public class keypad
{

	static String keypad[] = {".?","abc","def","ghi","jkl","mno","pqr","stu","vw","xyz"};

	public static ArrayList<String> getWords(String nos)
	{
		if(nos.length() == 0)
		{
			ArrayList<String> empty = new ArrayList<>();
			empty.add("");
			return empty;
		}

		char ch = nos.charAt(0);
		String ros = nos.substring(1);

		ArrayList<String> getRes = getWords(ros);
		ArrayList<String> myRes = new ArrayList<>();
		for(int i = 0;i<keypad[ch-'0'].length();i++)
		{
			char d = keypad[ch-'0'].charAt(i);
			for(String j:getRes)
			{
				myRes.add(d + j);
			}
		}

		return myRes;

	}

	public static void main(String args[])
	{
		String nos = "573";
		ArrayList<String> res = getWords(nos);
		System.out.println(res);
	}
}