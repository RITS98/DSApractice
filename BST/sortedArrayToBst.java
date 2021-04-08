/*

Constructing from sorted array in O(n) time is simpler as we can get the middle element in O(1) time. Following is a simple algorithm where we first find the middle node of list and make it root of the tree to be constructed.

1) Get the Middle of the array and make it root.
2) Recursively do same for left half and right half.
      a) Get the middle of left half and make it left child of the root
          created in step 1.
      b) Get the middle of right half and make it right child of the
          root created in step 1.

*/

import java.io.*;
import java.util.*;

public class sortedArrayToBst
{
	static class Node
	{
		int key;
		Node right , left;
		Node(int key)
		{
			this.key = key;
			right = left = null;
		}
	}

	private static Node root;

	public static Node construct(int arr[], int start, int end)
	{
		if(start > end)
			return null;

		int mid = (start+end)/2;
		Node node = new Node(arr[mid]);

		node.left = construct(arr, start, mid-1);
		node.right = construct(arr, mid+1, end);

		return node;
	}

	public static void preOrder(Node node) 
	{
        if (node == null) 
        {
            return;
        }
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
      
    public static void main(String[] args) 
    {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        root = construct(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        preOrder(root);
        System.out.println();
    }
}