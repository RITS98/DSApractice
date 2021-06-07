/*

In this video, we discuss the Number of Islands problem where
1. You are given a 2d array where 0's represent land and 1's represent water. Assume every cell is linked to it's north, east, west and south cell.
2. You are required to find and count the number of islands.

All eight directions
*/

public class islands
{
	public int numIslands(char[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        
		int count = 0;

		for(int i = 0;i<n;i++)
		{
			for(int j = 0;j<m;j++)
			{
				if(grid[i][j] == '1')
				{
					drawTreeComp(grid, i, j);
					count++;
				}
			}
		}
		return count;
    }
    
    public static void drawTreeComp(char arr[][], int i, int j)
	{
		if(i>=0 && j>=0 && i<arr.length && j<arr[0].length && arr[i][j] == '1')
	    {
    		arr[i][j] = '2';
    		drawTreeComp(arr, i - 1, j);
    		drawTreeComp(arr, i - 1, j+1);
    		drawTreeComp(arr, i , j+1);
    		drawTreeComp(arr, i+1,j+1);
    		drawTreeComp(arr, i ,  j-1);
    		drawTreeComp(arr, i-1, j-1);
    		drawTreeComp(arr, i+1, j);
    		drawTreeComp(arr, i+1, j-1);
	    }
	}
}