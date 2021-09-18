package ownPractice;
//*************41. First Missing Positive
// Given an unsorted integer array nums, return the smallest missing positive integer.
// You must implement an algorithm that runs in O(n) time and uses constant extra space.

// Example 1:
// Input: nums = [1,2,0]
// Output: 3

// Example 2:
// Input: nums = [3,4,-1,1]
// Output: 2

// Example 3:
// Input: nums = [7,8,9,11,12]
// Output: 1

// Constraints:
// 1 <= nums.length <= 5 * 105
// -231 <= nums[i] <= 231 - 1
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //for array to have no first missing positive it should have numbers
        // 1 to n and every number should occur once and the answer for the question will be n+1.
        //using that logic we will traverse the array and use the idx as flag
        
        //this loop so as to give a constant value to all those elements that are not in range
        //that constant value is n+1
       for(int i = 0;i<n;i++)
           if(nums[i]>n ||nums[i]<=0)
               nums[i]=n+1;
        
        //now travel and mark present idx in array
        for(int i = 0;i<n;i++){
            if(Math.abs(nums[i])<=n){
                int idx=Math.abs(nums[i])-1;
                nums[idx]= -(Math.abs(nums[idx]));
            }
        }
        
        //check which nums[idx] is not negative,if found return idx+1 else return idx+1 
        for(int i =0;i<n;i++){
            if(nums[i]>=0) 
                return i+1;
        }
        
        return n+1;
    }