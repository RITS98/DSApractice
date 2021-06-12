//P(n, k) = P(n-1, k) + k* P(n-1, k-1) 


import java.io.*;
import java.util.*;

public class permutationCoefficient
{
	public static int find(int n, int k, int dp[][])
	{
		if(k>n)
			return 0;

		if(k==0 || k==n)
			return 1;

		if(dp[n][k] != 0)
			return dp[n][k];

		int val1 = find(n-1, k, dp);
		int val2 = k*find(n-1, k-1, dp);

		dp[n][k] = val1 + val2;

		return dp[n][k];
	}

	public static void main(String args[])
	{
		int n = 10, k = 2;
		int dp[][] = new int[n+1][k+1];

		System.out.println(find(n, k, dp));
	}
}


// Tabulation

static int permutationCoeff(int n,int k)
{
    int P[][] = new int[n + 2][k + 2];
 
    // Calculate value of Permutation
    // Coefficient in bottom up manner
    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j <= Math.min(i, k); j++)
        {
            // Base Cases
            if (j == 0)
            P[i][j] = 1;
 
            // Calculate value using previosly
            // stored values
            else
            P[i][j] = P[i - 1][j] + (j * P[i - 1][j - 1]);
 
            // This step is important
            // as P(i,j)=0 for j>i
            P[i][j + 1] = 0;
        }
    }
    return P[n][k];
}