import java.io.*;
import java.util.*;

public class eulerian
{
	private int V;
	private LinkedList<Integer> adj[];

	eulerian(int v)
	{
		V = v;
		adj = new LinkedList[V];
		Arrays.fill(adj, new LinkedList());
	}

	void addEdge(int src, int nbr)
	{
		adj[src].add(nbr);
		adj[nbr].add(src);
	}

	void DFSUtil(int v, boolean visited[])
	{
		visited[v] = true;

		Iterator<Integer> it = adj[v].listIterator();
		while(it.hasNext())
		{
			int n = it.next();
			if(!visited[n])
				DFSUtil(n, visited);
		}
	}

	boolean isConnected()
	{
		boolean visited[] = new boolean[V];
		Arrays.fill(visited, false);
		int i;
		for(i = 0;i<V;i++)
		{
			if(adj[i].size() != 0)
				break;
		}

		if(i == V)
			return true;

		DFSUtil(i, visited);

		for(i = 0;i<V;i++)
		{
			if(visited[i] == false && adj[i].size() > 0)
				return false;
		}

		return true;
	}

	int isEuclerian()
	{
		if(isConnected() == false)
			return 0;

		int odd = 0;
		for(int i = 0;i<V;i++)
		{
			if(adj[i].size()%2!=0)
				odd++;
		}

		if(odd > 2)
			return 0;

		return odd == 2? 1:2;
	}

	void test()
    {
        int res = isEuclerian();
        if (res == 0)
            System.out.println("graph is not Eulerian");
        else if (res == 1)
            System.out.println("graph has a Euler path");
        else
           System.out.println("graph has a Euler cycle");
    }
  
    // Driver method
    public static void main(String args[])
    {
        
        eulerian g1 = new eulerian(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.test();
  
        eulerian g2 = new eulerian(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        g2.addEdge(4, 0);
        g2.test();
  
        eulerian g3 = new eulerian(5);
        g3.addEdge(1, 0);
        g3.addEdge(0, 2);
        g3.addEdge(2, 1);
        g3.addEdge(0, 3);
        g3.addEdge(3, 4);
        g3.addEdge(1, 3);
        g3.test();
  
        
        eulerian g4 = new eulerian(3);
        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(2, 0);
        g4.test();
  
        
        eulerian g5 = new eulerian(3);
        g5.test();
    }
}