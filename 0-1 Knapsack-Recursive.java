// problem Link -> https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1#

// Recursive Implementation of 0-1 knapsack.
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // Base case
         if(n == 0 || W == 0)
            return 0;
             
         if(wt[n-1] <= W)
         {
           return Math.max(val[n-1] + knapSack(W - wt[n-1] ,wt, val,n-1), knapSack(W  ,wt, val,n-1)) ; 
         }
         
         else if(wt[n-1] > W)
            return knapSack(W ,wt, val,n-1);
        
        else 
            return -1;
    } 
}
