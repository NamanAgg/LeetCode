//*************743. Network Delay Time
// You are given a network of n nodes, labeled from 1 to n. You are also given times,
// a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node,
// vi is the target node, and wi is the time it takes for a signal to travel from source to target.
// We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal.
// If it is impossible for all the n nodes to receive the signal, return -1.

// Example 1:
// Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
// Output: 2

// Example 2:
// Input: times = [[1,2,1]], n = 2, k = 1
// Output: 1

// Example 3:
// Input: times = [[1,2,1]], n = 2, k = 2
// Output: -1

// Constraints:
// 1 <= k <= n <= 100
// 1 <= times.length <= 6000
// times[i].length == 3
// 1 <= ui, vi <= n
// ui != vi
// 0 <= wi <= 100
// All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
public class NetworkDelayTime {
       //applied dijkstra
       public int networkDelayTime(int[][] times, int n, int k) {
        //{v,w}
        ArrayList<int[]>[] graph=new ArrayList[n+1];
        int[] dis=new int[n+1];
        Arrays.fill(dis,(int)1e9);
        for(int i=0;i<=n;i++)
            graph[i]=new ArrayList<>();
        
        for(int[] e : times){
            graph[e[0]].add(new int[]{e[1],e[2]});
        }
        dijkstra(graph,k,dis);
        int max=0;
        for(int i=1;i<dis.length;i++){
            if(dis[i]==(int)1e9) return -1;
            else max= max < dis[i] ? dis[i] : max;
        }
        return max;
    }
    
    public void dijkstra(ArrayList<int[]>[]graph,int src,int[]dis){
        //{vtx,wsf}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1]; 
        });
        dis[src]=0;
        pq.add(new int[]{src, 0});
        while (pq.size() != 0) {
            //{vtx,wsf}
            int[] p = pq.remove();
            int vtx=p[0], wsf=p[1];
            if (wsf > dis[vtx])
                continue;

            for (int[] e : graph[vtx]) {
                int v=e[0], w=e[1];
                if (wsf + w < dis[v]) {
                    dis[v] = wsf + w;
                    pq.add(new int[]{v, wsf + w});
                }
            }
        }
        
    }
}
