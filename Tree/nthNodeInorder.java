import java.io.*;
import java.util.*;
import java.util.stream.*;

public class nthNodeInorder
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

	static int count = 0;
	static Node root;
	public static void nthNode(Node node, int n)
	{
		if(node == null)
			return;

		if(count <= n)
		{
			nthNode(node.left, n);
			count++;

			if(count == n)
				System.out.println(node.key+" ");

			nthNode(node.right, n);
		}
	}

	public static void main(String args[])
	{
		root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);

		int n = 4;

		nthNode(root, n);
	}
}