import java.io.*;
import java.util.*;
import java.util.stream.*;

public class largestNo
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

	static Node newNode(int item) 
	{ 
	    Node temp = new Node(item);  
	    return temp; 
	} 
	  
	// To insert a new node in BST 
	static Node insert(Node node, int key) 
	{ 
	    // if tree is empty return new node 
	    if (node == null) 
	        return newNode(key); 
	  
	    // if key is less then or grater then 
	    // node value then recur down the tree 
	    if (key < node.key) 
	        node.left = insert(node.left, key); 
	    else if (key > node.key) 
	        node.right = insert(node.right, key); 
	  
	    // return the (unchanged) node pointer 
	    return node; 
	} 

	static Node root;

	public static int findNode(Node root, int n)
	{
		if(root == null)
			return -1;
		if(root.key == n)
			return n;
		else if(root.key < n)
		{
			int k = findNode(root.right, n);
			if(k == -1)
				return root.key;
			else
				return k;
		}
		else if(root.key > n)
			return findNode(root.left, n);

		return -1;
	}

	public static void main(String[] args) 
	{ 
	    int N = 4; 
	  
	    // creating following BST 
	    /* 
	                5 
	            / \ 
	            2     12 
	        / \ / \ 
	        1 3 9 21 
	                    / \ 
	                    19 25 */
	    Node root = null;
	    root = insert(root, 25); 
	    insert(root, 2); 
	    insert(root, 1); 
	    insert(root, 3); 
	    insert(root, 12); 
	    insert(root, 9); 
	    insert(root, 21); 
	    insert(root, 19); 
	    insert(root, 25); 
	  
	    System.out.println(findNode(root, N)); 
	}
}