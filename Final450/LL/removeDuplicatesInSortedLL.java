class removeDuplicatesInSortedLL
{
    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head)
    {
	    Node node = head;
	    
	    while(node != null)
	    {
	        if(node.next!= null && node.data == node.next.data)
	        {
	            node.next = node.next.next;
	        }
	        else
	        {
	            node = node.next;
	        }
	    }
	    
	    return head;
    }
}
