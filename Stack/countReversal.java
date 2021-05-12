/*
Given an expression with only ‘}’ and ‘{‘. The expression may not be balanced. Find minimum number of bracket reversals to make the expression balanced.
Examples: 

Input:  exp = "}{"
Output: 2
We need to change '}' to '{' and '{' to
'}' so that the expression becomes balanced, 
the balanced expression is '{}'

Input:  exp = "{{{"
Output: Can't be made balanced using reversals

Input:  exp = "{{{{"
Output: 2 

Input:  exp = "{{{{}}"
Output: 1 

Input:  exp = "}{{}}{{{"
Output: 3


An Efficient Solution can solve this problem in O(n) time. The idea is to first remove all balanced part of expression. For example, convert “}{{}}{{{” to “}{{{” by removing highlighted part. If we take a closer look, we can notice that, after removing balanced part, we always end up with an expression of the form }}…}{{…{, an expression that contains 0 or more number of closing brackets followed by 0 or more numbers of opening brackets. 
How many minimum reversals are required for an expression of the form “}}..}{{..{” ?. Let m be the total number of closing brackets and n be the number of opening brackets. We need ⌈m/2⌉ + ⌈n/2⌉ reversals. For example }}}}{{ requires 2+1 reversals.


*/

class countReversal
{
    int countRev (String s)
    {
        Stack<Character> st = new Stack<>();
        int l = s.length();
        if(l%2 != 0)
        return -1;
        for(int i = 0;i<l;i++)
        {
            char c = s.charAt(i);
            
            if(c=='{')
            st.push(c);
            else
            {
                if(!st.isEmpty() && st.peek() == '{')
                st.pop();
                else
                st.push(c);
            }
        }
        
        int si = st.size();
        int n = 0;
        for(int i = 0;i<si;i++)
        {
            if(st.peek() == '{')
            n++;
            
            st.pop();
        }
        
        int m = si - n;
        
        return (int)Math.ceil(m/2.0)+(int)Math.ceil(n/2.0);
    }
}