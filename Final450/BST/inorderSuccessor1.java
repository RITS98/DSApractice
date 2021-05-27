//https://www.techiedelight.com/set-next-pointer-inorder-successor-binary-tree/

 
class inorderSuccessor1
{
    // Function to set the next pointer of all nodes in a binary tree.
    // `curr` —> current node
    // `prev` —> previously processed node

    static class Node
    {
        int data;
        Node left = null, right = null, next = null;
     
        Node(int data) {
            this.data = data;
        }
    }
    public static Node setNextNode(Node curr, Node prev)
    {
        // return if the tree is empty
        if (curr == null) {
            return prev;
        }
 
        // recur for the left subtree
        prev = setNextNode(curr.left, prev);
 
        // set the previous node's next pointer to the current node
        if (prev != null) {
            prev.next = curr;
        }
 
        // update the previous node to the current node
        prev = curr;
 
        // recur for the right subtree
        return setNextNode(curr.right, prev);
    }
 
    // Function to print inorder successor of all nodes of
    // binary tree using the next pointer
    public static void inorderSuccessor(Node curr)
    {
        Node prev = null;
 
        // set next pointer of all nodes
        setNextNode(curr, prev);
 
        // go to the leftmost node
        curr = curr.left.left;
 
        // print inorder successor of all nodes
        while (curr.next != null)
        {
            System.out.println("The inorder successor of " + curr.data + " is "
                                + curr.next.data);
            curr = curr.next;
        }
    }
 
    public static void main(String[] args)
    {
        /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             /      /  \
            /      /    \
           4      5      6
                 / \
                /   \
               7     8
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        inorderSuccessor(root);
    }
}