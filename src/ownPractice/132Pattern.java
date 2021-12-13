package ownPractice;
//*********456. 132 Pattern
// Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i],
// nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
// Return true if there is a 132 pattern in nums, otherwise, return false.

// Example 1:
// Input: nums = [1,2,3,4]
// Output: false
// Explanation: There is no 132 pattern in the sequence.

// Example 2:
// Input: nums = [3,1,4,2]
// Output: true
// Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

// Example 3:
// Input: nums = [-1,3,2,0]
// Output: true
// Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

// Constraints:
// n == nums.length
// 1 <= n <= 2 * 105
// -109 <= nums[i] <= 109
public class 132Pattern {
      //Very important stack question and the link for the explanation is given below
   // https://www.youtube.com/watch?v=h5-QRLkmrIY
   public boolean find132pattern(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int[]minArray = makeMinArray(nums);
    for(int i = nums.length-1;i>=0;i--){
        while(!stack.isEmpty() && stack.peek()<=minArray[i])
            stack.pop();
        
        if(!stack.isEmpty() && stack.peek()<nums[i])
            return true;
        else 
            stack.push(nums[i]); 
    }
            
    
    return false;
}

public int[] makeMinArray(int[]arr){
    int[]ans = new int[arr.length];
    int min  = arr[0];
    ans[0] = arr[0];
    for(int i = 1;i<arr.length;i++){
        min = Math.min(min,arr[i]);
        ans[i] = min;
    }
    
    return ans;
}    
}
