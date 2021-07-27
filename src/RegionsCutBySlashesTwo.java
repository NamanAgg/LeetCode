//*****************959. Regions Cut By Slashes
// An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or blank space ' '.
// These characters divide the square into contiguous regions.
// Given the grid grid represented as a string array, return the number of regions.
// Note that backslash characters are escaped, so a '\' is represented as '\\'.

// Example 1:
// Input: grid = [" /","/ "]
// Output: 2

// Example 2:
// Input: grid = [" /","  "]
// Output: 1

// Example 3:
// Input: grid = ["\\/","/\\"]
// Output: 4
// Explanation: (Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.)

// Example 4:
// Input: grid = ["/\\","\\/"]
// Output: 5
// Explanation: (Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.)

// Example 5:
// Input: grid = ["//","/ "]
// Output: 3
 
// Constraints:
// n == grid.length
// n == grid[i].length
// 1 <= n <= 30
// grid[i][j] is either '/', '\', or ' '.
public class RegionsCutBySlashesTwo{
    int[] par, size;

    public int findPar(int u) {
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }
    public int regionsBySlashes(String[] grid) {
        if (grid.length == 0)
            return 0;
        int n = grid.length, m = n + 1, region = 1;
        par = new int[m * m];
        for (int i = 0; i < m * m; i++) {
            par[i] = i;
            int r = i / m, c = i % m;
            if (r == 0 || c == 0 || r == m - 1 || c == m - 1)
                par[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            String s = grid[i];
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                int p1 = -10000, p2 = -100000;
                if (ch == '/') {
                    p1 = findPar(i * m + j + 1);
                    p2 = findPar((i + 1) * m + j);
                } else if (ch == '\\') {
                    p1 = findPar(i * m + j);
                    p2 = findPar((i + 1) * m + j + 1);
                } else // for space
                    continue;

                if (p1 != p2)
                    par[p1] = p2;
                else
                    region++;
            }
        }

        return region;
    }
}