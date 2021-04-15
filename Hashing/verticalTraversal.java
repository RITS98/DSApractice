import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.Map.*;

public class verticalTraversal
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
	public static void getVertical(Node root,int hd, TreeMap<Integer, Vector<Integer>> m)
	{
		if(root == null)
			return;

		Vector<Integer> get = m.get(hd);
		if(get == null)
		{
			get = new Vector<>();
			get.add(root.key);
		}
		else
			get.add(root.key);


		m.put(hd, get);
		getVertical(root.left, hd-1, m);
		getVertical(root.right, hd+1, m);
	}

	public static void printVT(Node root)
	{
		TreeMap<Integer, Vector<Integer>> m = new TreeMap<>();
		int hd = 0;
		getVertical(root, hd, m);

		for(Entry<Integer, Vector<Integer>>  entry: m.entrySet())
		{
			System.out.println(entry.getValue());
		}
	}

	public static void main(String args[])
	{
		root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVT(root);
	}
}