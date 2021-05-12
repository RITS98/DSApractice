import java.io.*;
import java.util.*;

class Celebraity
{
	static int matrix[][] = { { 0, 0, 1, 0 },
                            { 0, 0, 1, 0 },
                            { 0, 0, 0, 0 },
                            { 0, 0, 1, 0 } };
	public static boolean Knows(int a, int b)
	{
		return matrix[a][b] == 1?true:false;
	}

	public static int find(int n)
	{
		Stack<Integer> st = new Stack<>();
		for(int i = 0;i<n;i++)
			st.push(i);

		while(st.size()>1)
		{
			int i = st.pop();
			int j = st.pop();

			if(Knows(i,j))
			{
				st.push(j);
			}
			else
				st.push(i);
		}

		

		if(st.isEmpty())
			return -1;

		int c = st.pop();

		for(int i =0;i<n;i++)
		{
			if(i!=c && matrix[c][i] == 1)
				return -1;
		}

		return c;
	}

	public static void main(String[] args)
    {
        int n = 4;
        int result = find(n);
        if (result == -1)
        {
            System.out.println("No Celebrity");
        }
        else
            System.out.println("Celebrity ID " + result);
    }
}