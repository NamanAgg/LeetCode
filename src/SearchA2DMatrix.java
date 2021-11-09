//**************74. Search a 2D Matrix
// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
 
// Example 1:
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true

// Example 2:
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false

// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0;i<m;i++){
            int low = matrix[i][0];
            int high = matrix[i][n-1];
            if(low<=target && high>=target) return binarySearch(matrix[i],target);
        }
        
        return false;
    }
    
    public boolean binarySearch(int[]arr,int target){
        int low = 0 , high = arr.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==target) return true;
            if(arr[mid]>target) high = mid-1;
            else low = mid+1;
        }
        
        return false;
    }
}
