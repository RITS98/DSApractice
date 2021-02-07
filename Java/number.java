/*

Write a method that returns a comma-separated string based on a given list of integers.
Each element should be preceded by the letter 'e' if the number is even, 
and preceded by the letter 'o' if the number is odd. 
For example, if the input list is (3,44), the output should be 'o3,e44'.

*/


import java.util.*;
import java.util.stream.*;
import java.io.*;

class number
{
    public static void main(String arg[])
    {
        ArrayList<Integer> ar = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9,10}));

        Func concate = (list) -> {

            return list.stream()
                .map(x -> x%2 == 0? "e"+x:"o"+x)
                .collect(Collectors.joining(","));
        };

        System.out.println("The Output ->  "+concate.concate(ar));

    }
}

interface Func{
    String concate(ArrayList<Integer> list);
}