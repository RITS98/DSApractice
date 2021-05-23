import java.io.*;
import java.util.*;

//Construct tree from pree and post order traversal

public class construct1 extends Btree
{

	static int preIndex = 0;

	public static Node constructTree(int pre[] , int post[], int l, int h, int size)
	{
		if(preIndex >= size || l>h)
			return null;

		Node root = new Node(pre[preIndex]);
		preIndex++;

		if(l == h || preIndex >= size)
			return root;

		int i = l;
		for(;i<=h;i++)
		{
			if(pre[preIndex] == post[i])
				break;
		}

		if(i<=h)
		{
			root.left = constructTree(pre, post, l,i, size);
			root.right = constructTree(pre, post, i+1, h, size);
		}

		return root;
	}

	static void printInorder(Node root)
    {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.key + " ");
        printInorder(root.right);
    }
 
    public static void main(String[] args)
    {
 
        int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
        int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };
 
        int size = pre.length;
        Node root = constructTree(pre, post, 0, size - 1, size);
 
        System.out.println("Inorder traversal of the constructed tree:");
        printInorder(root);

	System.out.println();
    }
}
