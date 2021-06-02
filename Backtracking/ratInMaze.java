import java.io.*;
import java.util.*;


public class ratInMaze
{
	static ArrayList<String> allPossiblePath = new ArrayList<>();
	static String path = "";

	static boolean isSafe(int x, int y, int N, boolean visited[][], int mat[][])
	{
		if(x<0 || y<0 || x==N || y==N || visited[x][y] || mat[x][y]==0)
			return false;

		return true;
	}
	public static void findPath(int mat[][], int sr, int sc, int N, boolean visited[][])
	{
		if(sr == -1 || sc == -1 || visited[sr][sc] || sr == N || sc == N || mat[sr][sc] == 0)
			return;

		if(sr == N-1 && sc == N-1)
		{
			allPossiblePath.add(path);
			return;
		}

		visited[sr][sc] = true;

		if(isSafe(sr+1, sc, N, visited, mat))
		{
			path = path + "D";
			findPath(mat, sr+1, sc, N, visited);

			path = path.substring(0, path.length()-1);
		}

		if(isSafe(sr, sc+1, N, visited, mat))
		{
			path = path + "R";
			findPath(mat, sr, sc+1, N, visited);

			path = path.substring(0, path.length()-1);
		}

		if(isSafe(sr - 1, sc, N, visited, mat))
		{
			path = path + "U";
			findPath(mat, sr-1, sc, N, visited);
			path = path.substring(0, path.length()-1);
		}

		if(isSafe(sr, sc - 1, N, visited, mat))
		{
			path = path + "L";
			findPath(mat, sr, sc - 1, N, visited);

			path = path.substring(0, path.length()-1);
		}

		visited[sr][sc] = false;

	}

	public static void findPathForRat(int mat[][], int N)
	{
		boolean visited[][] = new boolean[N][N];

		findPath(mat, 0, 0, N, visited);

		System.out.println(allPossiblePath);

	}

	public static void main(String arg[])
	{
		int mat[][] = { { 1, 0, 0, 0, 0 },
                  { 1, 1, 1, 1, 1 },
                  { 1, 1, 1, 0, 1 },
                  { 0, 0, 0, 0, 1 },
                  { 0, 0, 0, 0, 1 } };
    	
    	int N = mat.length;

    	findPathForRat(mat, N);
	}
}