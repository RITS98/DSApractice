//Find Length of a Linked List (Iterative and Recursive)

import java.util.*;
public class LLlength extends linked
{
    public void lengthiter()
    {
        Node temp = head;
        int count =0;
        while(temp != null)
        {
            count++;
            temp = temp.next;
        }

        System.out.println("Total elements in LL (iterative) : " + count);
    }

    public int lengthrecur(Node temp)
    {
        if(temp == null)
        return 0;

        return 1 + lengthrecur(temp.next);
    }

    public static void main(String args[])
    {
        LLlength obj =new LLlength();
        obj.append(1);
        obj.append(2);
        obj.append(3);
        obj.append(5);
        obj.append(6);

        System.out.println("The LL - ");
        obj.printList();
        System.out.println("\n");

        obj.lengthiter();
        System.out.println("Length - " + obj.lengthrecur(obj.head));
    }
    
}
