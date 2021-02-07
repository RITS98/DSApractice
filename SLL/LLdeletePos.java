//Given a singly linked list and a position, delete a linked list 
//node at the given position

public class LLdeletePos extends linked {

    public static void deleteNodePosition(Node head,int pos)
    {
        if(head == null)
        {
            return;
        }
        Node temp = head, prev = null;
        if(pos == 1)
        {
            head = temp.next;
            return;
        }

        while(pos > 1 && temp != null)
        {
            prev = temp;
            temp = temp.next;
            pos -- ;
        }

        prev.next = temp.next;
    }

    public static void main(String args[])
    {
        linked ob = new linked();
        ob.append(5);
        ob.push(6);
        ob.append(1);
        ob.push(9);

        System.out.print("Printing the LL - ");
        ob.printList();
        System.out.println("\n");
        deleteNodePosition(ob.head,4);
        System.out.println("\n Printing after deleting the element  - ");
        ob.printList();
        System.out.println("\n");
        
        
    }
    
}
