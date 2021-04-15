import java.io.*;
import java.util.*;
import java.util.stream.*;

public class treeToBST
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

	static Node root;

	public static void inorder(Node root)
	{
		if(root == null)
			return;

		inorder(root.left);
		System.out.print(root.key + " ");
		inorder(root.right);
	}

	public static void preorder(Node root)
	{
		if(root == null)
			return;

		System.out.print(root.key+" ");
		preorder(root.left);
		preorder(root.right);
	}
	public static void extractKey(Node root, Set<Integer> set)
	{
		if(root == null)
			return;

		extractKey(root.left, set);
		set.add(root.key);
		extractKey(root.right, set);
	}

	public static void convertToBST(Node root, Iterator<Integer> it)
	{
		if(root == null)
			return;

		convertToBST(root.left, it);
		root.key = it.next();
		convertToBST(root.right, it);
	}

	public static void main(String args[])
	{
		/*
		Construct the following tree
                   8
                 /   \
                /     \
               3       5
              / \     / \
             /   \   /   \
            10    2 4     6
		*/
		root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(10);
        root.left.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
 
        // traverse the binary tree and store its keys in a set
        Set<Integer> set = new TreeSet<>();
        extractKey(root, set);
 
        // put back keys present in the set to their correct order in the BST
        Iterator<Integer> it = set.iterator();
        convertToBST(root, it);
 
        // print the BST
        inorder(root);
        System.out.println();

        preorder(root);
        System.out.println();
	}
}