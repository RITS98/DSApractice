import java.util.*;

public class KosarajuStronglyConnectedComponents {

    public List<List<Integer>> executeKosarajuSCC(List<Integer>[] graph) {
        int vertex = graph.length;
        boolean[] visited = new boolean[vertex];
        List<Integer> order = orderOfGraph(graph, visited);
        List<Integer>[] reverseGraph = reverseGraph(graph);
        visited = new boolean[vertex];
        Collections.reverse(order);

        List<List<Integer>> result = new ArrayList<>();
        for (int v : order) {
            if (!visited[v]) {
                List<Integer> comp = new ArrayList<>();
                depthFirstSearch(reverseGraph, v, visited, comp);
                result.add(comp);
            }
        }
        return result;
    }

    public List<Integer> orderOfGraph(List<Integer>[] graph, boolean[] visited) {
        int vertex = graph.length;
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < vertex; i++)
            if (!visited[i])
                depthFirstSearch(graph, i, visited, order);
        return order;
    }

    public List<Integer>[] reverseGraph(List<Integer>[] graph) {
        int vertex = graph.length;
        List<Integer>[] reverseGraph = new List[vertex];
        for (int i = 0; i < vertex; i++)
            reverseGraph[i] = new ArrayList<>();
        for (int v = 0; v < vertex; v++)
            for (int i = 0; i < graph[v].size(); i++)
                reverseGraph[graph[v].get(i)].add(v);
        return reverseGraph;
    }

    public void depthFirstSearch(List<Integer>[] graph, int vertex, boolean[] visited, List<Integer> component) {
        visited[vertex] = true;
        for (int i = 0; i < graph[vertex].size(); i++)
            if (!visited[graph[vertex].get(i)])
                depthFirstSearch(graph, graph[vertex].get(i), visited, component);
        component.add(vertex);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number of Vertices in the Graph :");
        int vertex = scan.nextInt();
        List<Integer>[] graph = new List[vertex];
        for (int i = 0; i < vertex; i++)
            graph[i] = new ArrayList<>();

        System.out.println("Enter number of edges in the Graph :");
        int edge = scan.nextInt();
        System.out.println("Enter the space separated Edges :");
        int head, tail;
        for (int i = 0; i < edge; i++) {
            head = scan.nextInt();
            tail = scan.nextInt();
            graph[head].add(tail);
        }
        KosarajuStronglyConnectedComponents k = new KosarajuStronglyConnectedComponents();
        List<List<Integer>> scComponents = k.executeKosarajuSCC(graph);
        System.out.println("\nSet of Strongly Connected Components are : " + scComponents);
    }
}