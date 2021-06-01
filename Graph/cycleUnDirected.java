//BFS

import java.util.*;
import java.lang.*;
import java.io.*;
class cycleUnDirected
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
class Solution
{
    public boolean isCyclicU(int i, int V,boolean visited[], ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> q = new LinkedList<>();
        int parent[] = new int[V];
        Arrays.fill(parent, -1);
        
        q.add(i);
        visited[i] = true;
        
        while(!q.isEmpty())
        {
            int u = q.poll();
            
            Iterator<Integer> it = adj.get(u).iterator();
            
            while(it.hasNext())
            {
                int n = it.next();
                if(!visited[n])
                {
                    visited[n] = true;
                    q.add(n);
                    parent[n] = u;
                }
                else if(parent[u]!=n)
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    //Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);
        
        for(int i = 0;i<V;i++)
        {
            if(!visited[i] && isCyclicU(i, V, visited, adj))
            return true;
        }
        
        return false;
        
    }
}