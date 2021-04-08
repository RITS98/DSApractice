/*

Depth First Traversals: 
(a) Inorder (Left, Root, Right) : 4 2 5 1 3 
(b) Preorder (Root, Left, Right) : 1 2 4 5 3 
(c) Postorder (Left, Right, Root) : 4 5 2 3 1

Breadth First or Level Order Traversal : 1 2 3 4 5 
Please see this post for Breadth First Traversal.
Inorder Traversal (Practice): 

Algorithm Inorder(tree)
   1. Traverse the left subtree, i.e., call Inorder(left-subtree)
   2. Visit the root.
   3. Traverse the right subtree, i.e., call Inorder(right-subtree)
Uses of Inorder 
In case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing order. To get nodes of BST in non-increasing order, a variation of Inorder traversal where Inorder traversal s reversed can be used. 
Example: Inorder traversal for the above-given figure is 4 2 5 1 3.
Preorder Traversal (Practice): 

Algorithm Preorder(tree)
   1. Visit the root.
   2. Traverse the left subtree, i.e., call Preorder(left-subtree)
   3. Traverse the right subtree, i.e., call Preorder(right-subtree) 
Uses of Preorder 
Preorder traversal is used to create a copy of the tree. Preorder traversal is also used to get prefix expression on of an expression tree. Please see http://en.wikipedia.org/wiki/Polish_notation to know why prefix expressions are useful. 
Example: Preorder traversal for the above given figure is 1 2 4 5 3.
Postorder Traversal (Practice): 



Algorithm Postorder(tree)
   1. Traverse the left subtree, i.e., call Postorder(left-subtree)
   2. Traverse the right subtree, i.e., call Postorder(right-subtree)
   3. Visit the root.

*/

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class treeTraversal
{
	static class Node
	{
		int key;
		Node right, left;

		Node(int key)
		{
			this.key = key;
			left = right = null;
		}
	}
	static Node root = null;
	static Node temp = root;
	public static void inorder(Node temp)
	{
		if(temp == null)
			return;

		inorder(temp.left);
		System.out.print(temp.key+" ");
		inorder(temp.right);
	}

	public static void preorder(Node temp)
	{
		if(temp == null)
			return;

		System.out.print(temp.key+" ");
		preorder(temp.left);
		preorder(temp.right);
	}

	public static void postorder(Node temp)
	{
		if(temp == null)
			return;

		postorder(temp.left);
		postorder(temp.right);
		System.out.print(temp.key+" ");
	}

	public static void levelorder(Node temp)
	{
		Queue<Node> q = new LinkedList<>();
		Node x;
		q.add(temp);

		while(!q.isEmpty())
		{
			x = q.peek();
			q.remove();

			System.out.print(x.key+" ");

			if(x.left!=null)
				q.add(x.left);
			if(x.right!=null)
				q.add(x.right);
		}
	}


	public static void main(String args[])
	{
		root = new Node(25);
	    root.left = new Node(15);
	    root.left.left = new Node(10);
	    root.left.right = new Node(22);
	    root.left.left.left = new Node(4);
	    root.left.left.right = new Node(12);
	    root.left.right.left = new Node(18);
	    root.left.right.right = new Node(24);

	    root.right = new Node(50);
	    root.right.left = new Node(35);
	    root.right.right = new Node(70);
	    root.right.left.left = new Node(31);
	    root.right.left.right = new Node(44);
	    root.right.right.left = new Node(66);
	    root.right.right.right = new Node(90);
	 
	    System.out.println("Preorder traversal of binary tree is ");
        preorder(root);
 
        System.out.println("\nInorder traversal of binary tree is ");
        inorder(root);
 
        System.out.println("\nPostorder traversal of binary tree is ");
        postorder(root);

        System.out.println("\nLevelorder Traversal of binary tree is ");
        levelorder(root);

        System.out.println();
	 
	}
}