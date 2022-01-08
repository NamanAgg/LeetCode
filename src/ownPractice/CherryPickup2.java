//************1463. Cherry Pickup II
// You are given a rows x cols matrix grid representing a field of cherries where grid[i][j]
// represents the number of cherries that you can collect from the (i, j) cell.
// You have two robots that can collect cherries for you:
// Robot #1 is located at the top-left corner (0, 0), and
// Robot #2 is located at the top-right corner (0, cols - 1).
// Return the maximum number of cherries collection using both robots by following the rules below:
// From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
// When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
// When both robots stay in the same cell, only one takes the cherries.
// Both robots cannot move outside of the grid at any moment.
// Both robots should reach the bottom row in grid.
 
// Example 1:
// Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
// Output: 24
// Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
// Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
// Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
// Total of cherries: 12 + 12 = 24.

// Example 2:
// Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
// Output: 28
// Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
// Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
// Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
// Total of cherries: 17 + 11 = 28.

// Constraints:
// rows == grid.length
// cols == grid[i].length
// 2 <= rows, cols <= 70
// 0 <= grid[i][j] <= 100
public class CherryPickup2 {
    //here dp is dependent on movement of robots, therefore row of robots, col of robot1, col fo robot2 and then apply dfs
    public int cherryPickup(int[][] grid) {
        int m =grid.length;
        int n = grid[0].length;
        int[][][]dp = new int[m][n][n];
        for(int[][] arr  :dp)
            for(int[]d : arr)
                Arrays.fill(d,-1);
        
        return dfs(grid,0,0,n-1,dp);
            
    }
    int[]dirs = new int[]{1,0,-1};
    public int dfs(int[][]grid,int r,int c1,int c2,int[][][]dp){ //here we have not taken r1 and r2 bcz they will be same as row always increases
        if(r>=grid.length || c1<0 || c1>=grid[0].length || c2<0 || c2>=grid[0].length)
            return Integer.MIN_VALUE;
        
        if(dp[r][c1][c2]!=-1)
            return dp[r][c1][c2];
        
        if(r==grid.length-1){
            if(c1==c2) 
                return dp[r][c1][c2] = grid[r][c1];
            else
                return dp[r][c1][c2] = grid[r][c1]+grid[r][c2];
        }
        
        int myCherries = 0;
        
        for(Integer dirForC1 : dirs)
            for(Integer dirForC2 : dirs)
                myCherries = Math.max(myCherries,dfs(grid,r+1,c1+dirForC1,c2+dirForC2,dp));
        
        if(c1==c2) 
            return dp[r][c1][c2] = myCherries  + grid[r][c1];
        
        return dp[r][c1][c2] = myCherries + grid[r][c1] + grid[r][c2];
    }
}
