import java.util.Arrays;

import java.util.*;
public class lambda 
{
    public static void main(String args[])
    {
        List<Person> people = Arrays.asList(
            new Person("Charles","Dickens",60),
            new Person("Lewis", "Carroll", 42),
            new Person("Thomas", "Carlyle", 51),
            new Person("MATTHEW", "Arnold", 39)
        );

        people.stream()
        .filter(p -> p.getLastName().startsWith("C"))
        .forEach(p -> System.out.println(p.getFirstName()));

        Integer arr[] = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayList<Integer> ar = new ArrayList<Integer>();
        Collections.addAll(ar, arr);
        ar.parallelStream()
        .filter(i -> i%2 == 0)
        .forEach(i -> System.out.println(i));


        ArrayList<String> st = new ArrayList<String>(Arrays.asList(new String[]{"Ritayan","MadaM","Pro","SaaS"}));
        st.stream()
        .filter((i) ->{

            StringBuffer sb = new StringBuffer(i);
            sb.reverse();
            String a = sb.toString();

            if(a.equalsIgnoreCase(i))
            return true;
            return false;
        }).forEach((i) -> System.out.println("Palindrome Word : "+i));
    }


    
}
