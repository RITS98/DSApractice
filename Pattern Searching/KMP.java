//https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/

//https://www.youtube.com/watch?v=V5-7GzOfADQ

//KMP (Knuth Morris Pratt) Pattern Searching

public class KMP
{
	public static void search(String text, String patt)
	{
		int M = patt.length();
		int N = text.length();

		int j = 0;
		int lps[] = new int[M];

		computeLPSArray(patt, M, lps);

		int i = 0;
		while(i<N)
		{
			if(patt.charAt(j) == text.charAt(i))
			{
				i++;
				j++;
			}
			if(j == M)
			{
				System.out.println("Position of Match "+(i-j));
				j=lps[j-1];
			}
			else if(i<N && patt.charAt(j) != text.charAt(i))
			{
				if(j!=0)
					j = lps[j-1];
				else
					i = i+1;
			}

		}

	}

	public static void computeLPSArray(String patt, int M, int lps[])
	{
		int len = 0;
		int i = 1;
		lps[0] = 0;

		while(i<M)
		{
			if(patt.charAt(i) == patt.charAt(len))
			{
				len++;
				lps[i] = len;
				i++;
			}
			else
			{
				if(len!=0)
				{
					len = lps[len - 1];
				}
				else
				{
					lps[i] = len;
					i++;
				}
			}
		}
	}

	public static void main(String args[])
	{
		String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        search(txt, pat);
	}
}