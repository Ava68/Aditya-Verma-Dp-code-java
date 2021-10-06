// problem Link -> https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1
// lcsubstring

class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
        int dp [][] = new int[n+1][m+1];
        
        for(int i =0; i<=n; i++)
            dp[i][0] = 0;
            
        for(int j =0; j<=m; j++)
            dp[0][j] = 0;
            
        for(int i =1; i<=n; i++)
        {
            for(int j =1; j<=m; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = 0;
            }
        }
        // find the max value in dp array 
   int max = Integer.MIN_VALUE;
   
       for(int i =0; i<=n; i++)
       {
          for(int j =0; j<=m; j++)
          {
             max =  Math.max(max,dp[i][j]);
          }
       }
   
   return max;
   
    }
}
