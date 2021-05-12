import java.util.regex.*;
import java.util.*;
import java.io.*;

public class regex3
{
    public static void main(String args[])
    {
        String regex = "(?=^255).*";
        Pattern pattern = Pattern.compile(regex);
        String candidate = "255.0.0.1";
        Matcher matcher = pattern.matcher(candidate);
        String ip = "not found";
        if (matcher.find())
        ip = matcher.group();
        String msg = "ip: " + ip;
        System.out.println(msg+"\n-----------------------");


        regex = "John (?!Heins)[A-Z]\\w+";

        pattern = Pattern.compile(regex);
        candidate = "I think that John Heins ";
        candidate += "is a fictional character. His real name ";
        candidate += "might be John Jackson, John Westling, ";
        candidate += "or John Holmes for all we know.";
        matcher = pattern.matcher(candidate);
        String tmp = null;
        while (matcher.find()) 
        {
            tmp = matcher.group();
            System.out.println("MATCH:" + tmp);
        }
        System.out.println("\n------------------------");

        String reg = "(?<=http://)\\S+";

        Pattern p = Pattern.compile(reg);
        String str = "http://www.a.com. My name";
        Matcher m = p.matcher(str);

        msg="";
        while (m.find()) 
        {
            msg = ":" + m.group() + ":";
            System.out.println(msg);
        }

        System.out.println("\n--------------------------");
        p = Pattern.compile("(?<!Y.{0,40})X");
        String txt = "Y less than 40 before X"; // Since you want 'not' then this should fail to match.
        m = p.matcher(txt);
        System.out.println(m.find());
        txt = "Y less ddddddddddddddddddddddddd than 40 before X"; // Since you want 'not' this should match
        m.reset(txt);
        System.out.println(m.find());

        System.out.println("\n-----------------------------");
    }
}