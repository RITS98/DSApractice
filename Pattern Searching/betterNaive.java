import java.io.*;
import java.util.*;
import java.util.stream.*;

public class betterNaive
{
	public static void search(String text, String patt)
	{
		int N = text.length();
		int M = patt.length();

		int i = 0;
		while(i <= N-M)
		{
			int j;

			for(j = 0;j<M;j++)
			{
				if(text.charAt(i+j)!=patt.charAt(j))
					break;
			}

			if(j == M)
			{
				System.out.println("Position Of Match " + (i));
				i++;
			}	
			else if(j == 0)
				i++;
			else
				i = i+j;
		}
	}

	public static void main(String args[])
	{
		String txt = "ABCEABCDABCEABCD"; 
	    String pat = "ABCD"; 
	    search(txt, pat);
	    System.out.println();
	    txt = "ABABABABABAB";
	    pat = "ABABAB";
	    search(txt, pat);
	}
}