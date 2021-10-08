// Problem Link -> https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
// Based on Lcs Pattern

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        int dp[][] = new int[m+1][n+1];
        
        for(int i =0; i<=m; i++)
            dp[i][0] = 0;
        for(int j =0; j<=n; j++)
            dp[0][j] = 0;
        
        for(int i =1; i<=m; i++)
        {
            for(int j =1; j<=n; j++)
            {
                if(X.charAt(i-1) == Y.charAt(j-1) )
                    dp[i][j] = 1 + dp[i-1][j-1];
                    
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        int a = X.length() - dp[m][n];
        int b = Y.length() - dp[m][n];
        
    return a + b + dp[m][n];
    }
}
