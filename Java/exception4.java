import java.io.*;
public class exception4
{
	public static void main(String args[])
	{
		System.out.println(exception4.method());
	}

	public static int method()
	{
		try
		{
			return  2/0;
		}
		catch(Exception e)
		{

			System.out.println("Exception Handled");
			return 0;
		}
		finally
		{
			System.out.println("Finally block will execute irrespectve of return statement");
		}
	}
}