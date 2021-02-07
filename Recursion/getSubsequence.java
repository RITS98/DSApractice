import java.util.*;
public class getSubsequence
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sequence of string - ");
        String str = sc.nextLine();
        ArrayList<String> subsequence = getSS(str);
        Collections.sort(subsequence);
        System.out.println("All subsequence are \n"+subsequence);
    }

    public static ArrayList<String> getSS(String str)
    {
        if(str.length() == 0)
        {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rr = getSS(ros);
        ArrayList<String> mr = new ArrayList<String>();

        for(String rrs: rr)
        {
            mr.add(rrs);
            mr.add(ch+rrs);
        }

        return mr;
    }
}