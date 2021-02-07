import java.util.*;

class inorderWithoutRecursion extends Btree
{
    public static void inorder(Node curr)
    {
        if(curr == null)
        return;

        Stack<Node> s = new Stack<Node>();
        Node root = curr;
        while(root != null || s.size()>0)
        {
            while(root != null)
            {
                s.push(root);
                root = root.left;

            }

            root = s.pop();
            System.out.print(root.key+" -> ");
            root = root.right;

        }

    }

    public static void main(String args[]) 
    { 
  
        /* creating a binary tree and entering 
        the nodes */
        inorderWithoutRecursion tree = new inorderWithoutRecursion(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.inorder(root); 
        System.out.println("NULL\n");
    } 
}