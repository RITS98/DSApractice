import java.io.*;
import java.util.*;


class ratInMazePart2 {

	 public static void backtrack(int[][] m,int n,ArrayList<String> list,int i,int j,String bf)
    {
        if(i<0 || i>=n || j<0 || j>=n || m[i][j]==0)
        {
            return;
        }
        
        if(i==n-1 && j==n-1)
        {
            list.add(bf+"");
            return;
        }
        
        
        m[i][j]=0; 
        
        backtrack(m,n,list,i+1,j,bf+"D");
        backtrack(m,n,list,i,j-1,bf+"L");
        backtrack(m,n,list,i,j+1,bf+"R");
        backtrack(m,n,list,i-1,j,bf+"U");
        
        m[i][j]=1;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        
        ArrayList<String> list=new ArrayList<>();
        String bf = "";
        
        backtrack(m,n,list,0,0,bf);
        return list;
        
    }

    public static void main(String arg[])
    {
        int mat[][] = { { 1, 0, 0, 0, 0 },
                  { 1, 1, 1, 1, 1 },
                  { 1, 1, 1, 0, 1 },
                  { 0, 0, 0, 0, 1 },
                  { 0, 0, 0, 0, 1 } };
        
        int N = mat.length;

        ArrayList<String> st = findPath(mat, N);
        System.out.println(st);
    }
}