//*************525. Contiguous Array
// Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

// Example 1:
// Input: nums = [0,1]
// Output: 2
// Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

// Example 2:
// Input: nums = [0,1,0]
// Output: 2
// Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

// Constraints:
// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.
public class ContiguousArray {
     //again question very similar to subarrya sum equal to k
     public int findMaxLength(int[] nums) {
        int oneCount = 0;
        int ans =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int e = nums[i];
            if(e==1) oneCount++;
            else oneCount--;
            if(oneCount==0) ans = i+1;
            else{
                if(map.containsKey(oneCount))
                    ans = Math.max(ans,i-map.get(oneCount));
            }
            map.putIfAbsent(oneCount,i);
        }
        
        return ans;
    }
}
