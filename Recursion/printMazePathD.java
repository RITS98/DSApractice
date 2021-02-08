import java.util.*;
public class printMazePathD
{
    public static void printMPD(int cc, int cr, int ec, int er, String ans)
    {
        if(cc == ec && cr==er)
        {
            System.out.println(ans);
            return;
        }
        if(cc>ec || cr > er)
        return;

        String path[] = {"H","V","D"};
        for(String ss: path)
        {
            if(ss.equals("H"))
            printMPD(cc+1, cr, ec, er, ans+"H");
            else if(ss.equals("V"))
            printMPD(cc, cr+1, ec, er, ans+"V");
            else
            printMPD(cc+1, cr+1, ec, er, ans+"D");
        }
    }

    public static void main(String args[])
    {
        printMPD(0, 0, 2, 2, "");
    }
}