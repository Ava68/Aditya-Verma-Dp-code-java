// problem link -> https://practice.geeksforgeeks.org/problems/cutted-segments1642/1#

class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int sum, int x, int y, int z)
    {
        int[] arr = new int[]{x, y, z};
        int n = 3;
        int[][] dp = new int[n+1][sum + 1];
        for(int i = 0; i <= n; i++)
        {
            Arrays.fill(dp[i], - 1);
            dp[i][0] = 0;
        }
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= sum; j++)
            {
                if(arr[i-1] <= j && dp[i][j - arr[i-1]] != -1)
                {
                    dp[i][j] = Math.max(1 + dp[i][j - arr[i-1]], dp[i-1][j]);
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if(dp[n][sum] == -1)
        {
            return 0;
        }
        return dp[n][sum];
    }
}
