//**********1192. Critical Connections in a Network
// There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections
// forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi.
// Any server can reach other servers directly or indirectly through the network.
// A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
// Return all critical connections in the network in any order.

// Example 1:
// Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
// Output: [[1,3]]
// Explanation: [[3,1]] is also accepted.
 
// Constraints:
// 2 <= n <= 105
// n - 1 <= connections.length <= 105
// 0 <= ai, bi <= n - 1
// ai != bi
// There are no repeated connections.
public class CriticalConnectionsInANetwork {
    int[] dis,low;
    boolean[]vis;
    int time=0, calls=0;
    public void dfs(int src, int par, List<Integer>[]graph,List<List<Integer>>ans){
        vis[src]=true;
        dis[src]=time;
        low[src]=time;
        time++;
        for(Integer vtx : graph[src]){
            if(!vis[vtx]){
                dfs(vtx,src,graph,ans);
                if(dis[src]<low[vtx]){
                    List<Integer> articulationEdge=new ArrayList<>();
                    articulationEdge.add(src);
                    articulationEdge.add(vtx);
                    ans.add(articulationEdge);
                }
                low[src]=Math.min(low[src],low[vtx]);
            }
            else if(vis[vtx] && vtx!=par){
                low[src] = Math.min(low[src], dis[vtx]);
            }
        }
        
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        vis=new boolean[n];
        dis=new int[n];
        low=new int[n];
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>[] graph=new ArrayList[n];
        System.out.println(connections);
        for(int i=0;i<n;i++)
            graph[i]=new ArrayList<>();
        for(List<Integer> e : connections){
            int i = e.get(0);
            int j = e.get(1);
            graph[i].add(j);
            graph[j].add(i);
        }
        
        dfs(0,0,graph,ans);
        return ans;
    }
}
