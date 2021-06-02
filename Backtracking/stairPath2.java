import java.io.*;
import java.util.*;

public class stairPath2
{
	public static void printPath(int n, String path)
	{
		if(n<0)
			return;

		if(n == 0)
		{
			System.out.println(path);
			return;
		}

		printPath(n-1, path+"1");
		printPath(n-2, path+"2");
		printPath(n-3, path+"3");
	}

	public static void main(String args[])
	{
		printPath(4, "");
	}
}