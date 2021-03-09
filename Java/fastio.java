import java.io.*;
import java.util.*;

public class fastio
{
	static class FastReader
	{
		BufferedReader br;
		StringTokenizer st;

		FastReader()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next()
		{
			while(st == null || !st.hasMoreElements())
			{
				try
				{
					st = new StringTokenizer(br.readLine());
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}

			return st.nextToken();
		}

		int nextInt()
		{
			return Integer.parseInt(next());
		}

		long nextLong()
		{
			return Long.parseLong(next());
		}

		double nextDouble()
		{
			return Double.parseDouble(next());
		}
		float nextFloat()
		{
			return Float.parseFloat(next());
		}
		String nextLine()
		{
			String str = "";
			try
			{
				str = br.readLine();
			}
			catch(IOException e)
			{
				e.printStackTrace();

			}

			return str;
		}

	}

	public static void main(String args[])throws IOException
	{
		FastReader fr = new FastReader();
		int n = fr.nextInt();


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		out.write(n+" - "+m+" - "+k);
		System.out.println("---------");
		System.out.println(n+"\n"+m+"\n"+k);
		out.flush();
	}
}