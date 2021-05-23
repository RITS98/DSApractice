import java.io.*;
import java.util.*;

public class largestSubtree
{
	static class Node
	{
		int data;
		Node left, right;

		Node(int data)
		{
			this.data = data;
			left = right = null;
		}
	}


	static maxSum = Integer.MIN_VALUE;
	public int findLargestSum(Node root)
	{
		if(root == null)
			return 0;
		
		int currSum = root.data + findLargestSum(root.left) + findLargestSum(root.right);

		maxSum = Math.max(maxSum, currSum);

		return currSum;
	}

	public int findLargestSumFind(Node root)
	{
		if(root == null)
			return 0;

		findLargestSum(root);

		return maxSum;
	}

	public static void main(String args[])
	{
		Node root = newNode(1); 
	    root.left = newNode(-2); 
	    root.right = newNode(3); 
	    root.left.left = newNode(4); 
	    root.left.right = newNode(5); 
	    root.right.left = newNode(-6); 
	    root.right.right = newNode(2); 

	    System.out.println(findLargestSumFind(root));
	}
}