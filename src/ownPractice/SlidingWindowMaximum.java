package ownPractice;
//*************239. Sliding Window Maximum
// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of
// the array to the very right. You can only see the k numbers in the window.
// Each time the sliding window moves right by one position.
// Return the max sliding window.

// Example 1:
// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7

// Example 2:
// Input: nums = [1], k = 1
// Output: [1]

// Example 3:
// Input: nums = [1,-1], k = 1
// Output: [1,-1]

// Example 4:
// Input: nums = [9,11], k = 2
// Output: [11]

// Example 5:
// Input: nums = [4,-2], k = 2
// Output: [4]

// Constraints:
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// 1 <= k <= nums.length
public class SlidingWindowMaximum {
    private int[] ngri(int[] arr) {
        // ngri -> next greater on right (index)
        int n = arr.length;
        int[] ngr = new int[n];
        Stack<Integer> st = new Stack<>(); // add index in stack
        st.push(0);
        for(int i = 1; i < n; i++) {
            while(st.size() > 0 && arr[i] > arr[st.peek()]) {
                ngr[st.pop()] = i;
            }
            st.push(i);
        }
        while(st.size() > 0) {
            ngr[st.pop()] = n;
        }
        return ngr;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ngr = ngri(nums);
        int[] res = new int[n - k + 1];

        int j = 0;
        for(int i = 0; i < res.length; i++) {
            if(j < i) j = i;

            while(ngr[j] < i + k) {
                j = ngr[j];
            }
            res[i] = nums[j];
        }
        return res;
    }
}
