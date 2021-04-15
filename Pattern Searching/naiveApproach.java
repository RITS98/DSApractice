import java.util.*;
import java.io.*;

public class naiveApproach
{
	public static void search(String text, String patt)
	{
		int n = text.length(), m = patt.length();

		for(int i = 0;i<n-m;i++)
		{
			String sub = text.substring(i, i+m);
			if(sub.equalsIgnoreCase(patt))
				System.out.println(i);
		}
	}

	public static void main(String args[])
	{
		String txt = "AABAACAADAABAAABAA";
        String pat = "AABA";
        search(txt, pat);
	}
}