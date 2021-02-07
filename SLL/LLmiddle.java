//Given a singly linked list, find middle of the linked list.


/*Method 1: 
Traverse the whole linked list and count the no. of nodes. Now traverse the list again till count/2 and return the node at count/2. 

Method 2: 
Traverse linked list using two pointers. Move one pointer by one and other pointer by two. When the fast pointer reaches end 
slow pointer will reach middle of the linked list.


*/


import java.util.*;
public class LLmiddle extends linked
{
    public void getMiddle()
    {
        Node temp = head;
        Node twice = head;

        if(head != null)
        {
            while(twice != null && twice.next != null)
            {
                twice = twice.next.next;
                temp = temp.next;
            }

            System.out.println("Middle element - - > " + temp.data);
        }
        System.out.println("Head is empty!!!");
    }

    public static void main(String args[])
    {
        LLmiddle ob = new LLmiddle();
        ob.append(5);
        ob.append(9);
        ob.append(8);
        ob.append(1);
        ob.append(2);

        ob.getMiddle();
    }
    
}
