import java.io.*;
import java.util.*;
public class StringOperations
{
	public static void main(String args[])
	{
		FastReader fr = new FastReader();

		System.out.println("Enter a sentence - ");
		String s = fr.nextLine();


		System.out.println(s.startsWith("tommy"));
		System.out.println(s.endsWith("dog"));

		System.out.println(s.length());
		System.out.println(s.indexOf('R'));
		System.out.println(s.lastIndexOf('R', 5));

		char d[] = s.toCharArray();
		System.out.println(Arrays.toString(d));

		String s2 = s.intern();

		System.out.println(s.equals(s2)+" " + s.equalsIgnoreCase(s2)+ " " + s.compareToIgnoreCase(s2));
		System.out.println(s.toLowerCase());
		System.out.println(s.toUpperCase());

		System.out.println(s.hashCode());
		System.out.println(s.substring(2,5));
		System.out.println(s.replace('r','d'));

		System.out.println();
	}
}