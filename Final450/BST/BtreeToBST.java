import java.util.*;
 


 
class BtreeToBST
{
    static class Node
    {
        int data;
        Node left = null, right = null;
     
        Node(int data) {
            this.data = data;
        }
    }
    // Function to perform inorder traversal on the tree
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
 
    // Function to traverse the binary tree and store its keys in a set
    public static void extractKeys(Node root, Set<Integer> set)
    {
        // base case
        if (root == null) {
            return;
        }
 
        extractKeys(root.left, set);
        set.add(root.data);
        extractKeys(root.right, set);
    }
 
    
    public static void convertToBST(Node root, Iterator<Integer> it)
    {
        if (root == null) {
            return;
        }
 
        convertToBST(root.left, it);
        root.data = it.next();
        convertToBST(root.right, it);
    }
 
    public static void main(String[] args)
    {
        /* Construct the following tree
                   8
                 /   \
                /     \
               3       5
              / \     / \
             /   \   /   \
            10    2 4     6
        */
 
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(10);
        root.left.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
 
        
        Set<Integer> set = new TreeSet<>();
        extractKeys(root, set);
 
        
        Iterator<Integer> it = set.iterator();
        convertToBST(root, it);
 
        
        inorder(root);
    }
}


