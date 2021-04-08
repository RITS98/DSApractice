//https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/

import java.io.*;
import java.util.*;
import java.util.stream.*;


public class createBstFromPre
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

	private static Node node;
	public static Node createNode(Node node, int data)
	{
		if(node == null)
			node = new Node(data);

		if(node.key > data)
			node.left =  createNode(node.left, data);
		if(node.key < data)
			node.right =  createNode(node.right, data);

		return node;
	}

	public static void create(int data)
	{
		node = createNode(node, data);

	}
	public static void inorder(Node node)
	{
		if(node == null)
			return;

		inorder(node.left);
		System.out.println(node.key+" ");
		inorder(node.right);
	}

	public static void main(String args[])
	{
		int[] nodeData = { 10, 5, 1, 7, 40, 50 };
 
        for (int i = 0; i < nodeData.length; i++) {
            create(nodeData[i]);
        }
        inorder(node);
	}
}