package ownPractice;
//***************887. Super Egg Drop
// You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.
// You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break,
// and any egg dropped at or below floor f will not break.
// Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n).
// If the egg breaks, you can no longer use it. However, if the egg does not break, you may reuse it in future moves.
// Return the minimum number of moves that you need to determine with certainty what the value of f is.

// Example 1:
// Input: k = 1, n = 2
// Output: 2
// Explanation: 
// Drop the egg from floor 1. If it breaks, we know that f = 0.
// Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1.
// If it does not break, then we know f = 2.
// Hence, we need at minimum 2 moves to determine with certainty what the value of f is.

// Example 2:
// Input: k = 2, n = 6
// Output: 3

// Example 3:
// Input: k = 3, n = 14
// Output: 4

// Constraints:
// 1 <= k <= 100
// 1 <= n <= 104
public class SuperEggDrop {
    public int superEggDrop(int n, int k) { //here n = eggs given, k=floors given     
        int[][]dp = new int[n+1][k+1];
// //        for(int[]d : dp)
// //            Arrays.fill(d,-1);
// //        return eggDrop(n,k,dp);
        
//         return eggDrop_DP(n,k,dp);
     
        int[][] memo = new int[n + 1][k + 1];
        return helper(n, k, memo);
    }
    
    private int helper(int N, int K, int[][] memo) { //work in n*k*log(k)
        if (K <= 1) return K;
        if (N == 1) return K;
        if (memo[N][K] > 0) return memo[N][K];
            
        int low = 1, high = K, result = K;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int left = helper(N - 1, mid - 1, memo);
            int right = helper(N, K - mid, memo);
            
            result = Math.min(result, Math.max(left, right) + 1);
            
            if (left == right) break;
            else if (left < right) low = mid + 1;
            else high = mid;
        }
        memo[N][K] = result;
        return result;
    }
    
    int eggDrop(int n,int k,int[][]dp){          //work in n*k*k
        if(dp[n][k]!=-1) return dp[n][k];
        if(k==0) return dp[n][k]=0;
        if(n==1) return dp[n][k]=k;
        if(k==1) return dp[n][k]=1;
	    
        int myAns = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            int eggNotBroken = eggDrop(n,k-i,dp);
            int broken = eggDrop(n-1,i-1,dp);
            myAns = Math.min(myAns,Math.max(eggNotBroken,broken)+1);
        }
        return dp[n][k]=myAns;
    }
    
    int eggDrop_DP(int N,int K,int[][]dp){ //work in n*k*k
        for(int n=1;n<=N;n++){
            for(int k=1;k<=K;k++){
                if(n==1){
                    dp[n][k]=k; 
                    continue;
                }
                if(k==1){
                    dp[n][k]=1;
                    continue;
                }
	    
                int myAns = Integer.MAX_VALUE;
                for(int i=1;i<=k;i++){
                    int eggNotBroken = dp[n][k-i];
                    int broken = dp[n-1][i-1];
                    myAns = Math.min(myAns,Math.max(eggNotBroken,broken)+1);
                }
                dp[n][k]=myAns;
            }
        }
        return dp[N][K];
    }
}
