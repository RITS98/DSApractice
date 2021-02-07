//Search an element in a Linked List (Iterative and Recursive)
//Fetch Nth element from front as well as end of linked list
import java.util.*;
public class LLsearch extends linked
{
    public void searchIter(int data)
    {
        Node temp = head;
        while(temp != null && temp.data != data)
        {
            temp = temp.next;
        }

        if(temp == null)
        System.out.println("Not Found (iterative)");
        else
        System.out.println("Found (iterative)");
    }

    public int searchRecur(Node temp,int data)
    {
        if(temp == null)
        {
            System.out.println("Not Found (Recursive)");
            return 0;

        }
        if(temp.data == data)
        {
            System.out.println("Found (Recursive)");
            return 1;
        }
        
        return searchRecur(temp.next,data);
    }

    public int getNthNodeRecur(Node temp,int n)
    {
        if(n == 1)
        return temp.data;
        if(temp == null)
        {
            return 0;
        }
        return getNthNodeRecur(temp.next, --n);
    }
    //Using Double Pointer
    public int getNthNodeEnd(int n)
    {
        Node t1 = head, t2 = head;
        int count = 0;
        while(count < n && t2 != null)
        {
            count ++;
            t2 = t2.next;
        }

        if(count != n && t2 == null)
        {
            return 0;
        }

        while(t2 != null)
        {
            t2 = t2.next;
            t1 = t1.next;
        }

        return t1.data;
    }
    public static void main(String args[])
    {
        LLsearch obj = new LLsearch();
        obj.append(1);
        obj.append(2);
        obj.append(3);
        obj.append(4);
        obj.append(5);

        System.out.println("The list - ");
        obj.printList();
        System.out.println("\n");

        obj.searchIter(3);
        obj.searchIter(6);

        obj.searchRecur(obj.head, 2);
        obj.searchRecur(obj.head, 7);

        int ele = obj.getNthNodeRecur(obj.head, 8);
        if(ele == 0)
        System.out.println("Nth element - Not present as size is less than n" );
        else
        System.out.println("Nth element - : - " + ele);


        int num = obj.getNthNodeEnd(5);
        if(num != 0)
        System.out.println("Nth element from the end - " + num);
        else
        System.out.println(" Size is less than N ");
    }
    
}
