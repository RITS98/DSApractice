/*Given a string str, we need to print reverse of individual words.

Examples:

Input : Hello World
Output : olleH dlroW
 
Input :  Geeks for Geeks
Output : skeeG rof skeeG
*/
import java.util.*;
public class reverseIndividualWords
{
    public static String reverse(String s)
    {
        Stack<Character> st = new Stack<Character>();
        for(int i =0 ;i<s.length();i++)
        {
            st.push(s.charAt(i));
        }

        s = "";
        while(!st.isEmpty())
        {
            s += st.pop();
        }
        return s;

    }
    public static void words(String sen)
    {
        StringTokenizer st = new StringTokenizer(sen);
        String s = "";

        while(st.hasMoreTokens())
        {
            String w = reverse(st.nextToken());
            s = s + w + " ";
        }
        s=s.trim();
        System.out.println("Reversed Sentence :- " + s);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String sen  =sc.nextLine();
        words(sen);
    }
}