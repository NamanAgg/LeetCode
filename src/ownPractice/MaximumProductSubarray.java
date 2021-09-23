package ownPractice;
//*************152. Maximum Product Subarray
// Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product,
// and return the product.
// It is guaranteed that the answer will fit in a 32-bit integer.
// A subarray is a contiguous subsequence of the array.

// Example 1:
// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.

// Example 2:
// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

// Constraints:
// 1 <= nums.length <= 2 * 104
// -10 <= nums[i] <= 10
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
public class MaximumProductSubarray {
    public int maxProduct(int[] arr) {
        int n = arr.length; 
        if(n==1) return arr[0];  //base case
        
        long maxSoFar = Integer.MIN_VALUE;
        long maxEndingHere=1; //always be positive 
        long minEndingHere=1; //always ne negative ofcourse when intialize or reintialize it is 1.
        boolean maxUpdationTookPlaceAtleastOnce = false;
        for(int i = 0;i<n;i++){
            int val = arr[i];
            if(val>0){
                maxEndingHere = maxEndingHere*val;
                minEndingHere = Math.min(minEndingHere*val,1); //why comparison you ask,bcs if minEndingHere is 
                                                               //already negative then by multiplying by val we get
                                                              //more negative value. else we gotta have to make it one.
                maxUpdationTookPlaceAtleastOnce=true;
            }
            else if(val==0){
                maxEndingHere=1;
                minEndingHere=1;
            }
            else{  //if arr[i] is negative
                long max = maxEndingHere;
                // maxEndingHere=Math.max(minEndingHere*val,1);
                long maybeMax = minEndingHere*val;
                if(maybeMax>=1)
                    maxUpdationTookPlaceAtleastOnce=true;
                maxEndingHere=Math.max(maybeMax,1);
                minEndingHere= max*val;
            }
            
           
            if(maxEndingHere>maxSoFar)
                maxSoFar=maxEndingHere;
        }
        
        if(!maxUpdationTookPlaceAtleastOnce) return 0;
        
        return (int)maxSoFar;
        
        
    }
}
