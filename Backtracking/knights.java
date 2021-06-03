import java.util.Arrays;
 
class knights
{
    // `N × N` chessboard
    public static final int N = 5;
 
    // Below arrays detail all eight possible movements for a knight.
    // Don't change the sequence of the below arrays
    public static final int[] row = { 2, 1, -1, -2, -2, -1, 1, 2 , 2 };
    public static final int[] col = { 1, 2, 2, 1, -1, -2, -2, -1, 1 };
 
    // Check if `(x, y)` is valid chessboard coordinates.
    // Note that a knight cannot go out of the chessboard
    private static boolean isValid(int x, int y)
    {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        }
 
        return true;
    }
 
    private static void print(int[][] visited)
    {
        for (var r: visited) {
            System.out.println(Arrays.toString(r));
        }
        System.out.println();
    }
 
    // Recursive function to perform the knight's tour using backtracking
    public static void knightTour(int visited[][], int x, int y, int pos)
    {
        // mark the current square as visited
        visited[x][y] = pos;
 
        // if all squares are visited, print the solution
        if (pos >= N*N)
        {
            count++;
            print(visited);
            // backtrack before returning
            visited[x][y] = 0;
            return;
        }
 
        // check for all eight possible movements for a knight
        // and recur for each valid movement
        for (int k = 0; k < 8; k++)
        {
            // get the new position of the knight from the current
            // position on the chessboard
            int newX = x + row[k];
            int newY = y + col[k];
 
            // if the new position is valid and not visited yet
            if (isValid(newX, newY) && visited[newX][newY] == 0) {
                knightTour(visited, newX, newY, pos + 1);
            }
        }
 
        // backtrack from the current square and remove it from the current path
        visited[x][y] = 0;
    }
    
    static int count = 0;
    public static void main(String[] args)
    {
        // `visited[][]` serves two purposes:
        // 1. It keeps track of squares involved in the knight's tour.
        // 2. It stores the order in which the squares are visited.
        int visited[][] = new int[N][N];
        int pos = 1;
 
        // start knight tour from corner square `(0, 0)`
        knightTour(visited, 0, 0, pos);
        System.out.println("Total no. of solutions = "+ count);
    }
}