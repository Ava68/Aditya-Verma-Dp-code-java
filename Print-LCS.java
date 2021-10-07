// Problem Link -> https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem?isFullScreen=false

class Result {

    /*
     * Complete the 'longestCommonSubsequence' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> longestCommonSubsequence(List<Integer> a, List<Integer> b) {
    // Write your code here
    int n = a.size();
    int m = b.size();
    int dp[][] = new int[n+1][m+1];
    
    for(int i =0; i<=n; i++)
        dp[i][0] = 0;
        
    for(int j =0; j<=m; j++)
        dp[0][j] = 0;
        
        for(int i =1; i<=n; i++)
        {
            for(int j =1; j<=m; j++)
            {
                if(a.get(i-1) == b.get(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                    
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        int i =n; int j = m;
        List<Integer>res = new ArrayList<Integer>();
        while(i>0 && j > 0)
        {
            if(a.get(i-1) == b.get(j-1))
              {
                  res.add(a.get(i-1));
                  i--;
                  j--;
              } 
              
              else
              {
                  if(dp[i][j-1] > dp[i-1][j])
                    j--;
                    
                else
                    i--;
              } 
        }
        
        ArrayList<Integer> revArrayList = new ArrayList<Integer>();
        for (int z = res.size() - 1; z >= 0; z--) {
 
            // Append the elements in reverse order
            revArrayList.add(res.get(z));
        }
 
        // Return the reversed arraylist
        return revArrayList;
        
        
        
    }

}
