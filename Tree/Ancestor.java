import java.io.*;
import java.util.*;

public class Ancestor
{
	public static boolean findAnces(Node root, int target, ArrayList<Integer> arr)
	{
		if(root == null)
			return false;

		if(root.data == target)
			return true;

		if(findAnces(root.left, target) || findAnces(root.right, target))
		{
			arr.add(root.data);
			return true;
		}

		return false;
	}

	public static findAncestor(Node root, int data)
	{
		ArrayList<Integer> arr = new ArrayList<>();
		if(root == null)
			return arr;

		findAnces(root, data, arr);
		return arr;
	}
}