import java.io.*;
import java.util.*;

public class bipartite
{
	static class Edge
	{
		int src, bnr, wt;
		Edge(int src, int bnr, int wt)
		{
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static class Pair
	{
		int v, level;
		String psf;

		Pair(int v, String psf, int level)
		{
			this.v = v;
			this.psf = psf;
			this.level = level;
		}
	}

	public static void main(String args[])throws IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

		int vtcs = Iteger.parseInt(br.readLine());
		ArrayList<Edge> graph[] = new ArrayList[vtcs];

		Arrays.fill(graph, new ArrayList<>());

		int edges = Integer.parseInt(br.readLine());
		for(int i = 0;i<edges;i++)
		{
			String parts[] = br.readline().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);

			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}

		int visited[] = new int[vtcs];
		Arrays.fill(visited, -1);
		for(int i = 0;i<vtcs;i++)
		{
			if(visited[i] != -1)
			{
				boolean isCompBipartite = check(graph, v, visited);
				if(isCompBipartite)
				{
					System.out.println(false);
					return;
				}
			}
		}
	}

	public static boolean check(ArrayList<Edge> graph[], int i, boolean visited[])
	{
		ArrayDeque<Pair> q = new ArrayDeque<>();
		q.add(new Pair(src, src+"", 0));

		while(!q.isEmpty())
		{
			Pair rem = q.removeFirst();

			if(visited[rem.v] != -1)
			{
				if(rem.level ! = visited[rem.v])
					return false;
			}
			else
			{
				visited[rem.v] = rem.level;
			}

			for(Edge e: graph[rem.v])
			{
				if(visited[e.nbr] == -1)
				{
					q.add(new Pair(e.nbr, rem.psf + e.nbr, rem.level + 1));
				}
			}
		}

		return true;
	}
}