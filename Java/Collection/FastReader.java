import java.util.*;
import java.io.*;

class FastReader
{
	BufferedReader br;
	StringTokenizer st;
	public FastReader()
	{
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next()
	{
		while(st==null || !st.hasMoreTokens())
		{
			try
			{
				st = new StringTokenizer(br.readLine());

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		return st.nextToken();
	}

	String nextLine()
	{
		String str = "";
		try
		{
			str = br.readLine();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return str;
	}

	long nextLong()
	{
		return Long.parseLong(next());
	}
	int nextInt()
	{
		return Integer.parseInt(next());
	}
	double nextDouble()
	{
		return Double.parseDouble(next());
	}

	float nextFloat()
	{
		return Float.parseFloat(next());
	}
}