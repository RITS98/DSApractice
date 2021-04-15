/*

Given values of two values n1 and n2 in a Binary Search Tree, find the Lowest Common Ancestor 
(LCA). You may assume that both the values exist in the tree.

Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is 
defined as the lowest node in T that has both n1 and n2 as descendants (where we allow a 
node to be a descendant of itself).

The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest 
from the root. Computation of lowest common ancestors may be useful, for instance, as 
part of a procedure for determining the distance between pairs of nodes in a tree: 
the distance from n1 to n2 can be computed as the distance from the root to n1, plus 
the distance from the root to n2, minus twice the distance from the root to their lowest 
common ancestor. 



Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is 
defined as the lowest node in T that has both n1 and n2 as descendants (where we allow a 
node to be a descendant of itself).

The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest from 
the root. Computation of lowest common ancestors may be useful, for instance, as part of a 
procedure for determining the distance between pairs of nodes in a tree: the distance from 
n1 to n2 can be computed as the distance from the root to n1, plus the distance from the root 
o n2, minus twice the distance from the root to their lowest common ancestor. 



*/



import java.io.*;
import java.util.*;
import java.util.stream.*;


public class LCA
{
	static class Node
	{
		int data;
		Node right, left;
		Node(int data)
		{
			this.data = data;
			right = left = null;
		}
	}

	Node root;
	public Node findLCA(Node root, int n1, int n2)
	{
		if(root == null)
			return null;

		if(n1<root.data && n2<root.data)
			return findLCA(root.left, n1, n2);
		else if(n1> root.data && n2> root.data)
			return findLCA(root.right, n1, n2);
		else
			return root;
	}
	public static void main(String args[]) 
    {
        // Let us construct the BST shown in the above figure
        LCA tree = new LCA();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
   
        int n1 = 10, n2 = 14;
        Node t = tree.findLCA(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
   
        n1 = 14;
        n2 = 8;
        t = tree.findLCA(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
   
        n1 = 10;
        n2 = 22;
        t = tree.findLCA(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
   
    }
}

