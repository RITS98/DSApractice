import java.io.*;
import java.util.*;
import java.util.stream.*;

public class sortMatrix
{

public static void sort(int mat[][], int r, int c)
{
	int temp[] = new int[r*c];
	int k = 0;
	for(int i = 0;i<r;i++)
	for(int j = 0;j<c;j++)
	temp[k++] = mat[i][j];
	
	Arrays.sort(temp);
	k=0;
	for(int i = 0;i<r;i++)
	for(int j = 0;j<c;j++)
	mat[i][j] = temp[k++];
}

public static void printMatrix(int mat[][], int r, int c)
{
	for(int i =0 ;i<r;i++)
	{
	for(int j =0;j<c;j++)
	System.out.print(mat[i][j]+" ");
	System.out.println();
	}
}

public static void main(String args[])throws IOException
{
	int arr[][] = {{ 5, 4, 7 },{ 1, 3, 8 },{ 2, 9, 6 }};

	sort(arr, 3, 3);
	printMatrix(arr, 3,3);
}

}
