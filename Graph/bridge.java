import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
// A class to store a graph edge
class Edge
{
    int source, dest;
 
    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}
 
// A class to represent a graph object
class Graph
{
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;
 
    // Constructor
    Graph(List<Edge> edges, int N)
    {
        adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // add edges to the undirected graph
        for (Edge edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
 
class bridge
{
    // Perform DFS on the graph starting from vertex `v` and find
    // all bridges in the process
    public static int DFS(Graph graph, int v, boolean[] discovered,
                          int[] arrival, int parent, int time)
    {
        // set the arrival time of vertex `v`
        arrival[v] = ++time;
 
        // mark vertex as discovered
        discovered[v] = true;
 
        // initialize `t` with the arrival time of vertex `v`
        int t = arrival[v];
 
        // `(v, w)` forms an edge
        for (int w: graph.adjList.get(v))
        {
            // if `w` is not discovered
            if (!discovered[w]) {
                t = Integer.min(t, DFS(graph, w, discovered, arrival, v, time));
            }
            // if `w` is discovered, and `w` is not a parent of `v`
            else if (w != parent)
            {
                // If vertex `w` is already discovered, there is a back edge starting
                // from `v`. Note that as `discovered[u]` is already
                // true, `arrival[u]` is already defined
                t = Integer.min(t, arrival[w]);
            }
        }
 
        // if the value of `t` remains unchanged, i.e., it is equal
        // to the arrival time of vertex `v`, and if `v` is not the root node,
        // then `(parent[v] —> v)` forms a bridge
        if (t == arrival[v] && parent != -1) {
            System.out.println(parent + ", " + v);
        }
 
        // return the minimum arrival time
        return t;
    }
 
    public static void main(String[] args)
    {
        // initialize edges as per the above diagram
        // `(u, v, w)` triplet represent undirected edge from
        // vertex `u` to vertex `v` having weight `w`
        List<Edge> edges = Arrays.asList(
                new Edge(0, 2), new Edge(1, 2),
                new Edge(2, 3), new Edge(2, 4),
                new Edge(3, 4), new Edge(3, 5)
        );
 
        // total number of nodes in the graph
        final int N = 6;
 
        // construct graph
        Graph graph = new Graph(edges, N);
 
        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[N];
 
        // stores arrival time of a node in DFS
        int[] arrival = new int[N];
 
        int start = 0, parent = -1, time = 0;
 
        // As the given graph is connected, DFS will cover every node
        DFS(graph, start, discovered, arrival, parent, time);
    }
}