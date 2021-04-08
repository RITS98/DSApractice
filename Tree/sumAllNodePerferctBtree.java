import java.io.*;
import java.util.*;
import java.util.stream.*;

public class sumAllNodePerferctBtree
{
	static double sum(int l)
	{
		double leafcount = Math.pow(2, l-1);
		double sum = leafcount*(leafcount+1)/2 * l;

		return sum;
	}

	public static void main(String args[])
	{
		int l = 3;
		System.out.println(sum(l));
	}
}