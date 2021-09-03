//*************416. Partition Equal Subset Sum
// Given a non-empty array nums containing only positive integers, 
//find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

// Example 1:
// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].

// Example 2:
// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.

// Constraints:
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum=0;
           for(Integer e : nums)
               sum+=e;
           if(nums.length==0 || sum%2!=0) return false;
           
           int[][]dp=new int[nums.length+1][sum/2+1];
           for(int[]d : dp)
               Arrays.fill(d,-1);
           return canPartition(nums,nums.length,sum/2,dp)==1?true:false;
       }
       
       public int canPartition(int[]nums,int n,int tar,int[][]dp){
            if (n == 0 || tar == 0) {
               return dp[n][tar] = (tar == 0 ? 1 : 0);
           }
   
           if (dp[n][tar] != -1)
               return dp[n][tar];
   
           boolean res = false;
           if (tar - nums[n - 1] >= 0)
               res =res || canPartition(nums, n - 1, tar - nums[n - 1], dp) == 1;
           res = res || canPartition(nums, n - 1, tar, dp) == 1;
   
           return dp[n][tar] = (res ? 1 : 0);
       }
}
