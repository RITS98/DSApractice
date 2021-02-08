import java.util.*;
public class getMazePathDiagonal
{
    public static ArrayList<String> getMazePathD(int cc, int cr, int ec, int er)
    {
        ArrayList<String> br = new ArrayList<>();
        if(cc == ec && cr ==er)
        {
            br.add("");
            return br;
        }

        if(cc>ec || cr>er)
        return br;

        String path[] = {"H","V","D"};
        ArrayList<String> mr = new ArrayList<>();
        for(String ss : path)
        {
            ArrayList<String> rr;
            if(ss.equals("H"))
            rr = getMazePathD(cc+1, cr, ec, er);
            else if(ss.equals("V"))
            rr = getMazePathD(cc, cr+1, ec, er);
            else
            rr = getMazePathD(cc+1, cr+1, ec, er);

            for(String str: rr)
            mr.add(ss+str);

        }
        return mr;
    }

    public static void main(String args[])
    {
        long startime = System.currentTimeMillis();
        System.out.println(getMazePathD(0,0,2,2));
        System.out.println(System.currentTimeMillis() - startime);

    }
}