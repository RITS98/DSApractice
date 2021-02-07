import java.util.*;
public class sortStack
{
    public static void sort(Stack<Integer> st)
    {
        Stack<Integer> temp = new Stack<Integer>();
        while(!st.isEmpty())
        {
            int t = st.pop();
            while(!temp.isEmpty() && temp.peek()>t)
            {
                st.push(temp.pop());
            }
            temp.push(t);
        }

        System.out.println(temp);
    }

    public static void main(String[] args) {
        
        Stack<Integer> st = new Stack<Integer>();
        st.push(34);
        st.push(3);
        st.push(31);
        st.push(98);
        st.push(10);
        st.push(25);

        sort(st);
    }
}