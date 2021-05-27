import java.io.*;

public class construct1
{
	class Node
	{
	    int key;
	    Node left, right;
	 
	    Node(int key) {
	        this.key = key;
	    }
	}

	public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }
 
    // Recursive function to build a BST from a preorder sequence.
    public static Node constructBST(int[] preorder, int start, int end)
    {
        // base case
        if (start > end) {
            return null;
        }
 
        // Construct the root node of the subtree formed by keys of the
        // preorder sequence in range '[start, end]'h'
        Node node = new Node(preorder[start]);
 
        // search the index of the first element in the current range of preorder
        // sequence larger than the root node's value
        int i;
        for (i = start; i <= end; i++)
        {
            if (preorder[i] > node.key) {
                break;
            }
        }
 
        // recursively construct the left subtree
        node.left = constructBST(preorder, start + 1, i - 1);
 
        // recursively construct the right subtree
        node.right = constructBST(preorder, i, end);
 
        // return current node
        return node;
    }
 
    public static void main(String[] args)
    {
        /* Construct the following BST
                  15
                /    \
               /      \
              10       20
             /  \     /  \
            /    \   /    \
           8     12 16    25
        */
 
        int[] preorder = { 15, 10, 8, 12, 20, 16, 25 };
 
        // construct the BST
        Node root = constructBST(preorder, 0, preorder.length - 1);
 
        // print the BST
        System.out.print("Inorder traversal of BST is ");
 
        // inorder on the BST always returns a sorted sequence
        inorder(root);
    }
}
