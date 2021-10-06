// Problem Link -> https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1
// Memoize lcs solution
class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int dp[][] = new int [x+1][y+1];
        
        for(int i =0; i<=x; i++)
        {
            for(int j =0; j<=y; j++)
                dp[i][j] = -1;
        }
        
       return  lcs1(x,y,s1,s2,dp);
    }
    
    static int lcs1(int x,int y, String s1, String s2,int dp[][])
    {
        if(x == 0 || y == 0)
            return 0;
            
        if(dp[x][y] != -1)
            return dp[x][y];
            
        if(s1.charAt(x-1) == s2.charAt(y-1) )
            return dp[x][y] = 1 + lcs1(x-1, y-1, s1,s2,dp);
            
        else
           return dp[x][y] = Math.max(lcs1(x-1,y,s1,s2,dp) , lcs1(x,y-1,s1,s2,dp)); 
    }
    
}
