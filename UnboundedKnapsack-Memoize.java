// problem Link ->> https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1#

// unbounded Knapsack

class Solution{
    
    static int knapSack(int n, int w, int val[], int wt[])
    {
        int dp[][] = new int[n+1][w+1];
        
        for(int i =0; i<=n; i++)
        {
            for(int j =0; j<=w; j++)
            {
                dp[i][j] = -1;
            }
        }
        
        return recFun(n,w,val,wt,dp);
    }
    
    static int recFun(int n, int w,int val[], int wt[], int dp[][])
    {
        // code here
        if(n == 0 || w == 0)
            return 0;
            
        if(dp[n][w] != -1)
            return dp[n][w];
            
        if(wt[n-1] <= w)
            return dp[n][w] = Math.max( val[n-1] + recFun(n, w-wt[n-1] ,val,wt,dp), recFun(n-1, w,val,wt,dp));
            
        else
            return dp[n][w] = recFun(n-1, w,val,wt,dp);
    }
}
