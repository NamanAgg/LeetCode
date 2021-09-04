package ownPractice;
//************312. Burst Balloons
// You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums.
// You are asked to burst all the balloons.
// If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins.
// If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
// Return the maximum coins you can collect by bursting the balloons wisely.

// Example 1:
// Input: nums = [3,1,5,8]
// Output: 167
// Explanation:
// nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
// coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167

// Example 2:
// Input: nums = [1,5]
// Output: 10

// Constraints:
// n == nums.length
// 1 <= n <= 500
// 0 <= nums[i] <= 100

// **Very Important question based on cut strategy**
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[][] dp = new int[n][n];
        
        return maxCoins(nums,0,n-1,dp);
        
    }
    public int maxCoins(int[] nums, int si, int ei, int[][] dp) {
        if (dp[si][ei] != 0)
            return dp[si][ei];
        
        int maxCost = 0;
        
        int lval = si==0?1:nums[si-1];
        int rval = ei==nums.length-1?1:nums[ei+1];
        
        for (int cut = si; cut <= ei; cut++) {
           int leftCost = cut == si ? 0 : maxCoins(nums, si, cut - 1, dp);
            int rightCost = cut == ei ? 0 : maxCoins(nums, cut + 1, ei, dp);

            int myCost = leftCost + lval * nums[cut] * rval + rightCost;
            maxCost = Math.max(maxCost, myCost);
        }

        return dp[si][ei] = maxCost;
    }
}
