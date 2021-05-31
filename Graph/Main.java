import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A class to store a graph edge
class Edge
{
	int src, dest, weight;

	Edge(int src, int dest, int weight)
	{
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
}

// A class to store adjacency list nodes
class Node
{
	int value, weight;

	Node(int value, int weight)
	{
		this.value = value;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return this.value + " (" + this.weight + ")";
	}
}

// A class to represent a graph object
class Graph
{
	// A list of lists to represent an adjacency list
	List<List<Node>> adj = new ArrayList<>();

	// Constructor to construct a graph
	public Graph(List<Edge> edges)
	{
		// find the maximum numbered vertex
		int n = 0;
		for (Edge e: edges) {
			n = Integer.max(n, Integer.max(e.src, e.dest));
		}

		// allocate memory for the adjacency list
		for (int i = 0; i <= n; i++) {
			adj.add(i, new ArrayList<>());
		}

		// add edges to the undirected graph
		for (Edge e: edges)
		{
			// allocate new node in adjacency list from src to dest
			adj.get(e.src).add(new Node(e.dest, e.weight));

			// uncomment line 60 for undirected graph

			// allocate new node in adjacency list from dest to src
			// adj.get(e.dest).add(new Node(e.src, e.weight));
		}
	}

	// Function to print adjacency list representation of a graph
	public static void printGraph(Graph graph)
	{
		int src = 0;
		int n = graph.adj.size();

		while (src < n)
		{
			// print current vertex and all its neighboring vertices
			for (Node edge: graph.adj.get(src)) {
				System.out.printf("%d ——> %s\t", src, edge);
			}

			System.out.println();
			src++;
		}
	}
}

class Main
{
	public static void main (String[] args)
	{
		// Input: List of edges in a weighted digraph (as per the above diagram)
		// tuple `(x, y, w)` represents an edge from `x` to `y` having weight `w`
		List<Edge> edges = Arrays.asList(new Edge(0, 1, 6), new Edge(1, 2, 7),
				new Edge(2, 0, 5), new Edge(2, 1, 4),
				new Edge(3, 2, 10), new Edge(4, 5, 1),
				new Edge(5, 4, 3));

		// construct a graph from the given list of edges
		Graph graph = new Graph(edges);

		// print adjacency list representation of the graph
		Graph.printGraph(graph);
	}
}