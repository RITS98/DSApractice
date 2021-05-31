import java.util.*;
import java.io.*;

class BFS
{
	int V;
	LinkedList<Integer> adj[];

	BFS(int V)
	{
		this.V = V;
		for(int i = 0;i<V;i++)
			adj[i] = new LinkedList();
	}

	void addEdge(int src, int dest)
	{
		adj[src].add(dest);
	}

	void bfs(int s)
	{
		boolean visited[] = new boolean[V];
		LinkedList<Integer> q = new LinkedList<Integer>();

		visited[s] = true;
		q.add(s);

		while(q.size()!=0)
		{
			s = q.poll();
			System.out.println(s+" ");

			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext())
			{
				int n = i.next();
				if(!visited[n])
				{
					visited[n] = true;
					q.add(n);
				}
			}
		}
	}

	public static void main(String args[])
	{
		BFS g = new BFS(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.bfs(2);
	}
}
