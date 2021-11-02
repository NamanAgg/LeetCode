//*****************980. Unique Paths III
// You are given an m x n integer array grid where grid[i][j] could be:
// 1 representing the starting square. There is exactly one starting square.
// 2 representing the ending square. There is exactly one ending square.
// 0 representing empty squares we can walk over.
// -1 representing obstacles that we cannot walk over.
// Return the number of 4-directional walks from the starting square to the ending square,
// that walk over every non-obstacle square exactly once.

// Example 1:
// Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
// Output: 2
// Explanation: We have the following two paths: 
// 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
// 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

// Example 2:
// Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
// Output: 4
// Explanation: We have the following four paths: 
// 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
// 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
// 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
// 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

// Example 3:
// Input: grid = [[0,1],[2,0]]
// Output: 0
// Explanation: There is no path that walks over every empty square exactly once.
// Note that the starting and ending square can be anywhere in the grid.

// Constraints:
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 20
// 1 <= m * n <= 20
// -1 <= grid[i][j] <= 2
// There is exactly one starting cell and one ending cell.
public class UniquePaths3 {
    int count = 0;
    int[][]dir = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]==1){
                    uniquePaths(grid,i,j);
                    break;
                }
        
        return count;
    }
    
    public void uniquePaths(int[][]grid,int r,int c){
        if(grid[r][c]==2){
            boolean check = isAllEmptySquaresCovered(grid);
            if(check) count++;
            return;
        }
        grid[r][c] = -1;
        boolean res = false;
        for(int i=0;i<dir.length;i++){
            int row = r+dir[i][0];
            int col = c+dir[i][1];
            
            if(row<grid.length && col<grid[0].length && row>=0 && col>=0 && grid[row][col]!=-1)
                uniquePaths(grid,row,col); 
        }
        grid[r][c] = 0;
    }
    
    public boolean isAllEmptySquaresCovered(int[][]grid){
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j]==0)
                    return false;
        
        return true;
    }

}
