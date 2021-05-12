class pairwiseSwap 
{
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head)
    {
        if(head == null || head.next == null)
        return head;
        
        Node val = head.next;
        head.next = head.next.next;
        val.next = head;
        head = val;
        
        Node node = head.next;
        while(node.next!=null && node.next.next != null)
        {
            Node two = node.next.next;
            Node one = node.next;
            
            node.next = two;
            one.next = two.next;
            two.next = one;
            
            node = node.next.next;
        }
        
        return head;
    }
}