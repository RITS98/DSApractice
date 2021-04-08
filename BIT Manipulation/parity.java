// Java program to find parity
// of an integer
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

public class parity
{
	/* Function to get parity of number n.
	It returns 1 if n has odd parity, and
	returns 0 if n has even parity */
	static boolean getParity(int n)
	{
		boolean parity1 = false;
		while(n != 0)
		{
			parity1 = !parity1;
			n = n & (n-1);
		}
		return parity1;
		
	}
	
	/* Driver program to test getParity() */
	public static void main (String[] args)
	{
		int n = 12;
		System.out.println("Parity of no " + n + " = " +
						(getParity(n)? "odd": "even"));
	}
}
/* This code is contributed by Amit khandelwal*/
