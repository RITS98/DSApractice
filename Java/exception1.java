import java.util.*;
import java.io.*;

public class exception1
{
	public static void main(String args[])
	{
		System.out.println("First Line");
		System.out.println("Second Line");

		try
		{
			int arr[] = new int[]{1,2,3};
			print(arr);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
			System.out.println("There is no 4th element");
		}

		System.out.println("Ritayan 18BEC0170");
	}

	public static void print(int arr[])
	{
		try
		{
			System.out.println(arr[4]);
		}
		catch(ArrayIndexOutOfBoundsException f)
		{
			System.out.println("------------------");
		}
		System.out.println("000000000000000");
		
	}
}