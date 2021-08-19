//**********992. Subarrays with K Different Integers
// Given an integer array nums and an integer k, return the number of good subarrays of nums.
// A good array is an array where the number of different integers in that array is exactly k.
// For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
// A subarray is a contiguous part of an array.

// Example 1:
// Input: nums = [1,2,1,2,3], k = 2
// Output: 7
// Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

// Example 2:
// Input: nums = [1,2,1,3,4], k = 3
// Output: 3
// Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].

// Constraints:
// 1 <= nums.length <= 2 * 104
// 1 <= nums[i], k <= nums.length
public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        if(k>nums.length ||k==0) return 0;
         return (atMostK(nums, nums.length, k) - atMostK(nums, nums.length, k - 1));
    }

     public int atMostK(int arr[], int n, int k)
    {
 
        // To store the result
        int count = 0;
 
        // Left boundary of window
        int left = 0;
 
        // Right boundary of window
        int right = 0;
 
        // Map to keep track of number of distinct
        // elements in the current window
        HashMap<Integer, Integer> map = new HashMap<>();
 
        // Loop to calculate the count
        while (right < n) {
 
            // Calculating the frequency of each
            // element in the current window
            map.put(arr[right],
                    map.getOrDefault(arr[right], 0) + 1);
 
            // Shrinking the window from left if the
            // count of distinct elements exceeds K
            while (map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0)
                    map.remove(arr[left]);
                left++;
            }
 
            // Adding the count of subarrays with at most
            // K distinct elements in the current window
            count += right - left + 1;
            right++;
        }
        return count;
    }
}
