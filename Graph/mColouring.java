class mColouring
{
    //Function to determine if graph can be coloured with at most M colours such
    //that no two adjacent vertices of graph are coloured with same colour.
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) 
    {
        // Your code here
        int V = G.length;
        Arrays.fill(color, -1);
        return dfs(G, color, V, 0, C);
    }
    
    static boolean isSafe(List<Integer> adj, int colour[], int V, int c)
    {
        for(int i:adj)
        {
            if(c == colour[i])
            return false;
        }
        
        return true;
    }
    
    static boolean dfs(List<Integer> adj[], int colour[], int V, int i, int C)
    {
        if(i == V)
        return true;
        
        for(int c = 0;c<C;c++)
        {
            if(isSafe(adj[i], colour, V, c))
            {
                colour[i] = c;
                if(dfs(adj, colour, V, i+1, C))
                return true;
                
                colour[i] = -1;
            }
        }
        
        return false;
    }
    
}