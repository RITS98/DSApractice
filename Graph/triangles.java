// Java program to count triangles
// in a graph. The program is
// for adjacency matrix
// representation of the graph.
import java.io.*;

class trianles {

	// Number of vertices in the graph
	int V = 4;

	int countTriangle(int graph[][], boolean isDirected)
	{
	
		int count_Triangle = 0;
		for (int i = 0; i < V; i++)
		{
			for (int j = 0; j < V; j++)
			{
				for (int k=0; k<V; k++)
				{
					if (graph[i][j] == 1 && graph[j][k] == 1 && graph[k][i] == 1)
						count_Triangle++;
				}
			}
		}

	
		if(isDirected == true)
		{
			count_Triangle /= 3;
		}
		else
		{
			count_Triangle /= 6;
		}
		return count_Triangle;
	}


	public static void main(String args[])
	{
			
		
		int graph[][] = {{0, 1, 1, 0},
							{1, 0, 1, 1},
							{1, 1, 0, 1},
							{0, 1, 1, 0}
						};
		
		
		int digraph[][] = { {0, 0, 1, 0},
							{1, 0, 0, 1},
							{0, 1, 0, 0},
							{0, 0, 1, 0}
							};
		
		GFG obj = new GFG();

		System.out.println("The Number of triangles in undirected graph : " + obj.countTriangle(graph, false));

		System.out.println("\n\nThe Number of triangles in directed graph : "+ obj.countTriangle(digraph, true));

	}
}


