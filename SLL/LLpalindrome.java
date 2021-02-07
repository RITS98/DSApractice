//Given a singly linked list of characters,
// write a function that returns true if the given list is a palindrome, else false.
import java.util.*;
public class LLpalindrome extends linked
{
    public void palinCheck()
    {
        Node temp = head;
        Stack<Integer> st = new Stack<Integer>();
        while(temp != null)
        {
            st.push(temp.data);
            temp = temp.next;
        }
        System.out.println(st.search(9));
        temp = head;
        int flag = 0;
        while(temp != null)
        {
            if(temp.data == st.peek())
            st.pop();
            else
            {
                flag = 1;
                break;
            }

            temp = temp.next;
        }

        if(flag == 0)
        System.out.println("The Linked List is Palindrome  !!");
        else
        System.out.println("Not Palindrome");

        
        System.out.println("\n");
    }

    public static void main(String args[])
    {
        LLpalindrome ob = new LLpalindrome();

        ob.append(1);
        ob.append(2);
        ob.append(5);
        ob.append(3);
        ob.append(1);

        ob.palinCheck();

    }
    
}
