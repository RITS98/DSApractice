import java.util.*;
import java.io.*;

public class floodfill
{
	public static void printPath(int mat[][], int row, int col, String ans, boolean visited[][])
	{
		if(row < 0 || col < 0 || row == mat.length || col == mat[0].length || mat[row][col] == 0 || visited[row][col])
			return;

		if(row == mat.length-1 && col == mat[0].length-1)
		{
			System.out.println(ans);
			return;
		}

		visited[row][col] = true;
		printPath(mat, row - 1, col, ans+"U", visited);
		printPath(mat, row, col + 1, ans+"R", visited);
		printPath(mat, row + 1, col, ans+"D", visited);
		printPath(mat, row, col - 1, ans+"L", visited);
		visited[row][col] = false;
	}

	public static void main(String args[])
	{
		int mat[][] = { { 1, 0, 0, 0, 0 },
                  { 1, 1, 1, 1, 1 },
                  { 1, 1, 1, 0, 1 },
                  { 0, 0, 0, 0, 1 },
                  { 0, 0, 0, 0, 1 } };

        int r = mat.length;
        int c = mat[0].length;

        boolean visited[][] = new boolean[r][c];

      	printPath(mat, 0, 0, "", visited);
	}
}