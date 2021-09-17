//****************795. Number of Subarrays with Bounded Maximum
// Given an integer array nums and two integers left and right, return the number of contiguous non-empty subarrays
// such that the value of the maximum array element in that subarray is in the range [left, right].
// The test cases are generated so that the answer will fit in a 32-bit integer.

// Example 1:
// Input: nums = [2,1,4,3], left = 2, right = 3
// Output: 3
// Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].

// Example 2:
// Input: nums = [2,9,2,5,6], left = 2, right = 8
// Output: 7

// Constraints:
// 1 <= nums.length <= 105
// 0 <= nums[i] <= 109
// 0 <= left <= right <= 109
public class NumberOfSubarraysWithBoundedMaximum {
    int prevCount=0;
    int count=0;
    int i=0;
    int j=0;
    
    while(i<nums.length){
        if(nums[i]<=right && nums[i]>=left){
            count+=i-j+1;
            prevCount=i-j+1;
        }
        else if(nums[i]<left)
            count+=prevCount;
        else{  //nums[i]>right
            prevCount=0;
            j=i+1;
        }
        i++;
    }
    
    return count;
}
}
