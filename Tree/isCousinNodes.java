class isCousinNodes
{
    
    public boolean isSibling(Node node, int a, int b)
    {
        if(node == null)
        return false;
        
        return ((node.left!=null && node.right!=null && node.left.data == a && node.right.data == b)||
                (node.left!=null && node.right!=null && node.left.data == b && node.right.data == a)||
                isSibling(node.left, a, b) || isSibling(node.right, a, b));
    }
    
    public int level(Node node, int a, int lev)
    {
        if(node == null)
        return -1;
        
        if(node.data == a)
        return lev;
        
        
        
        return Math.max(level(node.left,a,lev+1),level(node.right, a, lev+1));
    }
    // Returns true if the nodes with values 'a' and 'b' are cousins. Else returns false
    public boolean isCousins(Node root, int a, int b) {
        // your code here
        // This function should return true if x and y are cousins, else return false
        if(a==b)
        return false;
        
        boolean isSib = isSibling(root, a, b);
        int levA = level(root, a, 0);
        int levB = level(root, b, 0);
        //System.out.println(levA+" "+levB+" "+isSib);
        if(levA == levB && !isSib)
        return true;
        
        return false;
    }

}