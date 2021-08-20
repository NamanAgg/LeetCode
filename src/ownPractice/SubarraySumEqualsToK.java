//************560. Subarray Sum Equals K
// Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2

// Example 2:
// Input: nums = [1,2,3], k = 3
// Output: 2

// Constraints:
// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107
 package ownPractice;
// its an important question and here we are using **prefix sum**

// **Link of the video for the explanation of the code=>**  https://www.youtube.com/watch?v=MHocw0bP1rA&t=241s
public class SubarraySumEqualsToK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int ans=0;
        for(int e : nums){
            sum+=e;
            if(map.containsKey(sum-k))
                ans+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return ans;
    }
}
