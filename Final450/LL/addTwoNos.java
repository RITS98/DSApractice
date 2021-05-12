//https://leetcode.com/problems/add-two-numbers/submissions/
//Correct Solution
class addTwoNos {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        int count = 0;
        while(l1!=null && l2!=null)
        {
            int val = l1.val+l2.val+count;
            if(val>=10)
                count = 1;
            else
                count = 0;
            val = val%10;
            
            node.next = new ListNode(val, null);
            l1 = l1.next;
            l2=l2.next;
            node = node.next;
        }
        while(l1!=null)
        {
            int val = l1.val+count;
            if(val>=10)
                count = 1;
            else
                count = 0;
            val = val%10;
            
            node.next = new ListNode(val, null);
            l1=l1.next;
            node = node.next;
        }
        while(l2!=null)
        {
            int val = l2.val+count;
            if(val>=10)
                count = 1;
            else
                count = 0;
            val = val%10;
            
            node.next = new ListNode(val, null);
            l2=l2.next;
            node = node.next;
        }
        if(count == 1)
        {
            node.next = new ListNode(1, null);
            node = node.next;
        }
        
        return head.next;
    }
}