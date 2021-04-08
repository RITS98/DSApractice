import java.io.*;
import java.util.*;
import java.util.stream.*;

public class countSetBits
{

	public static int findSetBit(int n)
	{
		if(n<=0)
			return 0;
		return (n%2==0? 0: 1)+findSetBit(n/2);
	}

	public static int countSetBit(int n)
	{
		int count = 0;
		while(n>0)
		{
			n=n&(n-1);
			count++;
		}
		return count;
	}

	public static void main(String args[])
	{
		int n = 6;
		int sum = 0;
		for(int i = 1;i<=n;i++)
			sum+=findSetBit(i);
		System.out.println(sum);

		System.out.println(countSetBit(10));
	}
}