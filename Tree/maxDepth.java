import java.io.;
import java.util.*;
import java.util.stream.*;


public class maxDepth
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

	public static int findDepth(Node root)
	{
		if(root == null)
		{
			return 0;
		}

		int lDepth = findDepth(root.left);
		int rDepth = findDepth(root.right);

		if(lDepth> rDepth)
			return lDepth + 1;
		else
			return rDepth + 1;
	}

	public static void main(String[] args)
    {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
  
        System.out.println("Height of tree is : " + maxDepth(root));
    }
}