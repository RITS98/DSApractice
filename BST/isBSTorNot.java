import java.io.*;
import java.util.*;
import java.util.stream.*;

public class isBSTorNot
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

	static Node root;
	public static boolean isBST(Node root, Node l, Node r)
	{
		if(root == null)
			return true;

		if(l!=null && root.key <= l.key)
			return false;

		if(r!=null && root.key >= r.key)
			return false;

		return isBST(root.left, l, root) &&  isBST(root.right, root, r);
	}

	public static void main(String args[])
	{
	    Node root = new Node(3);
	    root.left = new Node(2);
	    root.right = new Node(5);
	    root.left.left = new Node(1);
	    root.left.right = new Node(4);
	 
	    if (isBST(root,null,null))
	        System.out.print("Is BST");
	    else
	        System.out.print("Not a BST");


	    System.out.println();
	}

}
