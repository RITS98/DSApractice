/*

Write a function that returns true if the given Binary Tree is SumTree else false. A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree and right subtree. An empty tree is SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

*/

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class sumTree
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
	public static boolean isLeaf(Node node)
	{
		if(node == null)
			return false;
		if(node.left == null &&  node.right == null)
			return true;

		return false;
	}
	public static int isSumTree(Node root)
	{
		int ls, rs;


		if(root == null || isLeaf(root) == true)
			return 1;

		if(isSumTree(root.left) != 0 && isSumTree(root.right) !=0)
		{
			if(root.left == null)
				ls = 0;
			else if(isLeaf(root.left))
				ls = root.left.key;
			else
				ls = 2*(root.left.key);

			if(root.right == null)
				rs = 0;
			else if(isLeaf(root.right))
				rs = root.right.key;
			else
				rs = 2*root.right.key;

			if(root.key == (ls+rs))
				return 1;
			else
				return 0;
		}

		return 0;
	}
	static Node root = null;
	public static void main(String args[])
	{
		root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);
  
        if (isSumTree(root) != 0)
            System.out.println("The given tree is a SumTree");
        else
            System.out.println("The given tree is not a SumTree");

	}
}