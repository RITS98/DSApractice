class LCsubstrings{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        
        int dp[][] = new int[1001][1001];
        int res = 0;
        for(int i = 1;i<=n;i++)
        {
            for(int j = 1;j<=m;j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
                else
                dp[i][j] = 0;
            }
        }
        
        return res;
    }
}