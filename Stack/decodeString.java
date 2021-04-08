h/*
An encoded string (s) is given, the task is to decode it. The pattern in which the strings were encoded were as follows
original string: abbbababbbababbbab 
encoded string : "3[a3[b]1[ab]]".

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains a string s.

Output:
For each test case in a new line print the required decoded string.

Constraints:
1<=T<=10
1<=length of the string <=30

Example:
Input:
2
1[b]
3[b2[ca]]

Output:
b
bcacabcacabcaca
*/

// ***************** CORRECT SOLUTION ********************


import java.util.*;
import java.io.*;
class decodeString
{
public static void main (String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            Stack<Integer> st = new Stack<Integer>();
            Stack<String> w =new Stack<String>();
            Stack<Character> b = new Stack<Character>();
            String s = sc.nextLine();
            String m=" ",d="";
            for(int i = 0;i<s.length();i++)
            {
                char c=s.charAt(i);
                if(Character.isDigit(c))
                d=d+c;
                else if(Character.isLetter(c))
                m = m+c;
                else if(c == '[')
                {
                    b.push(c);
                    st.push(Integer.parseInt(d));
                    w.push(m);
                    d="";
                    m="";
                }
                else if(c==']')
                {

                    m = new String(new char[st.pop()]).replace("\0",m);
                    m = w.pop()+m;
                    b.pop();
                    if(b.isEmpty())
                    break;
                }
            }
            
            System.out.println(m.trim());
        }
    }
}