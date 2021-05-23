import java.io.*;
import java.util.*;

public class postOrderiteration extends Btree
{
	public static void PostOrder(Node root, ArrayList<Integer> list)
	{
		Stack<Node> st = new Stack<Node>();

		if(root == null)
			return;

		Node prev = null;
		st.push(root);
		while(!st.isEmpty())
		{
			Node current = st.peek();

			if(prev == null || prev.left == current || prev.right == current)
			{
				if(current.left!=null)
					st.push(current.left);
				else if(current.right!=null)
					st.push(current.right);
				else
				{
					st.pop();
					list.add(current.key);
				}
			}
			else if(current.left == prev)
			{
				if(current.right!=null)
					st.push(current.right);
				else
				{
					st.pop();
					list.add(current.key);
				}
			}
			else if(current.right == prev)
			{
				st.pop();
				list.add(current.key);
			}

			prev = current;
		}

		System.out.println(list);

	}
	public static void main(String args[])
	{
		postOrderiteration tree = new postOrderiteration();
 
        // Let us create trees shown in above diagram
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
 
        //ArrayList<Integer> mylist = tree.PostOrder(tree.root);
         ArrayList<Integer> mylist = new ArrayList<>();
        System.out.println("Post order traversal of binary tree is :");
        PostOrder(root, mylist);
	}
}