import java.util.*;
import java.io.*;

public class mColour
{
	final int V = 4;
	int colour[];

	public boolean isSafe(int v, int colour[], int graph[][], int c)
	{
		for(int i = 0;i<V;i++)
		{
			if(graph[v][i] == 1 && c == colour[i])
				return false;
		}

		return true;
	}

	boolean graphColourUtil(int m, int graph[][], int colour[], int v)
	{
		if(v == V)
			return true;

		for(int c = 1;c<=m;c++)
		{
			if(isSafe(v, colour, graph, c))
			{
				colour[v] = c;

				if(graphColourUtil(m, graph, colour, v+1))
					return true;

				colour[v] = 0;
			}
		}

		return false;
	}

	boolean gColour(int graph[][], int m)
	{
		colour = new int[V];
		Arrays.fill(colour, 0);

		if(!graphColourUtil(m, graph, colour, 0))
		{
			System.out.println("No solution");
			return false;
		}

		System.out.println(Arrays.toString(colour));
		return true;
	}

	public static void main(String args[])
	{
		 mColour Coloring = new mColour();

		 int graph[][] = {
            { 0, 1, 1, 1 },
            { 1, 0, 1, 0 },
            { 1, 1, 0, 1 },
            { 1, 0, 1, 0 },
        };
        int m = 3; // Number of colors
        Coloring.gColour(graph, m);
	}
}