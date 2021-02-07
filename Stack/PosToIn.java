import java.util.*;
class PosToIn
{
    public static boolean operand(char x)
    {
        return (x>='a' && x<='z') || (x >='A' && x<='Z');
    }
    public static String change(String exp)
    {
        Stack<String> st = new Stack<String>();
        for(int i=0;i<exp.length();i++)
        {
            char c = exp.charAt(i);
            if(operand(c))
            st.push(c + "");
            else
            {
                String op1 = st.pop();
                String op2 = st.pop();
                st.push("("+op1+c+op2+")");
            }

        }
        return st.pop();
    }
    public static void main(String[] args) 
    {
        String exp = "ab*c+";
        System.out.println(change(exp));
    }
}