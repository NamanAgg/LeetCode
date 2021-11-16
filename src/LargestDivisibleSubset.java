//***************368. Largest Divisible Subset
// Given a set of distinct positive integers nums,
// return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
// answer[i] % answer[j] == 0, or
// answer[j] % answer[i] == 0
// If there are multiple solutions, return any of them.

// Example 1:
// Input: nums = [1,2,3]
// Output: [1,2]
// Explanation: [1,3] is also accepted.

// Example 2:
// Input: nums = [1,2,4,8]
// Output: [1,2,4,8]

// Constraints:
// 1 <= nums.length <= 1000
// 1 <= nums[i] <= 2 * 109
// All the integers in nums are unique.

import java.util.*;
import java.io.*;
public class LargestDivisibleSubset {
     
    //its a question of LIS DP
    //one thing to note if we want both the condition of '%' satisfied then 
    //suppose we have two numbers A and B then A<B and B%A == 0 then only both those
    //condition could be satisfied and therfore first we will sort the array and then apply
    //LIS strategy and boom we got the answer.
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        ArrayList<Integer>[]dp = new ArrayList[n];
        for(int i=0;i<n;i++)
            dp[i] = new ArrayList<>();
        
         
        for(int i=0;i<nums.length;i++){
            for(int j=i-1;j>=0;j--)
                if(nums[i]%nums[j]==0 && dp[i].size()<dp[j].size())
                    dp[i] = new ArrayList<>(dp[j]);
            
            dp[i].add(nums[i]);
        }
        
        int maxLengthIdx = 0;
        for(int i=0;i<n;i++)
            if(dp[i].size()>dp[maxLengthIdx].size())
                maxLengthIdx = i;


        return dp[maxLengthIdx];
    }
}
