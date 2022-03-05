//**************740. Delete and Earn
// You are given an integer array nums. You want to maximize the number of points you get by performing the following operation
// any number of times:
// Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and
// every element equal to nums[i] + 1.
// Return the maximum number of points you can earn by applying the above operation some number of times.

// Example 1:
// Input: nums = [3,4,2]
// Output: 6
// Explanation: You can perform the following operations:
// - Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
// - Delete 2 to earn 2 points. nums = [].
// You earn a total of 6 points.

// Example 2:
// Input: nums = [2,2,3,3,3,4]
// Output: 9
// Explanation: You can perform the following operations:
// - Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
// - Delete a 3 again to earn 3 points. nums = [3].
// - Delete a 3 once more to earn 3 points. nums = [].
// You earn a total of 9 points.

// Constraints:
// 1 <= nums.length <= 2 * 104
// 1 <= nums[i] <= 104
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer e : nums) map.put(e, map.getOrDefault(e,0)+1);
        ArrayList<Integer> list = new ArrayList<>();     
        for(Integer e : map.keySet()) list.add(e);
        
        int[]arr = new int[list.size()];
        int i = 0;
        for(Integer e : list)
            arr[i++] = e;

        Arrays.sort(arr);
        int[]dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return deleteAndEarn(arr, arr.length-1, dp, map);
    }
    
    public int deleteAndEarn(int[]arr, int idx, int[]dp,HashMap<Integer,Integer>map){
        if(idx<0) return 0;
        if(idx==0)return dp[idx] = arr[idx] * map.get(arr[idx]);
        
        if(dp[idx]!=-1) return dp[idx];
        
        int myVal = arr[idx]*map.get(arr[idx]);
        if(arr[idx-1]==arr[idx]-1){
            int first = deleteAndEarn(arr, idx-2, dp, map)+myVal;
            int second  = deleteAndEarn(arr, idx-1, dp, map);
            return dp[idx] = Math.max(first, second);
        }
        return dp[idx] = deleteAndEarn(arr,idx-1, dp, map) + myVal;
    }
}
