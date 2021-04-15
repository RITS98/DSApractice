//https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/

import java.io.*;
import java.util.*;
import java.util.stream.*;


public class anagramSubstringSearch
{
	static int MAX = 256;
	public static boolean compare(char c1[], char c2[])
	{
		for(int i = 0;i<MAX;i++)
			if(c1[i]!=c2[i] )
				return false;

			return true;

	}

	public static void search(String text, String patt)
	{
		int M = patt.length();
		int N = text.length();
		char countP[] = new char[MAX];
		char countTX[] = new char[MAX];

		for(int i = 0;i<M;i++)
		{
			countP[patt.charAt(i)]++;
			countTX[text.charAt(i)]++;
		}

		for(int i = M;i<N;i++)
		{
			if(compare(countP, countTX))
				System.out.println("Position - "+(i-M));

			countTX[text.charAt(i)]++;
			countTX[text.charAt(i-M)]--;
		}

		if(compare(countP, countTX))
			System.out.println("Postion - "+(N-M));
	}

	public static void main(String args[])
    {
        String txt = "BACDGABCDA";
        String pat = "ABCD";
        search(txt, pat);
    }
}