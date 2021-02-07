/*Write a function that moves the last element to the front in a given Singly Linked List. 
For example, if the given Linked List is 1->2->3->4->5, 
then the function should change the list to 5->1->2->3->4.

Algorithm:
Traverse the list till last node. Use two pointers: one to store the address of last node and other for address of second last node. After the end of loop do following operations.
i) Make second last as last (secLast->next = NULL).
ii) Set next of last as head (last->next = *head_ref).
iii) Make last as head ( *head_ref = last)

*/

import java.io.*;

public class moveLastToFirst extends linked
{
    public void move()
    {
        Node pre = head;
        Node t = pre.next;

        while(t.next !=null)
        {
            pre=pre.next;
            t=t.next;
        }

        pre.next = null;
        t.next = head;
        head = t;
    }

    public static void main(String args[])throws IOException
    {
            moveLastToFirst ob = new moveLastToFirst();
            ob.append(1);
            ob.append(2);
            ob.append(3);
            ob.append(4);
            ob.append(5);
            ob.append(7);

            System.out.println("Original LL - ");
            ob.printList();
            System.out.println("\n Modified LL - ");
            ob.move();
            ob.printList();
            System.out.println("\n");
    }
}