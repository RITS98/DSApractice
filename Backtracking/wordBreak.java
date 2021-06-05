import java.io.*;
import java.util.*;

public class wordBreak
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashSet<String> dict = new HashSet<String>();

		for(int i = 0;i<n;i++)
		{
			dict.add(sc.nextLine());

		}

		String str = sc.nextLine();
		findWords(str, "", dict);

	}

	public static void findWords(String str, String ans, HashSet<String> dict)
	{
		if(str.length() == 0)
		{
			System.out.println(ans);
			return;
		}

		for(int i = 0;i<str.length();i++)
		{
			String left = str.substring(0, i+1);
			if(dict.contains(left))
			{
				String right = str.substring(i+1);
				findWords(right, ans+left+" ", dict);
			}
		}
	}
}