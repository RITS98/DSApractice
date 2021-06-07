//if the graph is connected in Graphs in data stucture in Java.

import java.io.*;
import java.util.*;

public class isConnected
{
	public static void drawTree(Arraylist<Edge> graph[], int src, Arraylist<Integer> comp, boolean visited[])
	{
		visited[src] = true;
		comp.add(src);

		for(Edge e: graph(src))
		{
			if(!visited[e.nbr])
			{
				drawTree(graph, e.nbr, comp, visited);
			}
		}

	}

	public static void main(String args[])
	{
		Arraylist<Arraylist<Integer>> comps = new ArrayList<>();
		boolean visited[] = new boolean[N];
		for(int v = 0;v< N; v++)
		{
			if(!visited[v])
			{
				Arraylist<Integer> comp = new ArrayList<>();
				drawTree(graph, v, comp, visited);
				comps.add(comp);
			}
		}

		System.out.println(comps.size() == 1);
	}
}