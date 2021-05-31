import java.io.*;
import java.util.*;

public class palinPartition
{
	public static boolean isPalindrome(String s)
	{
		int l = 0, r = s.length()-1;
		while(l<r)
		{
			char i = s.charAt(l);
			char j = s.charAt(r);

			if(i!=j)
				return false;

			l++;
			r--;
		}

		return true;
	}

	public static void solution(String ques, String ansf)
	{
		if(ques.length() == 0)
		{
			System.out.println(ansf);
			return;
		}

		for(int i = 0;i<ques.length();i++)
		{
			String prefix = ques.substring(0, i+1);
			String ros = ques.substring(i+1);

			if(isPalindrome(prefix))
			{
				solution(ros, ansf+"("+prefix+")");
			}
		}
	}

	public static void main(String args[])
	{
		solution("nitin","");
	}
}