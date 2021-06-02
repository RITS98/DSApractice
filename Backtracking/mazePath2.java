import java.io.*;
import java.util.*;

public class mazePath2
{
	public static void printMazePath(int sr, int sc, int dr, int dc, String path)
	{
		if(sr>dr || sc>dc)
			return;

		if(sr == dr && sc == dc)
		{
			System.out.println(path);
			return;
		}

		printMazePath(sr+1, sc, dr, dc, path+"V");
		printMazePath(sr, sc+1, dr, dc, path+"H");
	}

	public static void main(String args[])
	{
		int dr = 3, dc = 3;

		printMazePath(0, 0, dr, dc, "");
	}
}