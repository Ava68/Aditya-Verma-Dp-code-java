// problem link -> https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1#


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int range = 0;
	    for(int i =0; i<n; i++)
	        range+=arr[i];
	        
	   ArrayList<Integer>al = new ArrayList<Integer>();
	   subsetSum(arr,n,range,al);
	   
	   int min = Integer.MAX_VALUE;
	   
	   for(int i =0; i<al.size(); i++)
	   {
	       min = Math.min(min, range-2*al.get(i));
	   }
	   
	  return min;
	} 
	
	public void subsetSum(int arr[], int n, int range,ArrayList<Integer>al)
	{
	    boolean dp[][] = new boolean[n+1][range+1];
	    
	    dp[0][0] = true;
	    for(int i =1; i<=n; i++)
	        dp[i][0] = true;
	        
	    for(int j = 1; j<=range; j++)
	        dp[0][j] = false;
	       
	   for(int i =1; i<=n; i++)
	   {
	       for(int j = 1; j<=range; j++)
	       {
	           if(arr[i-1] <= j)
	                dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1] ];
	            
	           else
	                dp[i][j] = dp[i-1][j];
	       }
	   }
	   
	   for(int i =0; i<=range/2; i++)
	    {
	        if(dp[n][i] == true)
	            al.add(i);
	    }
	   
	}
}
