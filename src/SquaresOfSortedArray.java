//***********977. Squares of a Sorted Array
// Given an integer array nums sorted in non-decreasing order,
// return an array of the squares of each number sorted in non-decreasing order.

// Example 1:
// Input: nums = [-4,-1,0,3,10]
// Output: [0,1,9,16,100]
// Explanation: After squaring, the array becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].

// Example 2:
// Input: nums = [-7,-3,2,3,11]
// Output: [4,9,9,49,121]

// Constraints:
// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums is sorted in non-decreasing order.

// Follow up: Squaring each element and sorting the new array is very trivial,
// could you find an O(n) solution using a different approach?

// **gotta take O(n) space here and used 2 pointer technique where one pointer is at starting and another is in end,
// then we will check square of ar[i] and ar[j] whoever is bigger we will put in our answer array and then do i++ if ar[i]
// is bigger else j--**


public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] arr) {
        int[]ans =new int[arr.length];
        
        int i = 0;
        int j = arr.length-1;
        
        for(int k = arr.length -1 ; k>=0; k--){
            int sq1 = arr[i]*arr[i];
            int sq2 = arr[j]*arr[j];
            if(sq1>sq2){
                ans[k]=sq1;
                i++;
            }
            else{
                ans[k]=sq2;
                j--;
            }
        }
        
        return ans;
    }
}
