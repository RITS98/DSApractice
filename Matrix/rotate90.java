import java.io.*;
import java.util.*;
import java.util.stream.*;

/*Clockwise 90 ROTATE

Transpose
SwapColumns

Anti ClockWise 90 Rotate

Transpose
SwapRows

*/


//Clockwise Rotate
public class rotate90
{
	public static void transpose(int mat[][], int r, int c)
	{
		int row = 0, col = 0;
		for(int i = row;i<r;i++)
		{
			for(int j = col, k = row;j<c&&k<r;j++,k++)
			{
				int temp = mat[k][j];
				mat[k][j] = mat[j][k];
				mat[j][k] = temp;
			}
			col++;
		}
	}

	public static void swapColumns(int mat[][], int r, int c)
	{
		int row = 0, col= 0;
		for(int i = col;i<c;i++)
		{
			int k = c - 1;
			for(int j = row;j<r;j++)
			{
				int temp = mat[j][i];
				mat[j][i] = mat[j][k];
				mat[j][k] = temp;
				
			}

			c--;
		}
	}
	static void printMatrix(int arr[][])
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length;
                 j++)
                System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }

	public static  void main(String args[])throws IOException
	{
		int mat[][] = { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 },
                        { 13, 14, 15, 16 } };


        printMatrix(mat);
        transpose(mat, 4,4);
        System.out.println("------------- Transpose --------------");
        printMatrix(mat);
        System.out.println("------------- Swap Columns ----------------");
        swapColumns(mat, 4, 4);
        printMatrix(mat);
	}
}