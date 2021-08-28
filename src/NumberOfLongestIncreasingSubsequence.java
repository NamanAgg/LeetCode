//**************673. Number of Longest Increasing Subsequence
// Given an integer array nums, return the number of longest increasing subsequences.
// Notice that the sequence has to be strictly increasing.

// Example 1:
// Input: nums = [1,3,5,4,7]
// Output: 2
// Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].

// Example 2:
// Input: nums = [2,2,2,2,2]
// Output: 5
// Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.

// Constraints:
// 1 <= nums.length <= 2000
// -106 <= nums[i] <= 106
public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int n=nums.length;
        int[]dp=new int[n];
        int[]count=new int[n];
        int max=0;
        int maxCount=0;
        for(int i=0;i<n;i++){
            dp[i]=1;
            count[i]=1; 
            
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }
                    else if(dp[i]==dp[j]+1)
                       count[i]+=count[j]; 
                    
                }
            }
            
           if(max<dp[i]){
               max=dp[i];
               maxCount=count[i];
           }
           else if(max==dp[i])
               maxCount+=count[i];
        }
        
        return maxCount;
    }
}
