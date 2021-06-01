//DFS


import java.util.*;
import java.io.*;
import java.lang.*;

class cycleDirected
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}
class Solution 
{
    public boolean isCyclic(int i, boolean visited[], boolean stack[], ArrayList<ArrayList<Integer>> adj)
    {
        if(stack[i])
        return true;
        
        if(visited[i])
        return false;
        
        visited[i] = stack[i] = true;
        
        Iterator<Integer> it = adj.get(i).iterator();
        
        while(it.hasNext())
        {
            int n = it.next();
            if(isCyclic(n, visited, stack, adj))
            return true;
        }
        
        stack[i] = false;
        
        return false;
    }
    //Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[] = new boolean[V], stack[] = new boolean[V];
        
        for(int i = 0;i<V;i++)
            if(isCyclic(i, visited, stack, adj))
            return true;
            
        return false;
    }
}