//***************75. Sort Colors
// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
// with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
// You must solve this problem without using the library's sort function.

// Example 1:
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]

// Example 2:
// Input: nums = [2,0,1]
// Output: [0,1,2]

// Example 3:
// Input: nums = [0]
// Output: [0]

// Example 4:
// Input: nums = [1]
// Output: [1]

// Constraints:
// n == nums.length
// 1 <= n <= 300
// nums[i] is 0, 1, or 2.
 
// Follow up: Could you come up with a one-pass algorithm using only constant extra space?
public class SortColors {
    public void sortColors(int[] nums) {        
        int i=-1;
        int k=nums.length;
        int j=0;
        while(j<k && i<k){
            int val = nums[j];
            if(val==1) j++;
            else if(val==0)
                swap(nums,++i,j++);
            else swap(nums,--k,j);
        }
    }
    
    public void swap(int[]arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    } 
}
