import java.util.*;
import java.util.stream.*;
import java.io.*;

public class shiftRowise
{
	public static void shift(int mat[][], int r, int c, int k)
	{
		int temp[][] = new int[r][c*2];

		for(int i = 0;i<r;i++)
		{
			for(int j = 0;j<c*2;j++)
			{
				int m = (k+j)%c;
				//System.out.println(k+" - "+j);
				temp[i][j] = mat[i][m];
			}
		}

		for(int i =0;i<r;i++)
		{
			for(int j = 0;j<c;j++)
			{
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		}


	}

	public static void main(String args[])throws IOException
	{
		int mat[][] = new int[][]{ {1, 2, 3, 4},
                      {5, 6, 7, 8},
                      {9, 10, 11, 12},
                      {13, 14, 15, 16} };

        int k = 2;

        shift(mat, 4, 4, 2);
	}
}