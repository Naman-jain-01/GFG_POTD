

class Solution{
    static boolean match(String wild, String pattern)
    {
        int n=wild.length();
        int m=pattern.length();

        if(n==0 && m==0) return true;

        boolean dp[][]=new boolean[n+1][m+1];

        char[] patternarray=pattern.toCharArray();
        char[] wildArray=wild.toCharArray();

        dp[n][m]=true;

        for(int i=n-1;i>-1;i--)
        {
            for(int j=m-1;j>-1;j--)
            {
                if(wildArray[i]=='?' || wildArray[i]==patternarray[j])
                {
                    dp[i][j]=dp[i+1][j+1];
                }
                else if(wildArray[i]=='*')
                {
                    if(i==n-1)dp[i][j]=true;
                    else
                        dp[i][j]=dp[i+1][j] || dp[i][j+1];
                }

                else
                    dp[i][j]=false;
            }
        }

        return dp[0][0];

    }
}
