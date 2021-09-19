package ownPractice;
//*********************18. 4Sum
// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

// Example 1:
// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

// Example 2:
// Input: nums = [2,2,2,2,2], target = 8
// Output: [[2,2,2,2]]

// Constraints:
// 1 <= nums.length <= 200
// -109 <= nums[i] <= 109
// -109 <= target <= 109
public class 4Sum {
    private  List<List<Integer>> twoSum_(int[] arr, int target, int st) {
        int left = st;
        int right = arr.length - 1;
        List<List<Integer>> res = new ArrayList<>();

        while(left < right) {
            // how to prevent repitition
            if(left != st && arr[left] == arr[left - 1]) {
                left++;
                continue;
            }

            int sum = arr[left] + arr[right];
            if(sum == target) {
                List<Integer> subres = new ArrayList<>();
                subres.add(arr[left]);
                subres.add(arr[right]);
                res.add(subres);
                left++;
                right--;
            } else if(sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
    private List<List<Integer>> threeSum_(int[] nums, int targ, int st) {
        // Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i = st; i <= n - 3; i++) {
            if(i != st && nums[i] == nums[i - 1]) {
                continue;
            }

            int val1 = nums[i];
            List<List<Integer>> subres = twoSum_(nums, targ - val1, i + 1);
            for(List<Integer> list : subres) {
                list.add(val1);
                res.add(list);
            }
        }
        return res;
    }

    public  List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i <= n - 4; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int val1 = nums[i];
            List<List<Integer>> subres = threeSum_(nums, target - val1, i + 1);
            for(List<Integer> list : subres) {
                list.add(val1);
                res.add(list);
            }
        }
        return res;
    }    
}