// Java program to print the longest leaf to leaf
// path
import java.io.*;

// Tree node structure used in the program

class diameter
{
	static class Node
	{
		int data;
		Node left, right;
		Node(int val)
		{
			data = val;
			left = right = null;
		}
	}
	static int ans, lh, rh, f;
	static Node k;
	public static Node Root;

	// Function to find height of a tree
	static int height(Node root)
	{
		if (root == null)
			return 0;
		int left_height = height(root.left);
		int right_height = height(root.right);
	
		// update the answer, because diameter of a
		// tree is nothing but maximum value of
		// (left_height + right_height + 1) for each node
		if (ans < 1 + left_height + right_height)
		{
			ans = 1 + left_height + right_height;

			// save the root, this will help us finding the
			// left and the right part of the diameter
			k = root;

			// save the height of left & right subtree as well.
			lh = left_height;
			rh = right_height;
		}
		return 1 + Math.max(left_height, right_height);

	}

	// prints the root to leaf path
	static void printArray(int[] ints, int len)
	{
		int i;
	
		// print left part of the path in reverse order
		if(f == 0)
		{
			for(i = len - 1; i >= 0; i--)
			{
				System.out.print(ints[i] + " ");
			}
		}
		else if(f == 1)
		{
			for (i = 0; i < len; i++)
			{
				System.out.print(ints[i] + " ");
			}
		}
	}
	
	// this function finds out all the root to leaf paths
	static void printPathsRecur(Node node, int[] path,
								int pathLen, int max)
	{
		if (node == null)
			return;
	
		// append this node to the path array
		path[pathLen] = node.data;
		pathLen++;
		
		// If it's a leaf, so print the path that led to here
		if (node.left == null && node.right == null)
		{
		
			// print only one path which is equal to the
			// height of the tree.
			if (pathLen == max && (f == 0 || f == 1))
			{
				printArray(path, pathLen);
				f = 2;
			}
		}
		else
		{
		
			// otherwise try both subtrees
		printPathsRecur(node.left, path, pathLen, max);
		printPathsRecur(node.right, path, pathLen, max);
		}
	}
	
	// Computes the diameter of a binary tree with given root.
	static void diameter(Node root)
	{
		if (root == null)
			return;
	
		// lh will store height of left subtree
		// rh will store height of right subtree
		ans = Integer.MIN_VALUE;
		lh = 0;
		rh = 0;
	
		// f is a flag whose value helps in printing
		// left & right part of the diameter only once
		f = 0;
		int height_of_tree = height(root);
		
		int[] lPath = new int[100];
		int pathlen = 0;
	
		// print the left part of the diameter
		printPathsRecur(k.left, lPath, pathlen, lh);
		System.out.print(k.data+" ");
		int[] rPath = new int[100];
		f = 1;
	
		// print the right part of the diameter
		printPathsRecur(k.right, rPath, pathlen, rh);
	}

	// Driver code
	public static void main (String[] args)
	{
	
		// Enter the binary tree ...
		//		 	1
		//		   /  \	
		//	 	  2	 	3
		//	 	/ 	\
		//	 	4	 5
		//	 	\ 	/ \
		//	 	8 	6 7
		//	 	/
		//	 	9
		Root = new Node(1);
		Root.left = new Node(2);
		Root.right = new Node(3);
		Root.left.left = new Node(4);
		Root.left.right = new Node(5);
		Root.left.right.left = new Node(6);
		Root.left.right.right = new Node(7);
		Root.left.left.right = new Node(8);
		Root.left.left.right.left = new Node(9);
		diameter(Root);

		System.out.println();
	
	}
}

// This code is contributed by rag2127
