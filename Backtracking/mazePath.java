import java.io.*;
import java.util.*;

public class mazePath
{
	public static ArrayList<String> findPath(int sr, int sc, int dr, int dc)
	{

		if(sc == dc && sr == dr)
		{
			ArrayList<String> empty = new ArrayList<>();
			empty.add("");
			return empty;
		}

		ArrayList<String> hpath = new ArrayList<>();

		if(sc<dc)
		{
			hpath = findPath(sr, sc+1, dr, dc);
		}
		


		ArrayList<String> vpath = new ArrayList<>();

		if(sr<dr)
		{
		 	vpath = findPath(sr+1, sc, dr, dc);
		}


		ArrayList<String> path = new ArrayList<>();
		for(String h: hpath)
		{
			path.add("h"+h);
		}

		for(String v:vpath)
		{
			path.add("v" + v);
		}

		return path;

	}

	public static void main(String args[])
	{
		int dc = 3, dr = 3;

		ArrayList<String> p = findPath(0, 0, dr, dc);
		System.out.println(p.toString()); 
	}
}