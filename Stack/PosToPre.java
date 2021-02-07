

import java.util.*;
class PosToPre
{
    public static boolean isOperand(char c)
    {
        return ((c >='a' && c<='z' )||(c>='A' && c<='Z'));
    }
    public static String change(String exp)
    {
        Stack<String> st = new Stack<String>();

        for(int i = 0;i<exp.length();i++)
        {
            if(isOperand(exp.charAt(i)))
            st.push(exp.charAt(i)+"");
            else
            {
                String op1 = st.pop();
                String op2 = st.pop();

                String res = exp.charAt(i)+op2+op1;
                st.push(res);
            }
        }

        return st.pop();
    }

    public static void main(String args[])
    {
        String e = "AB+CD-*";
        System.out.println(change(e));
        e = "ABC/-AK/L-*";
        System.out.println(change(e));
    }
}