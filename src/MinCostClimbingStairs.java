//**************746. Min Cost Climbing Stairs
// You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
// Once you pay the cost, you can either climb one or two steps.
// You can either start from the step with index 0, or the step with index 1.\
// Return the minimum cost to reach the top of the floor.

// Example 1:
// Input: cost = [10,15,20]
// Output: 15
// Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.

// Example 2:
// Input: cost = [1,100,1,1,1,100,1,1,100,1]
// Output: 6
// Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].
 
// Constraints:
// 2 <= cost.length <= 1000
// 0 <= cost[i] <= 999
public class MinCostClimbingStairs {
    public int minCost_memo(int n, int[] cost, int[] dp) {
        if (n <= 1) {
            return dp[n] = cost[n];
        }

        if (dp[n] != 0)
            return dp[n];

        int minCost = Math.min(minCost_memo(n - 1, cost, dp), minCost_memo(n - 2, cost, dp));

        return dp[n] = minCost + (n == cost.length ? 0 : cost[n]);
    }
     public int minCost_dp(int N, int[] cost, int[] dp) {
        for(int n=0;n<=N;n++){
            if (n <= 1) {
                dp[n] = cost[n];
                continue;
            }
        int minCost = Math.min(dp[n-1], dp[n-2]);
        dp[n] = minCost + (n == cost.length ? 0 : cost[n]);
        }
         return dp[N];
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        //return minCost_memo(n, cost, dp);
        return minCost_dp(n,cost,dp);
    }
}
