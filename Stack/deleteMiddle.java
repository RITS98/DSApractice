/*Given a stack with push(), pop(), empty() operations, 
delete middle of it without using any additional data structure.

Input  : Stack[] = [1, 2, 3, 4, 5]
Output : Stack[] = [1, 2, 4, 5]

Input  : Stack[] = [1, 2, 3, 4, 5, 6]
Output : Stack[] = [1, 2, 4, 5, 6]
*/

import java.util.*;
public class deleteMiddle
{
    public static void delete(Stack<Integer> st,int n, int curr)
    {
        if(st.isEmpty() || curr == n)
        return;
        
        int x = st.pop();
        delete(st,n,curr+1);

        if(curr != n/2)
        st.push(x);
 
    }
    public static void main(String args[])
    {
        Stack<Integer> st = new Stack<Integer>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        delete(st, st.size(), 0);
        System.out.println(st);
    }
}