import java.util.*;
public class InfixToPrefix 
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

    public static String inToPre(String exp)
    {
        Stack<Character> st = new Stack<Character>();
        String res = "";
        StringBuffer sb = new StringBuffer(exp);
        sb.reverse();
        exp = sb.toString();
        // System.out.println(exp);
        for(int i=0;i<exp.length();i++)
        {
            // System.out.println(st);
            char c = exp.charAt(i);

            if(Character.isLetterOrDigit(c))
            res += c;
            else if(c == ')')
            st.push(c);
            else if(c == '(')
            {
                try
                {
                    while(!st.isEmpty() && st.peek() != ')')
                    res += st.pop();
                    st.pop();
                }
                catch(EmptyStackException e)
                {
                    System.out.println("Invalid Expression 2");
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
            if(st.peek() == ')')
            return "Invalid Expression1";

            res += st.pop();
        }
        sb = new StringBuffer(res);
        sb.reverse();
        res = sb.toString();
        return res;

    }

    public static void main(String args[])
    {
        String exp = "(A-B/C)*(A/K-L)";
        System.out.println(inToPre(exp));
    }

    
}
