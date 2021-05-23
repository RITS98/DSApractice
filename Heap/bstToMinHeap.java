// Java implementation to convert the given
// BST to Min Heap


/*

Create an array arr[] of size n, where n is the number of nodes in the given BST.
Perform the inorder traversal of the BST and copy the node values in the arr[] in sorted order.
Now perform the preorder traversal of the tree.
While traversing the root during the preorder traversal, one by one copy the values from the array arr[] to the nodes.

*/
import java.util.ArrayList;

class bstToMinHeap {
	
	static class Node{


		int data;
		Node left,right;
		
		// Constructor
		Node(){
			this.data = 0;
			this.left = this.right = null;
		}

		Node(int data)
		{
			this.data = data;
			this.left = this.right = null;

		}
	}


	private static void preOrder(Node root)
	{
		if(root==null)
			return ;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	private static void bstToArray(Node root, ArrayList<Integer> arr){
	// ArrayLIst stores elements in inorder fashion
		if(root==null)
			return;
		
			bstToArray(root.left, arr);
		
			arr.add(root.data);
		
			bstToArray(root.right, arr);


	}

	static int index = 0;
	private static void arrToMinHeap(Node root, ArrayList<Integer> arr){
		if(root== null)
			return;
		root.data = arr.get(index++);

		arrToMinHeap(root.left, arr);
		arrToMinHeap(root.right, arr);

		
	}
	static void convertToMinHeap(Node root)
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		bstToArray(root, arr);
		
		arrToMinHeap(root,arr);


	}

	
// Driver program to test above
public static void main(String[] args)
{
	
	// BST formation
	Node root = new Node(4);
	root.left = new Node(2);
	root.right = new Node(6);
	root.left.left = new Node(1);
	root.left.right = new Node(3);
	root.right.left = new Node(5);
	root.right.right = new Node(7);
	
	System.out.print("Preorder Traversal Before Conversion :" +"\n");
	preOrder(root);
	convertToMinHeap(root);
	
	System.out.print("\nPreorder Traversal After Conversion :" +"\n");
	preOrder(root);

	}
}

// Contributed by : @mahi_07

/*
Tip : If interviewer ask not to use global index variable you can use LinkedList Instead of ArrayList
	and use LinkedList's removeFirst() method
	So instead of this
		root.data = arr.get(index++);
	you can write
		root.data = list.removeFirst();
	Do not forget to initialize list in converttoMinHeap function
*/
