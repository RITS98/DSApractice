import java.util.*;
class reverseStack
{
    static Stack<Integer> st = new Stack<Integer>();
    public static void insertAtbottom(int a)
    {
        if(st.isEmpty())
        st.push(a);

        else
        {
            int x = st.peek();
            st.pop();
            insertAtbottom(a);
            st.push(x);
        }
    }

    public static void reverse()
    {
        if(st.size()>0)
        {
            int num = st.peek();
            st.pop();
            System.out.println(st);
            reverse();
            System.out.println(st);
            insertAtbottom(num);
        }
    }

    public static void main(String args[])
    {
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        System.out.println("Original Stack - ");
        System.out.println(st);

        reverse();

        System.out.println("Reversed Stack - ");
        System.out.println(st);
    }
}