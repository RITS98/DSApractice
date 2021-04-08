import java.io.*;
import java.util.*;
import java.util.stream.*;

public class symmetricTree
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

	public static boolean isMirror(Node node1, Node node2)
	{
		if(node1 == null && node2 == null)
			return true;

		if(node1 != null && node2 != null && node1.key == node2.key)
			return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);

		return false;
	}

	static Node root;
	public static void main(String args[])
	{
		root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        boolean output = isMirror(root, root);
        if (output == true)
            System.out.println("Symmetric");
        else
            System.out.println("Not symmetric");
	}
}