/*

In this video, we explain about Hamiltonian path and cycle in Graphs.


1. A Hamiltonian path, is a path in an undirected or directed graph that visits each vertex exactly once. 
 2. Given an undirected graph  the task is to check if a Hamiltonian path is present in it or not.

 */

 public class hamilton
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
		HashSet<Integer> visited = new HashSet<>();

		hamiltonian(graph, src, visited, src+"", src);

	}

	public static void hamiltonian(ArrayList<Edge> graph, int src, HashSet<Integer> visited, String psf, int osrc)
	{
		if(visited.size() == graph.length - 1)
		{
			System.out.println(psf);

			boolean closingEdgeFound = false;
			for(Edge e: graph[src])
			{
				if(e.nbr == osrc)
				{
					closingEdgeFound = true;
					break;
				}	
			}

			if(closingEdgeFound)
				System.out.println("*");
			else
				System.out.println(".");
			return;
		}
		visited.add(src);
		for(Edge e:graph[src])
		{
			if(visited.contains(e.nbr) == false)
			hamiltonian(graph, e.nbr, visited, psf+e.nbr);
		}
	}
 }