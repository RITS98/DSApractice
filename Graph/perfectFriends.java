/*

With this video, we bring an interesting variation of the get connected components of graphs - Perfect Friends. In this question,


1. You are given a number n (representing the number of students). Each student will have an id from 0 to n - 1.
2. You are given a number k (representing the number of clubs)
3. In the next k lines, two numbers are given separated by a space. The numbers are ids of students belonging to same club.



You have to find in how many ways can we select a pair of students such that both students are from different clubs.

*/

//https://www.youtube.com/watch?v=_q4hA01ZcVQ&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=8

import java.io.*;
import java.util.*;

public class perfectFriends
{

	static class Edge
	{
		int v, n;
		Edge(int v, int n)
		{
			this.v = v;
			this.n = n;
		}
	}

	public static void main(String args[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		ArrayList<Edge> graph[] = new ArrayList[n];
		Arrays.fill(graph, new ArrayList<>());

		for(int e = 0;e<k;e++)
		{
			String parts[] = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);

			graph[v1].add(new Edge(v1, v2));
			graph[v2].add(new Edge(v2, v1));
		}

		Arraylist<Arraylist<Integer>> comps = new ArrayList<>();
		boolean visited[] = new boolean[n];
		for(int v = 0;v< n; v++)
		{
			if(!visited[v])
			{
				Arraylist<Integer> comp = new ArrayList<>();
				drawTree(graph, v, comp, visited);
				comps.add(comp);
			}
		}

		int pairs = 0;
		for(int i = 0;i<comps.size();i++)
		{
			for(int j = i+1;j<comps.size()-1;j++)
			{
				pairs += (comps.get(i).size() * comps.get(j).size());
			}
		}

		System.out.println(pairs);
	}

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



}
