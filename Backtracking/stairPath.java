import java.io.*;
import java.util.*;


public class stairPath
{
	public static ArrayList<String> getStairPath(int n)
	{
		if(n == 0)
		{
			ArrayList<String> empty = new ArrayList<>();
			empty.add("");
			return empty;
		}
		else if(n<0)
		{
			ArrayList<String> empty = new ArrayList<>();
			return empty;
		}

		ArrayList<String> one = getStairPath(n-1);
		ArrayList<String> two = getStairPath(n-2);
		ArrayList<String> three = getStairPath(n-3);

		ArrayList<String> path = new ArrayList<>();
		for(String i: one)
			path.add("1"+i);

		for(String i: two)
			path.add("2"+i);

		for(String i: three)
			path.add("3"+i);

		return path;
	}

	public static void main(String args[])
	{
		ArrayList<String> paths = getStairPath(4);
		System.out.println(paths);
	}
}