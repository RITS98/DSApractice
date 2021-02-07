import java.util.*;

public class reverse extends doubleLinked
{
    public void reverseLL()
    {
        Node temp = null;
        Node curr = head;
        
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
 
        if (temp != null) {
            head = temp.prev;
        }
    }

    public static void main(String args[])
    {
        reverse dll = new reverse(); 

        dll.push(15);
        // Insert 6. So linked list becomes 6->NULL 
        dll.append(6); 
        // Insert 7 at the beginning. So linked list becomes 7->6->NULL 
        dll.push(7); 
        // Insert 1 at the beginning. So linked list becomes 1->7->6->NULL 
        dll.push(1); 
        // Insert 4 at the end. So linked list becomes 1->7->6->4->NULL 
        dll.append(4); 
        // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL 
        dll.insert(dll.head.next, 8);
        System.out.println("Created DLL is: "); 
        dll.printlist(dll.head); 

        dll.reverseLL();
        dll.printlist(dll.head);

    }
}