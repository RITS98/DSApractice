public class isPalinLL
{
	//Iterative solution
	boolean isPalindrome(Node head) 
    {
        Stack<Integer> st = new Stack<>();
        Node slow = head;
        Node fast = head;
        st.push(slow.data);
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            st.push(slow.data);
        }
        
        if(fast.next == null)
        st.pop();
        
        while(slow != null && !st.isEmpty())
        {
            slow = slow.next;
            int val = st.pop();
            if(slow.data != val)
            return false;
            
            
            
        }
        
        return true;
        
    }

    //Recursive
    boolean isPalindromeRecur(Node right)
    {
    	Node left = head;

    	if(right == null)
    		return true;

    	boolean isp = isPalindromeRecur(right.next);
    	if(isp == false)
    		return false;

    	boolean isp1 = right.data == left.data;
    	left = left.next;

    	return isp1;
    }

}