class alienDictionary
{
    
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<Integer> adj[] = new ArrayList[K];
        Arrays.fill(adj, new ArrayList<Integer>());
        for(int i = 0;i<N-1;i++)
        {
            for(int j = 0;j<Math.min(dict[i].length(), dict[i+1].length());j++)
            {
                if(dict[i].charAt(j) != dict[i+1].charAt(j))
                {
                    adj[dict[i].charAt(j) - 'a'].add(dict[i+1].charAt(j)-'a');
                    break;
                }
            }
        }
        
        boolean visited[] = new boolean[K];
        Arrays.fill(visited, false);
        Stack<Integer> st = new Stack<Integer>();
        
        
        for(int i = 0;i<K;i++)
        {
            if(adj[i].size()>0)
            {
                for(int j: adj[i])
                {
                    if(visited[j] == false)
                    topoSort(i, adj, visited, st);
                }
            }
            
        }
        
        String s = "";
        
        while(st.isEmpty())
        {
            s = s + (char)(st.pop()+'a');
        }
        
        return s;
    }
    
    public void topoSort(int i, ArrayList<Integer> adj[], boolean visited[], Stack<Integer> st)
    {
        visited[i] = true;
        
        for(int j: adj[i])
        {
            if(!visited[j])
            topoSort(j, adj, visited, st);
        }
        
        st.push(i);
    }
}