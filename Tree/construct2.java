//preordr and inorder is given

public class construct2 extends Btree
{
	static int preIndex = 0;
	public static Node constructTree(int in[], int pre[], int l, int h, int size)
	{
		if(l>h || preIndex>=size)
			return null;

		Node root = new Node(pre[preIndex]);
		preIndex++;

		if(l == h || preIndex>=size)
			return root;


		int i = l;
		for(;i<=h;i++)
		{
			if(in[i] == root.key)
				break;
		}

		if(l<=h)
		{
			root.left = constructTree(in, pre, l, i-1, size);
			root.right = constructTree(in, pre, i+1, h, size);
		}

		return root;
	}

	static void printInorder(Node node)
    {
        if (node == null)
            return;
 
        /* first recur on left child */
        printInorder(node.left);
 
        /* then print the data of node */
        System.out.print(node.key + " ");
 
        /* now recur on right child */
        printInorder(node.right);
    }
 
    // driver program to test above functions
    public static void main(String args[])
    {
        
        int in[] = new int[] { 'D', 'B', 'E', 'A', 'F', 'C' };
        int pre[] = new int[] { 'A', 'B', 'D', 'E', 'C', 'F' };
        int len = in.length;
        Node root = constructTree(in, pre, 0, len - 1, len);
 
        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        printInorder(root);
        System.out.println();
    }
}