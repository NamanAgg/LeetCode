//***********768. Max Chunks To Make Sorted II
// You are given an integer array arr.
// We split arr into some number of chunks (i.e., partitions), and individually sort each chunk.
// After concatenating them, the result should equal the sorted array.
// Return the largest number of chunks we can make to sort the array.

// Example 1:
// Input: arr = [5,4,3,2,1]
// Output: 1
// Explanation:
// Splitting into two or more chunks will not return the required result.
// For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.

// Example 2:
// Input: arr = [2,1,3,4,4]
// Output: 4
// Explanation:
// We can split into two chunks, such as [2, 1], [3, 4, 4].
// However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.

// Constraints:
// 1 <= arr.length <= 2000
// 0 <= arr[i] <= 108
public class MaxChunksToMakeSorted2 {
    public int maxChunksToSorted(int[] arr) {
        int chunks=0;
        int[] max=leftMax(arr);
        int[]min = rightMin(arr);
        
        for(int i =0 ;i<arr.length;i++)
            if(i!=arr.length-1)
                if(max[i]<=min[i+1])
                    ++chunks;
                
        
        
        return chunks+1;
    }
    
    public int[]leftMax(int[]arr){
        int max = Integer.MIN_VALUE;
        int[]ans=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max)
                max=arr[i];
            ans[i]=max;
        }
        
        return ans;
    }
    
    public int[]rightMin(int[]arr){
        int min = Integer.MAX_VALUE;
        int[]ans=new int[arr.length];
        for(int i =arr.length-1;i>=0;i--){
            if(arr[i]<min)
                min=arr[i];
            ans[i]=min;
        }
        
        return ans;
    }
}
