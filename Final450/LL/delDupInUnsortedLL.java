class delDupInUnsortedLL
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
         HashSet<Integer> hs = new HashSet<>();
         hs.add(head.data);
         Node node = head;
         while(node.next!= null)
         {
             Node val = node.next;
             if(hs.contains(val.data))
             {
                 node.next = node.next.next;
             }
             else
             {
                 hs.add(val.data);
                 node = node.next;
             }
         }
         
         return head;
    }
}