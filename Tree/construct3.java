// given inordr and levelOrder

import java.util.HashMap;
import java.util.Map;

class construct3 {

	public static Node buildTree(int[] inOrder, int[] levelOrder, int start, int end) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = start; i <= end; i++) {
			map.put(inOrder[i], i);
		}
		return constructTree(inOrder, levelOrder, start, end, map);
	}
	
	private static Node constructTree(int[] inOrder, int[] levelOrder, int inStart, int inEnd,
			Map<Integer, Integer> map) {
		if (inStart > inEnd) {
			return null;
		}
		int rootValue = levelOrder[0];
		Node root = new Node(rootValue);
		int index = map.get(rootValue);
		int[] leftLevel = extractLevel(levelOrder, inStart, index - 1, map);
		int[] rightLevel = extractLevel(levelOrder, index + 1, inEnd, map);
		root.left = constructTree(inOrder, leftLevel, inStart, index - 1, map);
		root.right = constructTree(inOrder, rightLevel, index + 1, inEnd, map);
		return root;
	}
	
	private static int[] extractLevel(int[] levelOrder, int start, int end, Map<Integer, Integer> map) {
		int[] level = new int[end - start + 1];
		int count = 0;
		for (int i = 0; i < levelOrder.length; i++) {
			int index = map.get(levelOrder[i]);
			if (index >= start && index <= end) {
				level[count++] = levelOrder[i];
			}
		}
		return level;
	}
	
	private static void printInorder(Node root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print("  " + root.data);
			printInorder(root.right);
		}
	}


	public static void main(String args[]) {
		int[] inOrder = { 4, 2, 5, 1, 6, 3, 7 };
		int[] levelOrder = { 1, 2, 3, 4, 5, 6, 7 };
		Node root = buildTree(inOrder, levelOrder, 0, inOrder.length - 1);
		System.out.println("inorder traversal of constructed tree : ");
		printInorder(root);
		System.out.println();
	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}
}