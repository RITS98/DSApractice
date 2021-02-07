import java.util.*;
public class detectRemoveLoop
{
	static Node head;
	static class Node
	{
		int data,flag;
		Node next;
		Node(int data)
		{
			this.data=data;
			flag = 0;
			next = null;
		}
	}

	public void detectRemove()
	{
		Node temp = head;
		while(true)
		{
			if(temp == null)
			{
				System.out.println("No Loop Present");
				break;
			}

			if(temp.next.flag == 1)
			{
				System.out.println("Loop Detected at "+temp.next.data);
				System.out.println("Loop Broken");
				temp.next = null;
				break;
			}

			temp.flag = 1;
			temp = temp.next;
		}

	} 
	void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("NULL\n");
    }

	public static void main(String args[])
	{
		detectRemoveLoop list = new detectRemoveLoop();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);
 
        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        list.detectRemove();
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
	}
}