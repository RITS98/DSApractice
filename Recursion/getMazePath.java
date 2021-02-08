import java.util.*;
public class getMazePath
{
    public static ArrayList<String> getMazePath(int cc, int cr, int ec, int er)
    {
        ArrayList<String> br = new ArrayList<>();
        if(cc == ec && cr == er)
        {
            br.add("");
            return br;
        }
        if(cc > ec || cr > er)
        return br;

        ArrayList<String> mr = new ArrayList<>();
        for(int i = 1;i<=2;i++)
        {
            if(i == 1)
            {
                ArrayList<String> rr = getMazePath(cc + 1, cr, ec, er);
                for(String ss: rr)
                mr.add("H"+ss);
            }
            else
            {
                ArrayList<String> rr = getMazePath(cc, cr+1, ec, er);
                for(String ss:rr)
                mr.add("V"+ss);
            }
        }

        return mr;

    }

    public static void main(String args[])
    {
        System.out.println(getMazePath(0, 0, 2, 2));
    }
}