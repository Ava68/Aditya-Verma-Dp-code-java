// problem link -> https://leetcode.com/problems/target-sum/submissions/

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int arrsum = 0;
        
        for(int i =0; i<nums.length; i++)
                arrsum+=nums[i];
         
       if(((arrsum - target) % 2 == 1) || (target > arrsum))
            return 0;
        
        int s1 = (arrsum - target) / 2;
        
       return  countSubsetSum(nums,s1,nums.length);
    }
    
    public int countSubsetSum(int[] nums, int sum,int n)
    {
        int dp[][] = new int[n+1][sum+1];
        
        dp[0][0] = 1;
        
        for(int i =1 ; i<=n; i++)
            dp[i][0] = 1;
        for(int j = 1; j<=sum; j++)
            dp[0][j] = 0;
        
        for(int i = 1; i<=n; i++)
        {
            for(int j =0; j<=sum; j++)
            {
                if(nums[i-1] <= j)
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][sum];
    }
}
