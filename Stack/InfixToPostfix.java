import java.beans.Expression;
import java.util.*;
public class InfixToPostfix 
{
    public static int Prec(char c)
    {
        switch(c)
        {
            case '+':
            case '-':return 1;

            case '*':
            case '/':return 2;

            case '^':return 3;
        }

        return -1;
    }

    public static String infixToPostfix(String exp)
    {
        String res = "";

        Stack<Character> st = new Stack<Character>();

        for(int i = 0; i < exp.length(); i++)
        {
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c))
            res += c;
            else if(c == '(')
            st.push(c);
            else if(c == ')')
            {
                try
                {
                    while(!st.isEmpty() && st.peek() != '(')
                    res += st.pop();

                    st.pop();
                }
                catch(EmptyStackException e)
                {
                    System.out.println("Invalid Expression");
                    System.exit(1);
                }
                
            }
            else
            {
                while(!st.isEmpty() && Prec(c)<=Prec(st.peek()))
                res += st.pop();

                st.push(c);
            }

        }
        while(!st.isEmpty())
        {
            if(st.peek() == '(')
            return "Invalid Expression";
            res += st.pop();
        }

        return res;

        
    }
    public static void main(String args[])
    {
        String exp = "a+b*(c^d-e)^(f+g*h)-i"; 
        System.out.println(infixToPostfix(exp)); 
    }
}
