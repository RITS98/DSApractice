import java.io.*;
import java.util.*;
import java.util.stream.*;


public class sumOfAllNodes
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
	static Node root = null, temp = root;
	static int sum = 0;
	public static int sum(Node temp)
	{
		if(temp == null)
			return 0;

		return temp.key + sum(temp.left) + sum(temp.right) ;
	}

	public static void main(String args[])
	{
		Node root = new Node(1); 
	    root.left = new Node(2); 
	    root.right = new Node(3); 
	    root.left.left = new Node(4); 
	    root.left.right = new Node(5); 
	    root.right.left = new Node(6); 
	    root.right.right = new Node(7); 
	    root.right.left.right = new Node(8); 
	  
	    int sum = sum(root); 
	    System.out.println("Sum of all the elements is: " + sum); 
	}
}