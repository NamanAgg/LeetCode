//************1168.optimize-water-distribution-in-a-village
// There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.
// For each house i, we can either build a well inside it directly with cost wells[i], or pipe in water from another well to it.
// The costs to lay pipes between houses are given by the array pipes, where each pipes[i] = [house1, house2, cost]
// represents the cost to connect house1 and house2 together using a pipe. Connections are bidirectional.
// Find the minimum total cost to supply water to all houses.

// Example 1:
// Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
// Output: 3
// Explanation: 
// The image shows the costs of connecting houses using pipes.
// The best strategy is to build a well in the first house with cost 1 and connect the other houses to it with cost 2 so the total cost is 3.

// Constraints:
// 1 <= n <= 10000
// wells.length == n
// 0 <= wells[i] <= 10^5
// 1 <= pipes.length <= 10000
// 1 <= pipes[i][0], pipes[i][1] <= n
// 0 <= pipes[i][2] <= 10^5
// pipes[i][0] != pipes[i][1]
public class OptimizeWaterDistributionInAVillageTwo{
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        ArrayList<int[]> allPipes = new ArrayList<>();
        for (int[] a : pipes)
            allPipes.add(a);
        for (int i = 0; i < wells.length; i++)
            allPipes.add(new int[] { 0, i + 1, wells[i] });

        Collections.sort(allPipes, (a, b) -> {
            return a[2] - b[2];
        });

        par = new int[n + 1];
        int ans = 0;

        for (int i = 0; i <= n; i++) {
            par[i] = i;
        }

        for (int[] e : allPipes) {
            int u = e[0], v = e[1], w = e[2];
            int p1 = findPar(u), p2 = findPar(v);
            if (p1 != p2) {
                par[p1] = p2;
                ans += w;
            }
        }

        return ans;
    }
}
