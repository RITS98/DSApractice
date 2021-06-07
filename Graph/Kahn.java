// Kahn's algorithm 	Iterative Toplogical Sort
import java.io.*;
import java.util.*;

class Kahn
{
	public static int[] findOrder(int n, ArrayList<ArrayList<Integer>> graph)
	{
		int[] indegree = new int[n];
		int[] ans = new int[n];

		for(int i = 0;i<n;i++)
		{
			for(int nbr : graph.get(i))
			{
				indegree[nbr]++;
			}
		}
	

		LinkedList<Integer> q = new LinkedList<>();
		for(int i = 0;i<n;i++)
		{
			if(indegree[i] == 0)
			{
				q.addLast(i);
			}
		}

		int idx = 0;

		while(q.size()>0)
		{
			int rem = q.removeFirst();
			ans[idx] = rem;
			idx++;

			for(int nbrs: graph.get(rem))
			{
				indegree[nbrs]--;

				if(indegree[nbrs] == 0)
				q.addLast(nbrs);
			}
		}

		if(idx == n)
		{
			return ans;
		}
		else
		{
			return new int[]{-1};
		}
	}

}