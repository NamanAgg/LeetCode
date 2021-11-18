//***************448. Find All Numbers Disappeared in an Array
// Given an array nums of n integers where nums[i] is in the range [1, n],
// return an array of all the integers in the range [1, n] that do not appear in nums.

// Example 1:
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [5,6]

// Example 2:
// Input: nums = [1,1]
// Output: [2]

// Constraints:
// n == nums.length
// 1 <= n <= 105
// 1 <= nums[i] <= n

// Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            int val = Math.abs(nums[i])-1;
            nums[val] = -Math.abs(nums[val]);
        }
        
        for(int i = 0;i<nums.length;i++)
            if(nums[i]>0) ans.add(i+1);
        
        return ans;
    }
}
