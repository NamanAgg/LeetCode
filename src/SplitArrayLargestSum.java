//*************410. Split Array Largest Sum
// Given an array nums which consists of non-negative integers and an integer m,
// you can split the array into m non-empty continuous subarrays.
// Write an algorithm to minimize the largest sum among these m subarrays.

// Example 1:
// Input: nums = [7,2,5,10,8], m = 2
// Output: 18
// Explanation:
// There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8],
// where the largest sum among the two subarrays is only 18.

// Example 2:
// Input: nums = [1,2,3,4,5], m = 2
// Output: 9

// Example 3:
// Input: nums = [1,4,4], m = 3
// Output: 4

// Constraints:
// 1 <= nums.length <= 1000
// 0 <= nums[i] <= 106
// 1 <= m <= min(50, nums.length)
public class SplitArrayLargestSum {
        //totally same as allocation pages problem therefore do the same thing in it.
        public int splitArray(int[] arr, int M) {
            int N = arr.length; 
            if(M>arr.length) 
                return -1;
            
            int[]res = findMaxAndSum(arr);
            int low = res[0];
            int high = res[1];
            
            int burden = -1;
            
            while(low<=high){
                int mid = low + (high - low)/2;
                if(isPossible(arr,mid,M)){
                    burden = mid;
                    high = mid - 1;
                }
                else 
                    low = mid + 1;
            }
        
            return burden;
        }
        public boolean isPossible(int[]A,int mid,int M){
            int students = 1;
            int sum = 0;
            for(int i=0;i<A.length;i++) {
                sum += A[i];
                if(sum > mid) {
                    students++;
                    sum = A[i];
                }
                if(students > M) return false;
            }
            return true;
        }
        
        public int[] findMaxAndSum(int[]arr){
            int max  = -1;
            int sum = 0;
            for(Integer e : arr){
                max = Math.max(max,e);
                sum+=e;
            }
            
            return new int[]{max,sum};    
        }
}
