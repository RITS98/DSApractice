/*

In this video, we explain about connected components in a graph and state the problem where,
1. You are given a graph.
2. You are required to find and print all connected components of the graph.

*/

public class countConnected
{
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

	public static void main(String args[])
	{
		Arraylist<Arraylist<Integer>> comps = new ArrayList<>();
		boolean visited[] = new boolean[N];
		for(int v = 0;v< N; v++)
		{
			if(!visited[v])
			{
				Arraylist<Integer> comp = new ArrayList<>();
				drawTree(graph, v, comp, visited);
				comps.add(comp);
			}
		}

		System.out.println(comps.size());
	}

}