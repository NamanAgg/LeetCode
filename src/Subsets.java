public class Subsets {
//******78. Subsets
// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

// Example 1:
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

// Example 2:
// Input: nums = [0]
// Output: [[],[0]]

// Constraints:
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// All the numbers of nums are unique.
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans  = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        solution(nums, 0, small, ans);
        return ans;
    }
    
    public void solution(int[]arr, int idx, List<Integer> small, List<List<Integer>> ans){
        if(idx == arr.length){
            List<Integer> base = new ArrayList<>(small);
            ans.add(base);
            return;
        }
        
        small.add(arr[idx]);
        solution(arr, idx+1, small, ans);
        small.remove(small.size()-1);
        solution(arr, idx+1, small, ans);
    }
}
}
