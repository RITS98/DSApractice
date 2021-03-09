import java.io.*;
public class exception5
{
	public static void validate(int a)
	{
		if(a<21 || a>27)
			throw new ArithmeticException("Not eligible");
		else
			System.out.println("Eligible for military service");
	}
	public static void main(String args[])
	{
		try
		{
			validate(30);
			validate(21);
			validate(18);
		}
		catch(ArithmeticException e)
		{
			System.out.println(e);
		}
		System.out.println("Outside Try-catch block - ");

	}
}