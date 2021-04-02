import java.io.*;
import java.util.*;
import java.util.stream.*;

public class printLowerUpper
{
	public static void printLower(int mat[][], int r, int c)
	{
		System.out.println("LOWER");
		for(int i = 0;i<r;i++)
		{
			for(int j = 0;j<c;j++)
			{
				if(i>=j)
					System.out.print(mat[i][j]+" ");
				else
					System.out.print(0+" ");
			}
			System.out.println();
		}
	}

	public static void printUpper(int mat[][], int r, int c)
	{
		System.out.println("UPPER");
		for(int i = 0;i<r;i++)
		{
			for(int j = 0;j<c;j++)
			{
				if(i<=j)
					System.out.print(mat[i][j] + " ");
				else
					System.out.print(0+" ");
			}

			System.out.println();
		}
	}


	public static void main(String[] args) {
		
		int mat[][] = new int[][] {{1, 2, 3}, 
                        {4, 5, 6}, 
                        {7, 8, 9}};


        printLower(mat, 3,3);
        printUpper(mat, 3,3);
	}


}