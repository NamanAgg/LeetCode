//************628. Maximum Product of Three Numbers
// Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

// Example 1:
// Input: nums = [1,2,3]
// Output: 6

// Example 2:
// Input: nums = [1,2,3,4]
// Output: 24

// Example 3:
// Input: nums = [-1,-2,-3]
// Output: -6

// Constraints:
// 3 <= nums.length <= 104
// -1000 <= nums[i] <= 1000
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;  //for the biggest number
        int max2 = Integer.MIN_VALUE;  //for the second biggest number
        int max3 = Integer.MIN_VALUE;  //for the third biggest number
        
        int min1 = Integer.MAX_VALUE;  //for the most min number
        int min2 = Integer.MAX_VALUE;  //for the second most min number
        
        for(int e : nums){
            if(e>max1){
                max3=max2;
                max2=max1;
                max1=e;
            }
            else if(e>max2){
                max3=max2;
                max2=e;
            }
            else if(e>max3)
                max3=e;
            
            if(e<min1){
                min2=min1;
                min1=e;
            }
            else if(e<min2)
                min2=e;
        }
        
        return Math.max(max1*max2*max3,max1*min1*min2); //this is done because the two most min numbers could be
                                                        //-ive and their product can give a very big +ve number
    }
}
