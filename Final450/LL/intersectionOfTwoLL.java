class intersectionOfTwoLL
{
   public static Node findIntersection(Node head1, Node head2)
    {
        Node one = head1, two = head2;
        Node newStart = null, newEnd = null;
        
        while(one!=null && two!=null)
        {
            if(one.data == two.data)
            {
                if(newStart == null)
                {
                    newStart = new Node(one.data);
                    newEnd = newStart;
                }
                else
                {
                    newEnd.next = new Node(one.data);
                    newEnd = newEnd.next;
                }
                
                one = one.next;
                two = two.next;
            }
            else if(one.data < two.data)
            {
                one = one.next;
            }
            else
            {
                two = two.next;
            }
        }
        
        return newStart;
    }
}