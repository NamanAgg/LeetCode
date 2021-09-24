//*****************1027. Longest Arithmetic Subsequence
// Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.
// Recall that a subsequence of an array nums is a list nums[i1], nums[i2], ..., nums[ik] with
// 0 <= i1 < i2 < ... < ik <= nums.length - 1, and that a sequence seq is arithmetic if seq[i+1] - seq[i]
// are all the same value (for 0 <= i < seq.length - 1).

// Example 1:
// Input: nums = [3,6,9,12]
// Output: 4
// Explanation: 
// The whole array is an arithmetic sequence with steps of length = 3.

// Example 2:
// Input: nums = [9,4,7,2,10]
// Output: 3
// Explanation: 
// The longest arithmetic subsequence is [4,7,10].

// Example 3:
// Input: nums = [20,1,15,3,10,5,8]
// Output: 4
// Explanation: 
// The longest arithmetic subsequence is [20,15,10,5].

// Constraints:
// 2 <= nums.length <= 1000
// 0 <= nums[i] <= 500
public class LongestArithmeticSubsequence {
      //very similar to LIS type but here the dp is 2d coz of diff.
      public int longestArithSeqLength(int[] nums) {
        int max = maxElement(nums);
        int min = minElement(nums);
        int diff = max-min;
        int n = nums.length;
        int[][]dp=new int[n][2*diff+2];
        for(int[]d : dp)
          Arrays.fill(d,1); //every element can be included atleast once in any AP(by just including himself)  
        
        int ans =0;
        for(int i =0;i<n;i++)
            for(int j=i-1;j>=0;j--){
                int d = nums[i]-nums[j]+diff; //diff is added coz the 'd' could be negative too
                int temp = dp[j][d];            
                dp[i][d]=Math.max(dp[i][d],temp+1);
                if(ans<dp[i][d])
                    ans = dp[i][d];
            }
        
        return ans;
        
    }

    
    public int maxElement(int[]arr){
        int max = Integer.MIN_VALUE;
        for(Integer e : arr)
            if(max<e)
                max=e;
        
        return max;
    }
    
    public int minElement(int[]arr){
        int min = Integer.MAX_VALUE;
        for(Integer e : arr)
            if(min>e)
                min=e;
        
        return min;
    }
}
