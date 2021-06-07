//https://www.youtube.com/watch?v=gNn0L18DUvg&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=7

import java.io.*;
import java.util.*;

public class motherVertex
{
	public static int findMotherVertex(int N, ArrayList<ArrayList<Integer>> graph)
	{
		Stack<Integer> st = new Stack<>();
		boolean vi[] = new boolean[N];

		for(int i = 0;i<N;i++)
		{
			if(!visited[i])
				dfs(graph, visited, i, st);
		}

		int ans = st.pop();
		visited = new boolean[N];

		dfs(graph, visited, ans);
		if(count == N)
			return ans + 1;			//1 based indexing
		else
			return -1;

	}

	public static vid dfs(ArrayList<ArrayList<Integer>> graph, boolean visited[], int cur, Stack<Integer> st)
	{
		visited[cur] = true;

		for(int nbrs: graph.get(cur))
		{
			if(!visited[nbrs])
				dfs(graph, visited, nbrs, st);
		}

		st.push(cur);
	}


	static int count = 0;

	public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean visited[], int cur)
	{
		visited[cur] = true;
		count++;

		for(int nbrs: graph.get(cur))
		{
			if(!visited[nbrs])
				dfs(graph, visited, nbrs);
		}
	}
}