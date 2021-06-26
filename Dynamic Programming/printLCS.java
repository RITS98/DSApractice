class printLCS
{
	public static int lcs(StringBuffer s1, StringBuffer s2, int n, int m)
	{
		int dp[][] = new int[1001][1001];
		for(int i=0;i<= n;i++)
			dp[i][0] = 0;
		for(int j = 0;j<=m;j++)
			dp[0][j] = 0;

		for(int i = 1;i<=n;i++)
		{
			for(int j = 1;j<=m;j++)
			{
				if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}

		int i = n;
		int j = m;

		StringBuffer sb = new StringBuffer("");
		while(i>0 && j>0)
		{
			if(s1.charAt(i-1) == s2.charAt(j-1))
			{
				sb.insert(0, s1.charAt(i-1));
				i--;
				j--;
			}
			else if(dp[i-1][j]>dp[i][j-1])
				i--;
			else
				j--;
		}

		System.out.println(sb);
	}


}