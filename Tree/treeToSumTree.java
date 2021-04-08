/*

Given a Binary Tree where each node has positive and negative values. Convert this to a tree where each node contains the sum of the left and right sub trees in the original tree. The values of leaf nodes are changed to 0.

For example, the following tree

                  10
               /      \
             -2        6
           /   \      /  \ 
         8     -4    7    5
should be changed to

                 20(4-2+12+6)
               /      \
         4(8-4)      12(7+5)
           /   \      /  \ 
         0      0    0    0


*/

import java.io.*;
import java.util.*;
import java.util.stream.*;


public class treeToSumTree
{
	static class Node
	{
		int key;
		Node right, left;

		 Node(int key)
		 {
		 	this.key = key;
		 	right = left = null;
		 }
	}

	public static int convert(Node root)
	{
		if(root == null)
			return 0;

		int old_val = root.key;

		root.key = convert(root.left) + convert(root.right);

		return root.key + old_val;
	}
	static Node root;
	static void printInorder(Node node) 
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }
   
    /* Driver function to test above functions */
    public static void main(String args[]) 
    {
        
   
        /* Constructing tree given in the above figure */
        root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);
   
        convert(root);
   
        // Print inorder traversal of the converted tree to test result 
        // of toSumTree()
        System.out.println("Inorder Traversal of the resultant tree is:");
        printInorder(root);

        System.out.println();
    }
}