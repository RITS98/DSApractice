/*
Given a binary tree, we need to check it has heap property or not, Binary tree need to fulfill the following two conditions for being a heap – 

It should be a complete tree (i.e. all levels except last should be full).
Every node’s value should be greater than or equal to its child node (considering max-heap).
*/


//https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-heap/

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class isBtreeHeap
{
	static class Node
	{
		int key;
		Node left, right;
		Node(int key)
		{
			this.key = key;
			right = left = null;
		}
	}

	public static int countNodes(Node root)
	{
		if(root == null)
			return 0;

		return (1+ countNodes(root.left)+countNodes(root.right));
	}

	public static boolean isComplete(Node root, int index, int number_of_nodes)
	{
		if(root == null)
			return true;

		if(index >= number_of_nodes)
			return false;

		return isComplete(root.left, 2*index+1,number_of_nodes) && isComplete(root.right, 2*index+2, number_of_nodes);

	}
	public static boolean isHeap(Node root)
	{
		if(root.left == null && root.right == null)
			return true;

		if(root.right == null)
		{
			return root.key >= root.left.key;
		}
		else
		{
			if(root.key > root.left.key && root.key > root.right.key)
				return isHeap(root.left) && isHeap(root.right);
			else
				return false;
		}
	}

	public static boolean isTree_Heap(Node root)
	{
		if(root == null)
			return true;

		int node_count = countNodes(root);

		return isComplete(root, 0, node_count) && isHeap(root);
	}

	public static void main(String args[])
	{
		Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(2);
        root.left.right.left = new Node(1);
 
        if (isTree_Heap(root))
            System.out.println("Given binary tree is a Heap");
        else
            System.out.println("Given binary tree is not a Heap");
    
	}
}