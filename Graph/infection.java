import java.io.*;
import java.util.*;


public class infection
[
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
		int v, time;

		Pair(int v, int time)
		{
			this.v = v;
			this.time = time;
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

		int src = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());

		ArrayDeque<Pair> q = new ArrayDeque<>();
		q.add(new Pair(src, 1));
		int visited[] = new int[vtcs];

		while(!q.isEmpty())
		{
			Pair rem = q.removeFirst();
			if(visited[rem.v] > 0)
				continue;

			visited[rem.v] = rem.time;
			
			if(rem.time > t)
			{
				break;
			}
			
			count++;
			for(Edge e: graph[rem.v])
			{
				if(visited[e.nbr] == 0)
				{
					q.add(new Pair(e.nbr, rem.time + 1));
				}
			}
		}

		System.out.println(count);
	}
}

