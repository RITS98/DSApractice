import java.io.*;
import java.util.*;
public class getBoardPath
{
    public static void main(String args[])
    {
        int start = 0, end = 10;
        ArrayList<String> bpath = getBPath(start, end);
        for(String ss: bpath)
        {
            System.out.println(ss);
        }

        System.out.println("\n\n\n Possible sols = "+bpath.size());
    }

    public static ArrayList<String> getBPath(int start, int end)
    {
        if(start == end)
        {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        else if(start > end)
        {
            ArrayList<String> br = new ArrayList<>();
            return br;
        }
        ArrayList<String> mr = new ArrayList<>();
        for(int dice = 1;dice<=6;dice++)
        {
            ArrayList<String> rr = getBPath(start + dice, end);
            for(String ss: rr)
            mr.add(dice + ss);

        }

        return mr;

    }
}