class inorderSuccessor2
{
    public static void inorder(Node root, ArrayList<Node> al)
    {
        if(root == null)
        return;
        
        inorder(root.left, al);
        al.add(root);
        inorder(root.right, al);
    }
    public static void populateNext(Node root)
    {
        if(root == null)
        return;
        
        ArrayList<Node> al = new ArrayList<>();
        inorder(root, al);
        Node prev = al.get(0);
        for(int i = 1;i<al.size();i++)
        {
            prev.next = al.get(i);
            prev = prev.next;
        }
    }
}


//Method 2 LeetCode

 public Node connect(Node root) {
        
        if (root == null || root.left == null) {
            return root;
        }
        
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        
        connect (root.left);
        connect (root.right);
        
        return root;
        
    }