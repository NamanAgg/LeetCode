//************931. Minimum Falling Path Sum
// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
// A falling path starts at any element in the first row and chooses the element in the next row
/// that is either directly below or diagonally left/right. Specifically, the next element from position (row, col)
// will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

// Example 1:
// Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
// Output: 13
// Explanation: There are two falling paths with a minimum sum as shown.

// Example 2:
// Input: matrix = [[-19,57],[-40,-5]]
// Output: -59
// Explanation: The falling path with a minimum sum is shown.

// Constraints:
// n == matrix.length == matrix[i].length
// 1 <= n <= 100
// -100 <= matrix[i][j] <= 100
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][]dp = new int[n][n];
        for(int[]d : dp)
            Arrays.fill(d, -1);
        int myAns = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
            myAns = Math.min(myAns, minFallingPathSum(matrix, 0, i, dp));
        return myAns;
    }
    
    public int minFallingPathSum(int[][]matrix,int i, int j, int[][]dp){
        if(j<0 || j==matrix.length) return Integer.MAX_VALUE;
        if(i==matrix.length-1)
            return dp[i][j] = matrix[i][j];
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int myAns = Integer.MAX_VALUE;
        int temp = Math.min(minFallingPathSum(matrix, i+1, j,dp), minFallingPathSum(matrix, i+1, j+1,dp));
        temp = Math.min(minFallingPathSum(matrix, i+1, j-1,dp), temp);
        
        myAns = Math.min(myAns, temp) + matrix[i][j];
        
        return dp[i][j] = myAns;
    }
}
