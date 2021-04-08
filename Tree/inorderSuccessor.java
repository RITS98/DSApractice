/*
Given a binary tree and a node, we need to write a program to find inorder successor of this node.

Inorder Successor of a node in binary tree is the next node in Inorder traversal of the Binary Tree. Inorder Successor is NULL for the last node in Inoorder traversal.

We need to take care of 3 cases for any node to find its inorder successor as described below:

Right child of node is not NULL. If the right child of the node is not NULL then the inorder successor of this node will be the leftmost node in it’s right subtree.
Right Child of the node is NULL. If the right child of node is NULL. Then we keep finding the parent of the given node x, say p such that p->left = x. For example in the above given tree, inorder successor of node 5 will be 1. First parent of 5 is 2 but 2->left != 5. So next parent of 2 is 1, now 1->left = 2. Therefore, inorder successor of 5 is 1.
Below is the algorithm for this case:
Suppose the given node is x. Start traversing the tree from root node to find x recursively.
If root == x, stop recursion otherwise find x recursively for left and right subtrees.
Now after finding the node x, recur­sion will back­track to the root. Every recursive call will return the node itself to the calling function, we will store this in a temporary node say temp.Now, when it back­tracked to its par­ent which will be root now, check whether root.left = temp, if not , keep going up
.

If node is the rightmost node. If the node is the rightmost node in the given tree. For example, in the above tree node 6 is the right most node. In this case, there will be no inorder successor of this node. i.e. Inorder Successor of the rightmost node in a tree is NULL.

//https://www.geeksforgeeks.org/inorder-succesor-node-binary-tree/
*/


// Java program to find inorder successor of a node
class inorderSuccessor
{
// A Binary Tree Node
static class Node
{
	int data;
	Node left, right;
}

// Temporary node for case 2
static Node temp = new Node();

// Utility function to create a new tree node
static Node newNode(int data)
{
	Node temp = new Node();
	temp.data = data;
	temp.left = temp.right = null;
	return temp;
}

// function to find left most node in a tree
static Node leftMostNode(Node node)
{
	while (node != null && node.left != null)
		node = node.left;
	return node;
}

// function to find right most node in a tree
static Node rightMostNode(Node node)
{
	while (node != null && node.right != null)
		node = node.right;
	return node;
}

// recursive function to find the Inorder Scuccessor
// when the right child of node x is null
static Node findInorderRecursive(Node root, Node x )
{
	if (root==null)
		return null;

	if (root==x || (temp = findInorderRecursive(root.left,x))!=null ||
				(temp = findInorderRecursive(root.right,x))!=null)
	{
		if (temp!=null)
		{
			if (root.left == temp)
			{
				System.out.print( "Inorder Successor of "+x.data);
				System.out.print( " is "+ root.data + "\n");
				return null;
			}
		}

		return root;
	}

	return null;
}

// function to find inorder successor of
// a node
static void inorderSuccesor(Node root, Node x)
{
	// Case1: If right child is not null
	if (x.right != null)
	{
		Node inorderSucc = leftMostNode(x.right);
		System.out.print("Inorder Successor of "+x.data+" is ");
		System.out.print(inorderSucc.data+"\n");
	}

	// Case2: If right child is null
	if (x.right == null)
	{	
		int f = 0;
		
		Node rightMost = rightMostNode(root);

		// case3: If x is the right most node
		if (rightMost == x)
			System.out.print("No inorder successor! Right most node.\n");
		else
			findInorderRecursive(root, x);
	}
}

// Driver program to test above functions
public static void main(String args[])
{
	// Let's con the binary tree
	// as shown in above diagram

	Node root = newNode(1);
	root.left = newNode(2);
	root.right = newNode(3);
	root.left.left = newNode(4);
	root.left.right = newNode(5);
	root.right.right = newNode(6);

	// Case 1
	inorderSuccesor(root, root.right);

	// case 2
	inorderSuccesor(root, root.left.left);

	// case 3
	inorderSuccesor(root, root.right.right);

}
}
