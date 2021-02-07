/*
Simplify a given algebraic string of characters, ‘+’, ‘-‘ operators and parentheses. 
Output the simplified string without parentheses.

Examples:

Input : "a-(b+c)"
Output : "a-b-c"

Input : "a-(b-c-(d+e))-f"
Output : "a-b+c+d+e-f" 

The idea is to check operators just before starting of bracket, i.e., 
before character ‘(‘. If operator is -, we need to toggle all operators inside the bracket. 
A stack is used which stores only two integers 0 and 1 to indicate whether to toggle or not.
We iterate for every character of input string. Initially push 0 to stack.
Whenever the character is an operator (‘+’ or ‘-‘), check top of stack. 
If top of stack is 0, append the same operator in the resultant string. 
If top of stack is 1, append the other operator (if ‘+’ append ‘-‘) in the resultant string.
*/

import java.util.*;
class removeBrackets
{
    public static String remove(String exp)
    {
        int l = exp.length();
        char res[] = new char[l];
        int p = 0,i=0;
        Stack<Integer> st = new Stack<Integer>();
        st.push(0);
        while(i < l)
        {
            char c  = exp.charAt(i);
            if(c=='+')
            {
                if(st.peek() == 1)
                {
                    res[p++]='-';
                }
                else
                res[p++]='+';
            }
            else if(c == '-')
            {
                if(st.peek() == 1)
                res[p++]='+';
                else
                res[p++]='-';
            }
            else if(c == '(' && i>0)
            {
                if(exp.charAt(i-1)=='-')
                {
                    int x = st.peek() == 1?0:1;
                    st.push(x);
                }
                else if(exp.charAt(i-1) == '+')
                st.push(st.peek());
            }
            else if(c == ')')
            st.pop();
            else
            res[p++]=c;

            i++;
        }
        return new String(res);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter expression - - ");
        String s = sc.nextLine();

        System.out.println(remove(s));

    }
}