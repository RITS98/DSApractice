/*

Given a Binary Tree, check if all leaves are at same level or not. 

          12
        /    \
      5       7       
    /          \ 
   3            1
  Leaves are at same level

          12
        /    \
      5       7       
    /          
   3          
   Leaves are Not at same level


          12
        /    
      5             
    /   \        
   3     9
  /      /
 1      2
 Leaves are at same level

 */

 import java.io.*;
 import java.util.*;
 import java.util.stream.*;

 public class leavesSameLevel
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
 	static int maxlevel = 0;
 	public static boolean check(Node node, int level)
 	{
 		if(node == null)
 			return true;

 		System.out.println(level+" "+maxlevel+(node.right == null)+" "+(node.left ==null));
 		if(node.left == null && node.right == null)
 		{
 			System.out.println("----");
 			if(maxlevel == 0)
 			{
 				maxlevel = level;
 				return true;
 			}
 		
 				return (level == maxlevel);
 			
 		}

 		//System.out.println("...........");
 		return check(node.right, level+1) && check(node.left, level+1);
 	}
 	static void inorder(Node root) 
    {
        if (root != null) 
        {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }
 	public static void main(String args[])
 	{
 		root = new Node(12);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(9);
        root.left.left.left = new Node(1);
        root.left.right.left = new Node(1);
        //root.left.right.left.right = new Node(10);

        inorder(root);
        System.out.println();
        if (check(root, 0))
            System.out.println("Leaves are at same level");
        else
            System.out.println("Leaves are not at same level");
 	}
 }