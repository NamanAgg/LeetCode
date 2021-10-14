//*************279. Perfect Squares
// Given an integer n, return the least number of perfect square numbers that sum to n.
// A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
// For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

// Example 1:
// Input: n = 12
// Output: 3
// Explanation: 12 = 4 + 4 + 4.

// Example 2:
// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9.

// Constraints:
// 1 <= n <= 104
public class PerfectSquares {
    public int numSquares(int n) {
        int sqr = (int)Math.sqrt(n);
        if(sqr*sqr==n) return 1;
      
        int[]arr = new int[sqr];
        for(int i=0;i<arr.length;i++)
            arr[i]=(int)Math.pow(i+1,2);
        
        int[]dp = new int[n+1];
        return targetSum(arr,n,dp);
        
    }
    
    public int targetSum(int[]arr,int target,int[]dp){
        if(target==0)
            return dp[target]=0;
        
        if(dp[target]!=0) return dp[target];
        
        int ans = Integer.MAX_VALUE;
     
        
        for(Integer e : arr){
            if(target-e>=0)
                ans = Math.min(targetSum(arr,target-e,dp)+1,ans);
        }
        
        return dp[target]=ans;
        
    }
}
