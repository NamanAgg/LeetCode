//************************305.Number of Islands II
// A 2d grid map of m rows and n columns is initially filled with water.
// We may perform an addLand operation which turns the water at position (row, col) into a land.
// Given a list of positions to operate, count the number of islands after each addLand operation.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.

// Example:
// Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].

// Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
// 0 0 0
// 0 0 0
// 0 0 0

// Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
// 1 0 0
// 0 0 0   Number of islands = 1
// 0 0 0

// Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
// 1 1 0
// 0 0 0   Number of islands = 1
// 0 0 0

// Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
// 1 1 0
// 0 0 1   Number of islands = 2
// 0 0 0

// Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
// 1 1 0
// 0 0 1   Number of islands = 3
// 0 1 0

// We return the result as an array: [1, 1, 2, 3].
public class NumberOfIslands2{
    public List<Integer> numIslands2(int n, int m, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        par = new int[n * m];
        Arrays.fill(par, -1);

        int count = 0;
        for (int[] p : positions) {
            int i = p[0], j = p[1];
            if (par[i * m + j] == -1) {
                count++;
                par[i * m + j] = i * m + j;

                int p1 = findPar(i * m + j);
                for (int d = 0; d < dir.length; d++) {
                    int r = i + dir[d][0];
                    int c = j + dir[d][1];

                    if (r >= 0 && c >= 0 && r < n && c < m && par[r * m + c] != -1) {
                        int p2 = findPar(r * m + c);
                        if (p1 != p2) {
                            count--;
                            par[p2] = p1;
                        }
                    }
                }
            }
            ans.add(count);
        }

        return ans;
    }
}