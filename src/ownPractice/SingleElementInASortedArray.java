package ownPractice;
//**************540. Single Element in a Sorted Array
// You are given a sorted array consisting of only integers where every element appears exactly twice,
// except for one element which appears exactly once.
// Return the single element that appears only once.
// Your solution must run in O(log n) time and O(1) space.

// Example 1:
// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2

// Example 2:
// Input: nums = [3,3,7,7,10,11,11]
// Output: 10

// Constraints:
// 1 <= nums.length <= 105
// 0 <= nums[i] <= 105
public class SingleElementInASortedArray {
    //Used BinarySearch here
    //so when we get to middle we check whether is there any same element to its left or right 
    //if it is in left then we will divide the array that is between low and high into two array 
    //where first array has elements from low to mid and another from mid+1 to high
    //then we check which array size is odd and we will then only focus on that array coz answer will be 
    //in odd size array.
    //do the same for other case i.e if element present in mid same as mid+1 just teh vice versa
    public int singleNonDuplicate(int[]nums){
        int low = 0;
        int high  = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(mid-1>=0 && nums[mid-1]==nums[mid]){
                int currSize = mid - low+1;
                int rightSize = high - mid;
                if(currSize%2!=0) high = mid-2;
                else low = mid+1;
            }
            else if(mid+1<nums.length && nums[mid+1]==nums[mid]){
                int currSize = high - mid + 1;
                int leftSize = mid - low;
                if(currSize%2!=0) low = mid+2;
                else high = mid-1;
            }
            else return nums[mid];
        }
        
        return nums[high];
    }
}
