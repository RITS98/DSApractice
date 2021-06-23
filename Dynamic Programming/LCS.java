//StringBuffer faster speed
//memorized
class LCS
{
    static int dp[][] = new int[1001][1001];
    
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        StringBuffer a = new StringBuffer(s1), b = new StringBuffer(s2);
        for(int row[]:dp)
        Arrays.fill(row,-1);
        int val = lcsFind(x,y,a,b);
        return val;
    }
    static int lcsFind(int x, int y, StringBuffer s1, StringBuffer s2)
    {
        if(x==0 || y==0)
        return 0;
        if(dp[x][y]!=-1)
        return dp[x][y];
        
        if(s1.charAt(x-1) == s2.charAt(y-1))
        return dp[x][y] = 1 + lcsFind(x-1,y-1,s1,s2);
        else
        return dp[x][y] = Math.max(lcsFind(x-1,y,s1,s2),lcsFind(x,y-1,s1,s2));
    }
    
}


//Top down

{
	int dp[][] = new int[1001][1001];
	for(int i=0;i<= n;i++)
		dp[i][0] = 0;
	for(int j = 0;j<=m;j++)
		dp[0][j] = 0;

	for(int i = 0;i<=n;i++)
	{
		for(int j = 0;j<=m;j++)
		{
			if(s1.charAt(i-1) == s2.charAt(j-1))
				dp[i][j] = dp[i-1][j-1] + 1;
			else
				dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
		}
	}

	return dp[n][m];
}