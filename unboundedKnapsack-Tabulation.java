// problem link -> https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1#
// unbounded knapsack Tabulation
//User function Template for Java

class Solution{
    static int knapSack(int n, int w, int val[], int wt[])
    {
        // code here
        int dp[][] = new int[n+1][w+1];
        
        for(int i =0; i<=n; i++)
            dp[i][0] = 0;
        for(int j =0; j<=w; j++)
            dp[0][j] = 0;
            
        for(int i =1; i<=n; i++)
        {
            for(int j = 1; j<=w; j++)
            {
                if(wt[i-1] <= j)
                    dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
                    
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
    return dp[n][w];
    }
}
