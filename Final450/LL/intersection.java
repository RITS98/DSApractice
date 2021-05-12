class intersection
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
	    Node left = head1;
	    Node right = head2;
	    if(head1 == null || head2 == null)
	    return -1;
	    
	    int count = 0;
         while(left != right)
         {
             left = left.next;
             right = right.next;
             
             if(left == right)
             return left.data;
             
             if(left == null )
             {
                 left = head2;
                 count++;
             }
             
             if(right == null)
             {
                 right = head1;
                 count++;
             }
             
             if(count>2)
             return -1;
         }
         
         return -1;
	}
}