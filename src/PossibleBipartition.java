//*************886. Possible Bipartition
// Given a set of n people (numbered 1, 2, ..., n), we would like to split everyone into two groups of any size.
// Each person may dislike some other people, and they should not go into the same group. 
// Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
// Return true if and only if it is possible to split everyone into two groups in this way.

// Example 1:
// Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
// Output: true
// Explanation: group1 [1,4], group2 [2,3]

// Example 2:
// Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
// Output: false

// Example 3:
// Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
// Output: false

// Constraints:
// 1 <= n <= 2000
// 0 <= dislikes.length <= 10000
// dislikes[i].length == 2
// 1 <= dislikes[i][j] <= n
// dislikes[i][0] < dislikes[i][1]
// There does not exist i != j for which dislikes[i] == dislikes[j].
public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (n == 1)
            return true;
        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int[] dislike : dislikes) {
            int n1 = dislike[0] - 1;
            int n2 = dislike[1] - 1;
            if (graph[n1] == null)
                graph[n1] = new ArrayList<>();
            if (graph[n2] == null)
                graph[n2] = new ArrayList<>();

            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        return isBipartite(graph);
    }

    public boolean isBipartite(ArrayList<Integer>[] graph, int src, int[] vis) {
        LinkedList<Integer> que = new LinkedList<>();
        int color = 0;
        que.add(src);
        boolean isCycle = false, isBipartite = true;
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rvtx = que.removeFirst();
                if (graph[rvtx] == null)
                    continue;
                if (vis[rvtx] != -1) {
                    isCycle = true;
                    if (vis[rvtx] != color) {
                        isBipartite = false;
                        break;
                    }

                    continue;
                }

                vis[rvtx] = color;
                for (Integer e : graph[rvtx]) {
                    if (vis[e] == -1) {
                        que.addLast(e);
                    }
                }
            }
            color = (color + 1) % 2;
            if (!isBipartite)
                break;
        }

        return isBipartite;
    }

    public boolean isBipartite(ArrayList<Integer>[] graph) {
        int N = graph.length;
        int[] vis = new int[N];
        Arrays.fill(vis, -1);

        boolean res = true;
        for (int i = 0; i < N; i++)
            if (vis[i] == -1)
                res = res && isBipartite(graph, i, vis);

        return res;
    }
}
