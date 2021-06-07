class cloneGraph
{
    public Node cloneGraph(Node node) 
    {
        if(node == null)
            return node;
        Queue<Node>  q = new LinkedList<Node>();
        q.add(node);
        
        HashMap<Node, Node> hm = new HashMap<Node, Node>();
        hm.put(node, new Node(node.val));
        while(!q.isEmpty())
        {
            Node u = q.poll();
            Node cloneNodeU = hm.get(u);
            if(u.neighbors != null)
            {
                List<Node> v = u.neighbors;
                for(Node n : v)
                {
                    Node cloneNodeG = hm.get(n);
                    if(cloneNodeG == null)
                    {
                        q.add(n);
                        
                        cloneNodeG = new Node(n.val);
                        hm.put(n, cloneNodeG);
                        
                    }
                    
                    cloneNodeU.neighbors.add(cloneNodeG);
                }
                
            }
        }
        
        return hm.get(node);
    }
}