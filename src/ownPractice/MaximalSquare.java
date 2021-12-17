//**************221. Maximal Square
// Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

// Example 1:
// Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 4

// Example 2:
// Input: matrix = [["0","1"],["1","0"]]
// Output: 1

// Example 3:
// Input: matrix = [["0"]]
// Output: 0

// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] is '0' or '1'.
public class MaximalSquare {
    // a very famous dp question.
//     int max = 0;
//     public int maximalSquare(char[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int[][]dp = new int[m][n];
//         for(int[]d : dp)
//             Arrays.fill(d,-1);
        
//         getMaximalSquare(matrix,0,0,dp);
//         return max*max;
//     }
    
//     public int getMaximalSquare(char[][]matrix,int i,int j,int[][]dp){
//         if(i==matrix.length || j==matrix[0].length) return 0;
//         if(dp[i][j]!=-1) return dp[i][j];
        
//         if(i==matrix.length-1 || j == matrix[0].length-1) {
//             max = Math.max(max,matrix[i][j]-'0');
//             getMaximalSquare(matrix,i+1,j,dp);
//             getMaximalSquare(matrix,i,j+1,dp);
//             return dp[i][j] = matrix[i][j]-'0';
//         }
//         if(matrix[i][j]=='0'){ 
//             getMaximalSquare(matrix,i+1,j+1,dp);
//             getMaximalSquare(matrix,i,j+1,dp);
//             getMaximalSquare(matrix,i+1,j,dp);
//             return dp[i][j] = 0;
//         }
        
//         dp[i][j] = Math.min(getMaximalSquare(matrix,i+1,j+1,dp),Math.min(getMaximalSquare(matrix,i,j+1,dp),getMaximalSquare(matrix,i+1,j,dp)))+1;
//         max = Math.max(dp[i][j],max);
        
//         return dp[i][j];
//     }
public int maximalSquare(char[][] a) {
    if (a == null || a.length == 0 || a[0].length == 0)
      return 0;
        
    int max = 0, n = a.length, m = a[0].length;
    
    // dp(i, j) represents the length of the square 
    // whose lower-right corner is located at (i, j)
    // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
    int[][] dp = new int[n + 1][m + 1];
    
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (a[i - 1][j - 1] == '1') {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
          max = Math.max(max, dp[i][j]);
        }
      }
    }
    
    // return the area
    return max * max;
  }
  } 
}
