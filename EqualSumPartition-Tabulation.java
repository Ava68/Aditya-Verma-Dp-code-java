/*
problem Link-> shorturl.at/cgzC9
// Algorithm is based on subset sum problem.
*/


class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        
        int totalsum =0;
        for(int i =0; i<N; i++)
            totalsum+=arr[i];
            
        if(totalsum % 2 != 0)
            return 0;
            
        int sum = totalsum/2;
        
         if(subsetSum(N,arr,sum) == true)
            return 1;
        return 0;
    }
    
    static boolean subsetSum(int N, int arr[], int sum)
    {
        boolean dp[][] = new boolean[N+1][sum+1];
        
        for(int i =0; i<=N; i++)
            dp[i][0] = true;
            
        for(int j =1; j<=sum; j++)
            dp[0][j] = false;
        
        for(int i =1; i<=N; i++)
        {
            for(int j =1; j<=sum; j++)
            {
                if(arr[i-1] <= j)
                {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[N][sum];
    }
}
