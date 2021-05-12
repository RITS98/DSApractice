/*

Given a Cirular Linked List of size N, split it into two halves circular lists. If there are odd number of nodes in the given circular linked list then out of the resulting two halved lists, first list should have one node more than the second list. The resultant lists should also be circular lists and not linear lists.

 

Example 1:

Input:
Circular LinkedList: 1->5->7
Output:
1 5
7
 

Example 2:

Input:
Circular LinkedList: 2->6->1->5
Output:
2 6
1 5
*/


class splitCLLintoTwo
{
        // Function  to split a circular LinkedList
    void splitList(circular_LinkedList list)
    {
        Node slow = list.head;
        Node fast = list.head;
        
        if(list.head == null)
        {
            list.head1 = null;
            list.head2 = null;
        }
        else if(list.head.next == null)
        {
            list.head1 = list.head;
            list.head2 = null;
        }
        else
        {
            while(fast.next != list.head && fast.next.next!=list.head)
            {
                slow = slow.next;
                fast = fast.next.next;
            }
            
            list.head1 = list.head;
            list.head2 = slow.next;
            
            slow.next = list.head1;
            if(fast.next == list.head)
            fast.next = list.head2;
            else if(fast.next.next == list.head)
            fast.next.next = list.head2;
        }
        
    }
}