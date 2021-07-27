//*****************463. Island Perimeter Easy

// You are given row x col grid representing a map where grid[i][j]=1 represents land and grid[i][j]=0 represents water.
// Grid cells are connected horizontally/vertically(not diagonally).The grid is completely surrounded by water,
// and there is exactly one island(i.e.,one or more connected land cells).
// The island doesn'thave"lakes",meaning the water inside isn'tconnected to the water around the island.
// One cell is a square with side length 1. The grid is rectangular,width and height don'texceed 100. Determine the perimeter of the island.

// Example 1:
// Input:grid=[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
// Output:16 
// Explanation:The perimeter is the 16 yellow stripes in the image above.
// Example 2:
// Input:grid=[[1]]
// Output:4 

// Example 3:
// Input:grid=[[1,0]]
// Output:4

// Constraints:
// row==grid.length col==grid[i].length 
// 1<=row,col<=100
// grid[i][j]is 0 or 1.
public class IslandPerimeterTwo {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dir = { { 1, 0 }, { 0, 1 } };

        int onceCount = 0, nbrCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    onceCount++;
                    for (int d = 0; d < 2; d++) {
                        int r = i + dir[d][0];
                        int c = j + dir[d][1];

                        if (r < n && c < m && grid[r][c] == 1)
                            nbrCount++;
                    }
                }
            }
        }
        return 4 * onceCount - 2 * nbrCount;
    }
}
