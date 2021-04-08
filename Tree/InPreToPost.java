import java.util.*; 

interface Func{
    int value(int arr[],int first,int n);
}
public class InPreToPost
{ 

    // Prints postorder traversal from 
    // given inorder and preorder traversals 
    static void printPostOrder(int in1[], int pre[], int n) 
    { 
        // The first element in pre[] is 
        // always root, search it in in[] 
        // to find left and right subtrees 
        Func search = (arr,first,len) -> {

            for (int i = 0; i < len; i++) 
            if (arr[i] == first) 
                return i; 
            return -1; 
        };

        int root = search.value(in1, pre[0], n); 

        // If left subtree is not empty, 
        // print left subtree 
        if (root != 0) 
            printPostOrder(in1, Arrays.copyOfRange(pre, 1, n), root); 

        // If right subtree is not empty, 
        // print right subtree 
        if (root != n - 1) 
            printPostOrder(Arrays.copyOfRange(in1, root+1, n),Arrays.copyOfRange(pre, 1+root, n), n - root - 1); 
        
        System.out.print( pre[0] + " "); 
    } 

    // Driver code 
    public static void main(String args[]) 
    { 
        int in1[] = { 4, 2, 5, 1, 3, 6 }; 
        int pre[] = { 1, 2, 4, 5, 3, 6 }; 
        int n = in1.length; 
        System.out.println("Postorder traversal " ); 
        printPostOrder(in1, pre, n); 

        System.out.println();
    } 
} 

