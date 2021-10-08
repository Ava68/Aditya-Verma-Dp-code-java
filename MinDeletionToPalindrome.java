// problem link -> https://practice.geeksforgeeks.org/problems/minimum-deletitions1648/1
// based on lcs pattern

class Solution{
    static int minimumNumberOfDeletions(String s) {
        //your code here
        String rev = "";

         for(int i =s.length()-1; i>=0; i--)
             rev += s.charAt(i);

         int m = s.length();
         int n = rev.length();

         int dp[][] = new int[m+1][n+1];

         for(int i =1; i<=m; i++)
         {
             for(int j =1; j<=n; j++)
             {
                 if(s.charAt(i-1) == rev.charAt(j-1))
                     dp[i][j] = 1 + dp[i-1][j-1];
                 else
                     dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);

             }
         }
         
         return m - dp[m][n];
        
    }
}
