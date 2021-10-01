/* problem Link -> https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1#

Dynamic Programming Implementation of 0-1 knapsack.
*/ 
class Solution 
{ 
   
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here
         int dp[][] = new int[n+1][W+1];
         for(int i =0; i<n+1; i++)
         {
             for(int j=0; j<W+1; j++)
             {
                 dp[i][j] = -1;
             }
         }
         
         return findMax(W,wt,val,n,dp);
    } 
    
    static int findMax(int W, int wt[], int val[], int n, int dp[][])
    {
        if(n == 0 || W == 0)
            return 0;
           
          if(dp[n][W] != -1)
            return dp[n][W];
            
        else if(wt[n-1] <= W)
         {
           return dp[n][W] = Math.max(val[n-1] + findMax(W - wt[n-1] ,wt, val,n-1,dp), findMax(W  ,wt, val,n-1,dp)) ; 
         }
         
         else if(wt[n-1] > W)
            return dp[n][W] = findMax(W ,wt, val,n-1,dp);
        
        return -1;
    }
}
