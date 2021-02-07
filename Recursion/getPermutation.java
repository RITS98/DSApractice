import java.lang.reflect.Array;
import java.util.*;
public class getPermutation
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sequence of string - ");
        String str = sc.nextLine();
        ArrayList<String> subsequence = getP(str);
        Collections.sort(subsequence);
        System.out.println("All permutations are \n"+subsequence);
    }

    public static ArrayList<String> getP(String str)
    {
        if(str.length()==0)
        {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rr = getP(ros);
        ArrayList<String> mr = new ArrayList<>();

        for(String s:rr)
        {
            for(int i = 0;i<=s.length();i++)
            {
                StringBuffer sb = new StringBuffer(s);
                sb.insert(i, ch);
                mr.add(sb.toString());
            }
        }

        return mr;
    }
}