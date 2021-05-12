import java.io.*;
import java.util.*;

public class LLops
{
	ListNode head;
	public static void push(int data)
	{
		if(head == null)
		{
			head = new ListNode(data);
			return;
		}	

		Node node = head;
		while(node.next != null)
			node = node.next;

		node.next = new ListNode(data);
	}
	public static void findSize(ListNode head)
	{
		ListNode node = head;
		int count = 0;
		while(node!=null)
		{
			count++;
			node = node.next;
		}

		System.out.println("Size Iterative - "+count);
		System.out.println("Size Recursive - "+ findSizeRecursive(head));
	}
	public static int findSizeRecursive(ListNode head)
	{
		if(head == null)
			return 0;

		return 1+findSizeRecursive(head.next);
	}
	public static void searchIterative(ListNode head, int key)
	{
		ListNode node = head;
		while(node != null)
		{
			if(node.data == key)
			{
				System.out.println("Found");
				break;
			}

			node = node.next;
		}
		searchRecursive(head, key);
	}
	public static void searchRecursive(ListNode head, int key)
	{
		if(head == null)
		{
			System.out.println("Not Found");
			return;
		}
		if(head.data == key)
		{
			System.out.println("Found Recursive");
			return;
		}

		return searchRecursive(head.next, key);
	}

}