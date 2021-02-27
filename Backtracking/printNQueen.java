import java.util.*;
class printNQueens
{
    public static void NQueenFormation(boolean board[][], int row, String ans)
    {
        if(row == board.length)
        {
            System.out.println(ans);
            return;
        }

        int count = 0;
        for(int col = 0;col<board[row].length;col++)
        {
            if(isSafe(board, row, col))
            {
                board[row][col] = true;
                NQueenFormation(board, row+1, ans+"{"+(row+1)+","+(col+1)+"}");
                board[row][col] = false;
            }
        }
    }
    public static boolean isSafe(boolean board[][], int row, int col)
    {
        for(int i = row;i>=0;i--)
        if(board[i][col])
        return false;

        for(int i = row, j= col; i>=0 && j>=0;i--,j--)
        if(board[i][j])
        return false;

        for(int i = row,j = col;i>=0&&j<board.length;i--,j++)
        if(board[i][j])
        return false;

        return true;
    }

    public static void main(String args[])
    {
        boolean board[][] = new boolean[4][4];
        for(int i = 0;i<4;i++)
        {
            for(int j = 0;j<4;j++)
            board[i][j] = false;
        }
        NQueenFormation(board, 4,"");
    }
}