class topologicalSort
{
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);
        
        Stack<Integer> st = new Stack<>();
        
        
        for(int i = 0;i<V;i++){
            if(!visited[i])
            topoSortUtil(i, visited, st, adj);
        }
        
        int arr[] = new int[V];
        int i = 0;
        
        while(!st.isEmpty())
        arr[i++] = st.pop();
        
        return arr;
    }
    
    static void topoSortUtil(int i, boolean visited[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj)
    {
        visited[i] = true;
        
        Iterator<Integer> it = adj.get(i).iterator();
        while(it.hasNext())
        {
            Integer vadj = it.next();
            
            if(!visited[vadj])
            topoSortUtil(vadj, visited, st, adj);
        }
        
        st.push(new Integer(i));
    }
}
