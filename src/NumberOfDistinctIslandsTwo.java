//****************694: Number of Distinct Islands
// Given a non-empty 2D array grid of 0’s and 1’s, an island is a group of 1’s (representing land)
// connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
// Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated
// (and not rotated or reflected) to equal the other.

// Example 1:
// 11000
// 11000
// 00011
// 00011
// Given the above grid map, return 1.

// Example 2:
// 11011
// 10000
// 00001
// 11011

// Notice that:
// 11
// 1
// and
//  1
// 11
// are considered different island shapes, because we do not consider reflection / rotation.
public class NumberOfDistinctIslandsTwo{
    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    String[] dirS = { "D", "U", "R", "L" };

    StringBuilder sb;
    int n, m;

    public void numDistinctIslands(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        for (int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1) {
                sb.append(dirS[d]);
                numDistinctIslands(grid, r, c);
                sb.append("b");
            }
        }
    }

    public int numDistinctIslands(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    sb = new StringBuilder();
                    numDistinctIslands(grid, i, j);
                    set.add(sb.toString());
                }
            }
        }

        return set.size();
    }
}