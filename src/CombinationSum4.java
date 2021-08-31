//************377. Combination Sum IV
// Given an array of distinct integers nums and a target integer target,
// return the number of possible combinations that add up to target.
// The answer is guaranteed to fit in a 32-bit integer.

// Example 1:
// Input: nums = [1,2,3], target = 4
// Output: 7
// Explanation:
// The possible combination ways are:
// (1, 1, 1, 1)
// (1, 1, 2)
// (1, 2, 1)
// (1, 3)
// (2, 1, 1)
// (2, 2)
// (3, 1)
// Note that different sequences are counted as different combinations.

// Example 2:
// Input: nums = [9], target = 3
// Output: 0

// Constraints:
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 1000
// All the elements of nums are unique.
// 1 <= target <= 1000

// Follow up: What if negative numbers are allowed in the given array? How does it change the problem?
// What limitation we need to add to the question to allow negative numbers?
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int[]dp=new int[target+1];
        Arrays.fill(dp,-1);
        
        return permutation_memo(nums,target,dp);
    }
    
   public  int permutation_memo(int[] arr, int tar,int[] dp) {
      if (tar == 0) {
            return dp[tar] = 1;
        }

        if (dp[tar] != -1)
            return dp[tar];
        int count = 0;
        for (int ele : arr) {
            if (tar - ele >= 0) {
                count += permutation_memo(arr, tar - ele, dp);
            }
        }

        return dp[tar] = count;  
   }
}
