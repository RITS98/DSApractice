//Given a linked list, check if the linked list has loop or not.
/*
Floyd’s Cycle-Finding Algorithm 
Approach: This is the fastest method and has been described below: 
 

Traverse linked list using two pointers.
Move one pointer(slow_p) by one and another pointer(fast_p) by two.
If these pointers meet at the same node then there is a loop. 
If pointers do not meet then linked list doesn’t have a loop.

*/

/* Counting the length of loop
Approach: It is known that Floyd’s Cycle detection algorithm terminates when fast and 
slow pointers meet at a common point. It is also known that this common point is one of the loop nodes.
Store the address of this common point in a pointer variable say (ptr). Then initialize a counter with
1 and start from the common point and keeps on visiting the next node and increasing the counter 
till the common pointer is reached again.
At that point, the value of the counter will be equal to the length of the loop.

Algorithm:

Find the common point in the loop by using the Floyd’s Cycle detection algorithm
Store the pointer in a temporary variable and keep a count = 0
Traverse the linked list until the same node is reached again and increase the count while moving to next node.
Print the count as length of loop

*/


import java.util.*;
public class detectLoop extends linked
{
    public int  countNodes(Node temp)
    {
        int count = 1;
        Node n = temp;

        while(n.next != temp)
        {
            n = n.next;
            count++;
        }

        return count;
    }
    public void loop()
    {
        Node slow = head;
        Node fast = head;
        int len = 0;
        int flag = 0;
        while(slow !=  null && fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                flag = 1;
                len = countNodes(slow);
                break;
            }
        }


        if(flag == 1)
        System.out.println("There is a loop : Size - " + len);
        else
        System.out.println("No loop ");
    }

    public static void main(String args[])
    {
        detectLoop ob = new detectLoop();

        ob.append(1);
        ob.append(2);
        ob.append(8);
        ob.push(5);

       ob.head.next.next.next.next = ob.head;

        ob.loop();
    }
    
}
