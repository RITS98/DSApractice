import java.io.*;
import java.util.*;
import java.util.Map.*;

public class checkAnagram
{
	public static boolean check(String s1, String s2)
	{
		int c[] = new int[256];

		for(char i:s1.toCharArray())
			c[i]++;

		for(char i:s2.toCharArray())
			c[i]--;


		for(int i:c)
			if(i!=0)
				return false;

		return true;

	}

	public static void main(String args[])
	{
		System.out.println(check("LISTEN", "SILENT"));
		System.out.println(check("TRIANGLE","INTEGRAL"));
		System.out.println(check("GEEKS","KEGS"));
	}
}
