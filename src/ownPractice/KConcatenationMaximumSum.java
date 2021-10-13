//*****************1191. K-Concatenation Maximum Sum
// Given an integer array arr and an integer k, modify the array by repeating it k times.
// For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].
// Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in that case is 0.
// As the answer can be very large, return the answer modulo 109 + 7.

// Example 1:
// Input: arr = [1,2], k = 3
// Output: 9

// Example 2:
// Input: arr = [1,-2,1], k = 5
// Output: 2

// Example 3:
// Input: arr = [-1,-2], k = 7
// Output: 0

// Constraints:
// 1 <= arr.length <= 105
// 1 <= k <= 105
// -104 <= arr[i] <= 104
public class KConcatenationMaximumSum {
    //There are 3 cases : 
//1. K==1, simply do kadane traversal
//2. if sum of given array is negative, then answer can obtained from first two copies of array.
//3. if sum>0, then we can do merge first and last copy of array(which is same as merging first two copies) , do kadane and  
//   add remaining between sum of arrays/copies of array i.e. (k-2)*sum

    public int mod = (int)(Math.pow(10, 9) + 7);
    
    public int kConcatenationMaxSum(int[] arr, int k) {
        
		
        if(k==1)
            return (int)(kadane(arr)%mod);
        
        long sum=0;
        for(int i=0;i<arr.length;i++)
            sum+=arr[i];
        
        int[] narr = new int[arr.length*2];
        
        for(int i=0;i<arr.length;i++){
            narr[i]=arr[i];
            narr[i+arr.length] = arr[i];
        }
        
        if(sum<0){
            long kadaneTwo = kadane(narr);
            return (int)(kadaneTwo%mod);
        }
        
        //sum>=0
        long kadaneTwo = kadane(narr) + (k-2)*sum;
        return (int)(kadaneTwo%mod);
      
    }
    
    public long kadane(int[] arr){
        
        long currMax=0,max = 0;
        
        for(int i=0;i<arr.length;i++){
            currMax = Math.max(currMax+arr[i],arr[i]);
            max = Math.max(currMax,max);
        }
        
        return max;
    }    
}
