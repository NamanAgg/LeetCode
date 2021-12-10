//*************790. Domino and Tromino Tiling
// You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.
// Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.
// In a tiling, every square must be covered by a tile.
// Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the
// tilings has both squares occupied by a tile.

// Example 1:
// Input: n = 3
// Output: 5
// Explanation: The five different ways are show above.

// Example 2:
// Input: n = 1
// Output: 1

// Constraints:
// 1 <= n <= 1000
public class DominoAndTrominoTiling {
     //its a straight up dp question where we hacve to notice the pattern
    // Link of the explanation : https://leetcode.com/problems/domino-and-tromino-tiling/discuss/116581/Detail-and-explanation-of-O(n)-solution-why-dpn2*dn-1%2Bdpn-3
    public int numTilings(int n) {
        if(n==0) return 0;
        int[]dp = new int[n+1];
        
        return numTilings(n,dp);
    }
    
    public int numTilings(int n,int[]dp){
        if(n==0) return dp[n] = 1;
        if(n<3) return dp[n] = n;
        
        if(dp[n]!=0) return dp[n];
        
        int mod=(int)(Math.pow(10,9)+7);
        return dp[n] = ((2*numTilings(n-1,dp)%mod)%mod + numTilings(n-3,dp)%mod)%mod;
    }
}
