class diameter
{
    int max= Integer.MIN_VALUE;
    int height(Node root)
    {
        if(root == null)
        return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        max = Math.max(lh+rh+1,max);
        return Math.max(lh,rh)+1;
    }
    //Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        // Your code here
        int x = height(root);
        return max;
        
    }
}
