import java.io.*;
import java.util.*;

public class redundantBrackets
{
	public static boolean redundant(String s)
	{
		Stack<Character> st = new Stack<>();

		for(char c:s.toCharArray())
		{
			if(c == ')')
			{
				char top = st.pop();

				boolean flag = true;
				System.out.println(flag+" - ----"+top);
				while(top!='(')
				{
					System.out.println(flag+" - "+top);
					if(top =='+' || top =='-' ||top=='*'||top=='/')
						flag = false;

					top = st.pop();
				}

				if(flag ==true)
					return true;
			}
			else
			{
				st.push(c);
			}
		}

		return false;

	}

	public static void main(String[] args) {
        String str = "((a+b))";
        System.out.println(redundant(str));
        System.out.println("-----------------");
 
        str = "(a+(b)/c)";
        System.out.println(redundant(str));
        System.out.println("-----------------");
 
        str = "(a+b*(c-d))";
        System.out.println(redundant(str));
        System.out.println("-----------------");
    }
}