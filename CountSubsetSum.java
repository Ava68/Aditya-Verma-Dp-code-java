// problem Link -> https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1#

class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int dp[][] = new int[n+1][sum+1];
	    
	    dp[0][0] = 1;
	    for(int i =1; i<=n; i++)
	        dp[i][0] = 1;
	        
	    for(int j =1; j<=sum; j++)
	        dp[0][j] = 0;
	        
	   for(int i = 1; i<=n; i++)
	   {
	       for(int j =1; j<=sum; j++)
	       {
	           if(arr[i-1] <= j)
	           {
	               dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
	           }
	           else 
	            dp[i][j] = dp[i-1][j];
	       }
	   }
	    
	    return dp[n][sum];
	} 
}
