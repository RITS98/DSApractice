public class LLinsertDel 
{

    public static void main(String args[])
    {
        linked obj = new linked();
        obj.append(6);
        obj.push(7);
        obj.append(1);
        obj.push(5);
        obj.insertAfter(obj.head.next,3);

        System.out.println(" The Linked List - \n ");
        obj.printList();
        System.out.println("\n");

        obj.deleteNode(1);
        System.out.println(" AFTER DELETING 1 : - ");
        obj.printList();
        System.out.println("\n");
    } 
    
}
