/*

Given a binary tree, you need to check whether sum of all covered elements is equal to sum of all uncovered elements or not.
In a binary tree, a node is called Uncovered if it appears either on left boundary or right boundary. Rest of the nodes are called covered.


For calculating sum of Uncovered nodes we will follow below steps:
1) Start from root, go to left and keep going until left child is available, if not go to right child and again follow same procedure until you reach a leaf node.

2) After step 1 sum of left boundary will be stored, now for right part again do the same procedure but now keep going to right until right child is available, if not then go to left child and follow same procedure until you reach a leaf node.


*/

import java.io.*;
import java.util.*;
import java.util.stream.*;


public class sumCoverUncover
{
	static class Node
	{
		int data;
		Node right, left;

		Node(int key)
		{
			this.data = data;
			right = left = null;
		}
	}

	public static int sumAllNodes(Node root)
	{
		if(root == null)
		{
			return 0;
		}

		return root.data + sumAllNodes(root.left) + sumAllNodes(root.right);
	}

	public static int uncoveredLeftSum(Node root)
	{
		if(root.left == null && root.right == null)
			return root.data;

		if(root.left != null)
		{
			return root.data + sumAllNodes(root.left);
		}
		else
		{
			return root.data + sumAllNodes(root.right);
		}
	}

	public static int uncoveredRightSum(Node root)
	{
		if(root.left == null && root.right == null)
			return root.data;

		if(root.right!= null)
			return root.data + uncoveredRightSum(root.right);
		else
			return root.data + uncoveredRightSum(root.left);
	}

	static int uncoverSum(Node root) 
    {
        /* Initializing with 0 in case we don't have
           left or right boundary  */
        int lb = 0, rb = 0;
  
        if (root.left != null)
            lb = uncoveredLeftSum(root.left);
        if (root.right != null)
            rb = uncoveredRightSum(root.right);
  
        /* returning sum of root node, left boundary
           and right boundary*/
        return root.data + lb + rb;
    }
  
    // Returns true if sum of covered and uncovered elements
    // is same.
    static boolean isSumSame(Node root) 
    {
        // Sum of uncovered elements
        int sumUC = uncoverSum(root);
  
        // Sum of all elements
        int sumT = sumAllNodes(root);
  
        // Check if sum of covered and uncovered is same
        return (sumUC == (sumT - sumUC));
    }
  

	void inorder(Node root) 
    {
        if (root != null) 
        {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
  
  	static Node root = null;
    // Driver program to test above functions
    public static void main(String[] args) 
    {
  
        
  
        // Making above given diagram's binary tree
        root = new Node(8);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
  
        root.right = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
  
        if (isSumSame(root)) 
            System.out.println("Sum of covered and uncovered is same");
         else 
            System.out.println("Sum of covered and uncovered is not same");
    }
}