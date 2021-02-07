import java.util.*;

public class LLdelEntire extends linked
{
    public void deleteLL()
    {
        head = null;
    }

    public static void main(String[] args)
    {
        LLdelEntire ob = new LLdelEntire();
        ob.append(5);
        ob.append(9);
        ob.push(9);
        ob.push(7);

        System.out.println("The whole LL - ");
        ob.printList();
        System.out.println();

        ob.deleteLL();

        try
        {
            System.out.println("The whole List after deleting - \n");
            ob.printList();
            System.out.println("\n");
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println("\n\n Execution complete \n");
        }
        
    }
}