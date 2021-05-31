import java.util.*;
import java.io.*;

public class DFS
{
	int V;
	LinkedList<Integer> adj[];

	DFS(int V)
	{
		this.V = V;
		adj = new LinkedList[V];
		for(int i = 0;i<V;i++)
			adj[i] = new LinkedList();
	}

	void addEdge(int src, int dest)
	{
		adj[src].add(dest);
	}

	void dfsUtil(int v, boolean visited[])
	{
		visited[v] = true;
		System.out.print(v+" ");

		Iterator<Integer> it = adj[v].iterator();
		while(it.hasNext())
		{
			int n = it.next();
			if(!visited[n])
				dfsUtil(n, visited);
		}
	}

	void dfs()
	{
		boolean visited[] = new boolean[V];

		for(int i = 0;i<V;i++)
		{
			if(!visited[i])
				dfsUtil(i, visited);
		}
	}

	public static void main(String args[])
    {
       	DFS g = new DFS(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println(
            "Following is Depth First Traversal");
 
        g.dfs();
    }
}