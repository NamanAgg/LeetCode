//*************96. Unique Binary Search Trees
// Given an integer n, return the number of structurally unique BST's (binary search trees)
// which has exactly n nodes of unique values from 1 to n.

// Example 1:
// Input: n = 3
// Output: 5

// Example 2:
// Input: n = 1
// Output: 1

// Constraints:
// 1 <= n <= 19
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[]dp = new int[n+1];
        return numTrees(n,dp);
    }
    
    public int numTrees(int n,int[]dp){
        if(dp[n]!=0) return dp[n];
        
        if(n<=1) return dp[n] = 1;
        
        int ans = 0;
          for(int i = 1; i <= n; i++) 
            ans += numTrees(i-1,dp) * numTrees(n-i,dp);
        
        return dp[n] = ans;
    }
}
