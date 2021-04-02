import java.io.*;
import java.util.*;
import java.util.stream.*;

public class getMaxEleFromEachRow
{
	public static void searchMax(int mat[][], int r, int c)
	{
		for(int i = 0;i<r;i++)
		{
			int max = Arrays.stream(mat[i]).max().getAsInt();
			System.out.println(i+" - "+max);
		}
	}

	public static void main(String args[])
	{
		int mat[][] = new int[][] { {3, 4, 1, 8},
                                    {1, 4, 9, 11},
                                    {76, 34, 21, 1},
                                   {2, 1, 4, 5} };
         searchMax(mat, 4, 4);
	}
}