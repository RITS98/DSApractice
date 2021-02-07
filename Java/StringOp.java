/*

Given a list of strings, write a method that returns a list of all strings that 
start with the letter 'a' (lower case) and have exactly 3 letters. 
TIP: Use Java 8 Lambdas and Streams API's.

*/


import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.io.*;

class StringOp
{
    public static List<String> search(List<String> list)
    {
        return list.stream()
                .filter(names -> names.startsWith("A"))
                .filter(names -> names.length()>5)
                .collect(Collectors.toList());
    }
    public static void main(String args[])throws Exception
    {
        Scanner sc= new Scanner(new FileReader("./country-keyword-list.csv"));
        List<String> li = new ArrayList<String>();
        while(sc.hasNextLine())
        {
            li.add(sc.nextLine().trim());
        }
        List<String> SpecificNames = search(li);

        SpecificNames.stream()
        .forEach(names -> System.out.print(names+" , "));

        System.out.println();
        sc.close();
    }
}