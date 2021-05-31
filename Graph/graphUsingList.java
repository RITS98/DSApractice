import java.io.*;
import java.util.*;

public class graphUsingList
{
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int src, int v)
	{
		adj.get(src).add(v);
		adj.get(v).add(src);
	}

	public static void printGraph(ArrayList<ArrayList<Integer>> adj)
	{
		System.out.println("Adjacency List - ");
		for(int i = 0;i< adj.size();i++)
		{
			//int va = adj.get(i).get(0);
			System.out.print(i+" : ");
			for(int j = 0;j<adj.get(i).size();j++)
				System.out.print(adj.get(i).get(j) + " ");

			System.out.println();
		}
	}

	public static void main(String args[])
	{
		int V = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i = 0;i<V;i++)
		{
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
         
        printGraph(adj);

	}
}