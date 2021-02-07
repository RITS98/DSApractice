import java.util.*;
public class BalancingSymbol 
{
    public static String checkBalance(String exp)
    {
        Stack<Character> st = new Stack<Character>();

        for(int i = 0; i< exp.length(); i++)
        {
            char c = exp.charAt(i);
            if(c == '[' || c=='(' || c=='{')
            st.push(c);
            else
            {
                if((c == ')' && st.peek() == '(') || (c == '}' && st.peek() == '{') || (c == ']' && st.peek() == '['))
                st.pop();
                else
                return "Unbalanced Expression";

            }
        }
        if(st.isEmpty())
        return "Balanced Expression";
        else
        return "Unbalanced Expression";
    }

    public static void main(String args[])
    {
        String exp = "[()]{}{[()())]()}";
        System.out.println(checkBalance(exp));
    }
    
}
