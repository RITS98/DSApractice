import java.io.*;
import java.util.*;

class treeAnagram
{
	static class Node
	{
		Node left, right;
		int data;

		Node(int data)
		{
			this.data = data;
			left  = right = null;
		}
	}

	public static boolean areAnagrams(Node root1, Node root2)
	{
		if(root1==null && root2 == null)
			return true;
		if(root1==null || root2==null)
			return false;


		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();

		q1.add(root1);
		q2.add(root2);

		while(true)
		{
			int n1 = q1.size(), n2 = q2.size();

			if(n1!=n2)
				return false;

			if(n1==0)
				break;


			ArrayList<Integer> arr1 = new ArrayList<>();
			ArrayList<Integer> arr2 = new ArrayList<>();

			while(n1>0)
			{
				Node n11 = q1.poll();
				if(n11.left!=null)
					q1.add(n11.left);
				if(n11.right!=null)
					q1.add(n11.right);

				n1--;
				Node n22 = q2.poll();
				if(n22.left!=null)
					q2.add(n22.left);
				if(n22.right!=null)
					q2.add(n22.right);

				arr1.add(n11.data);
				arr2.add(n22.data);
			}

			Collections.sort(arr1);
			Collections.sort(arr2);


			if(!arr1.equals(arr2))
				return false;
		}

		return true;
	}

	public static void main(String args[])
    {
        // Constructing both the trees.
        Node root1 = new Node(1);
        root1.left = new Node(3);
        root1.right = new Node(2);
        root1.right.left = new Node(5);
        root1.right.right = new Node(4);
       
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
       
          
        System.out.println(areAnagrams(root1, root2)? "Yes" : "No");
    }
}