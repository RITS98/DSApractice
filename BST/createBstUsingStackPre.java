/*

1. Create an empty stack.

2. Make the first value as root. Push it to the stack.



3. Keep on popping while the stack is not empty and the next value is greater than stack’s top value. Make this value as the right child of the last popped node. Push the new node to the stack.

4. If the next value is less than the stack’s top value, make this value as the left child of the stack’s top node. Push the new node to the stack.

5. Repeat steps 2 and 3 until there are items remaining in pre[].

*/

//https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversal-set-2/

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class createBstUsingStackPre
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

	public static Node construct(int pre[])
	{
		Node root = new Node(pre[0]);
		Stack<Node> st = new Stack<>();

		st.push(root);

		for(int i = 1;i<pre.length;i++)
		{
			Node temp = null;

			while(!st.isEmpty() && pre[i] > st.peek().key)
			{
				temp = st.pop();
			}

			if(temp != null)
			{
				temp.right = new Node(pre[i]);
				st.push(temp.right);
			}
			else
			{
				temp = st.peek();
				temp.left = new Node(pre[i]);
				st.push(temp.left);
			}
		}

		return root;

	}

	public static void inorder(Node root)
	{
		if(root == null)
			return;

		inorder(root.left);
		System.out.println(root.key+" ");
		inorder(root.right);
	}

	public static void main(String[] args) 
	{
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root = construct(pre);
        System.out.println("Inorder traversal of the constructed tree is ");
        inorder(root);
    }
}