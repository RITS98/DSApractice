/*Given a singly linked list, write a function to swap elements pairwise. 
For example, if the linked list is 1->2->3->4->5->6->7 then the function should change it 
to 2->1->4->3->6->5->7, 
and if the linked list is 1->2->3->4->5->6 
then the function should change it to 2->1->4->3->6->5

*/


import java.util.*;

public class pairwiseSwap extends linked 
{
    Node pairWiseSwap(Node node)
    {
 
        // Base Case: The list is empty or has only one node
        if (node == null || node.next == null) {
            return node;
        }
 
        // Store head of list after two nodes
        Node remaing = node.next.next;
 
        // Change head
        Node newhead = node.next;
 
        // Change next of second node
        node.next.next = node;
 
        // Recur for remaining list and change next of head
        node.next = pairWiseSwap(remaing);
 
        // Return new head of modified list
        return newhead;
    }
    public void swapNodes()
    {
        Node node = head;
        if (node == null || node.next == null) {
            return ;
        }
        // Initialize previous and current pointers
        Node prev = node;
        Node curr = node.next;
        node = curr; // Change head before proceeeding
        // Traverse the list
        while (true) {
            Node next = curr.next;
            curr.next = prev; // Change next of current as previous node
            // If next NULL or next is the last node
            if (next == null || next.next == null) {
                prev.next = next;
                break;
            }
            // Change next of previous to next next
            prev.next = next.next;
            // Update previous and curr
            prev = next;
            curr = prev.next;
        }
        head = node;
    }
    public static void main(String args[])
    {
        pairwiseSwap ob = new pairwiseSwap();
        ob.append(1);
        ob.append(2);
        ob.append(3);
        ob.append(4);
        ob.append(5);
        ob.append(6);
        ob.append(7);

        System.out.println("Original Linked List - ");
        ob.printList();
        System.out.println();
        System.out.println("Pairwise Swapped List - ");
        ob.swapNodes();
        ob.printList();
        System.out.println("\n");

        ob.head = ob.pairWiseSwap(ob.head);
        ob.printList();
        System.out.println("\n");
    }
}
