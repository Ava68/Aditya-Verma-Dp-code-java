// Problem link -> https://practice.geeksforgeeks.org/problems/coin-change2448/1#
// find Maximum no of ways to make change for n cents
// based on unbounded Knapsack.

class Solution {
    public long count(int S[], int m, int n) {
        // code here.
        long dp[][] = new long[m+1][n+1];
        
        for(int i =0; i<=m; i++)
            dp[i][0] = 1;
            
        for(int j = 1; j<=n; j++)
            dp[0][j] = 0;
            
        for(int i =1; i<=m; i++)
        {
            for(int j =1; j<=n; j++)
            {
                if( S[i-1] <= j)
                    dp[i][j] = dp[i-1][j] + dp[i][j -S[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[m][n];
    }
}
