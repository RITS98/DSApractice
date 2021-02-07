import java.util.*;
public class LLreverse extends linked
{
    public void reverse()
    {
        Node prev = null, curr = head, nex = null;

        while(curr != null)
        {
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }

        head = prev;
    }

    public static void main(String args[])
    {
        LLreverse ob = new LLreverse();
        ob.append(1);
        ob.append(2);
        ob.append(3);
        ob.append(6);
        ob.append(9);

        ob.reverse();
        ob.printList();
        System.out.println("\n");
    }
}