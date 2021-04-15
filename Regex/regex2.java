import java.io.*;
import java.util.*;
import java.util.regex.*;

public class regex2
{
	public static void main(String args[])
	{
		String text = "John writes about this, and John writes about that," + " and John writes about everything.";
		String pattern = "(John)";

		Pattern p1 = Pattern.compile(pattern);
		Matcher m1 = p1.matcher(text);

		while(m1.find())
		{
			System.out.println("Found : "+ m1.group(1));
		}

		ArrayList<String> al = new ArrayList<>();
		al.add("123-45-6789");
		al.add("9876-5-4321");
		al.add("987-65-4321 (attack)");
		al.add("987-65-4321");
		al.add("192-83-7465");

		String patt = "^(\\d{3}-?\\d{2}-?\\d{4})$";
		Pattern p2 = Pattern.compile(patt);
		System.out.println("-----------------------");
		for(String ss : al)
		{
			Matcher m2 = p2.matcher(ss);
			if(m2.matches())
			{
				System.out.println("Found SSN :- "+ss);
			}
		}

		text = "I have a kindle, but I like to read book better.";

		Pattern p3 = Pattern.compile("(kindle|read|book|wolf|bear)");
		Matcher m3 = p3.matcher(text);
		System.out.println("-----------------------");
		while(m3.find())
		{
			System.out.println("Found :- "+ m3.group());
		}

		String input = "User userId=23421. Some more userId=33432. This is userNum=100";
		Pattern p4 = Pattern.compile("(userId=)(\\d+)");
		Matcher m4 = p4.matcher(input);
		StringBuffer result = new StringBuffer();
		System.out.println("-----------------------");
		while(m4.find())
		{
			System.out.println("Masking := "+m4.group(2));
			m4.appendReplacement(result, m4.group(1)+"***masked***");
	
		m4.appendTail(result);
		System.out.println(result);

		input = "I have a cat, dog, mat, cas and rat";
		Pattern p5 = Pattern.compile("(c|d|r|m)[a][ts]");
		Matcher m5 = p5.matcher(input);
		System.out.println("-----------------------");
		while(m5.find())
		{
			System.out.println("Found: - "+m5.group());
		}
	}
}