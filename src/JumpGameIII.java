//****************1306. Jump Game III

// Given an array of non-negative integers arr, you are initially positioned at start index of the array.
// When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
// Notice that you can not jump outside of the array at any time.

// Example 1:
// Input: arr = [4,2,3,0,3,1,2], start = 5
// Output: true
// Explanation: 
// All possible ways to reach at index 3 with value 0 are: 
// index 5 -> index 4 -> index 1 -> index 3 
// index 5 -> index 6 -> index 4 -> index 1 -> index 3 

// Example 2:
// Input: arr = [4,2,3,0,3,1,2], start = 0
// Output: true 
// Explanation: 
// One possible way to reach at index 3 with value 0 is: 
// index 0 -> index 4 -> index 1 -> index 3

// Example 3:
// Input: arr = [3,0,2,1,2], start = 2
// Output: false
// Explanation: There is no way to reach at index 1 with value 0.

// Constraints:
// 1 <= arr.length <= 5 * 104
// 0 <= arr[i] < arr.length
// 0 <= start < arr.length


//Simple DFS applied
public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        boolean[]vis = new boolean[arr.length];
        return canReach(arr,start,vis);
    }
    
    public boolean canReach(int[]arr,int start,boolean []vis){
        if(arr[start]==0) return true;
        
        vis[start]  = true;
        boolean myAns = false;
        int val = arr[start];
        int nextPos1 = val+start;
        int nextPos2 = start - val;
         if(nextPos1<arr.length && nextPos1>=0 && !vis[nextPos1])
            myAns = canReach(arr,nextPos1,vis)==true ? true : myAns;
        if(nextPos2>=0 && nextPos2<arr.length && !vis[nextPos2])
            myAns = canReach(arr,nextPos2,vis)==true ? true : myAns;
        
        return myAns;
    }
}
