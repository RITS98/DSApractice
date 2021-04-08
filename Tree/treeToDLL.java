/*

Given a Binary Tree (Bt), convert it to a Doubly Linked List(DLL). The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. The order of nodes in DLL must be same as Inorder of the given Binary Tree. The first node of Inorder traversal (left most node in BT) must be head node of the DLL.

https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-2/
*/

import java.io.*;
import java.util.*;

import java.util.stream.*;

public class treeToDLL
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

	static Node  prev;
	static Node root;
	public static void fixPrevPtr(Node node)
	{
		if(node == null)
			return;

		fixPrevPtr(node.left);
		node.left = prev;
		prev = node;
		fixPrevPtr(node.right);
	} 

	public static Node fixNextPtr(Node node)
	{
		if(node != null && node.right != null)
			node = node.right;

		while(node !=null && node.left!=null)
		{
			Node left = node.left;
			left.right = node;
			node = node.left;
		}

		return node;
	}

	public static Node BTTtoDLL(Node node)
	{
		prev = null;

		fixPrevPtr(node);
  
        // Set the next pointer and return head of DLL
        return fixNextPtr(node);
	}

	static void printlist(Node root) 
    {
        while (root != null) 
        {
            System.out.print(root.key + " ");
            root = root.right;
        }
    }
  
    // Standard Inorder traversal of tree
    static void inorder(Node root) 
    {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }
  
    public static void main(String[] args) 
    {
        // Let us create the tree shown in above diagram
        root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
  
        System.out.println("Inorder Tree Traversal");
        inorder(root);
  
        Node head = BTTtoDLL(root);
  
        System.out.println("\nDLL Traversal");
        printlist(head);
        System.out.println();
    }
}