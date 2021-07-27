//**************685. Redundant Connection II
// In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes
// are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.
// The given input is a directed graph that started as a rooted tree with n nodes (with distinct values from 1 to n),
// with one additional directed edge added. The added edge has two different vertices chosen from 1 to n,
// and was not an edge that already existed.
// The resulting graph is given as a 2D-array of edges.
// Each element of edges is a pair [ui, vi] that represents a directed edge connecting nodes ui and vi, where ui is a parent of child vi.
// Return an edge that can be removed so that the resulting graph is a rooted tree of n nodes.
// If there are multiple answers, return the answer that occurs last in the given 2D-array.

// Example 1:
// Input: edges = [[1,2],[1,3],[2,3]]
// Output: [2,3]

// Example 2:
// Input: edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
// Output: [4,1]
 
// Constraints:
// n == edges.length
// 3 <= n <= 1000
// edges[i].length == 2
// 1 <= ui, vi <= n
// ui != vi
public class RedundantConnections2{
    int[]par , in;
    
    public int findPar(int u){
        return par[u]==u?u:(par[u]=findPar(par[u]));
    }
    
    //to check whether the cycle exist if we dont include []edge in graph
    public boolean union(int[][]edges,int[]edge){
        int n=edges.length;      
        par=new int[n+1];
        for(int i=0;i<=n;i++) par[i]=i;
        for(int[]e:edges){
            if(e==edge) continue;
            int u=e[0], v=e[1];
            int p1=findPar(u);
            int p2=findPar(v);
            if(p1!=p2)
                par[p2]=p1;
            else 
                return false;
        }
        return true;
    }
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n=edges.length;
        par=new int[n+1];
        in=new int[n+1];
        int hasTwoPar=-1;
        int[]ans=new int[2];
        for(int i=0;i<=n;i++) par[i]=i;
        
        //this loop do three things:
        //=>it makes the whole graph acc to ques except the edge(s) that make a cycle
        //=>store that edge that make cycle
        //=>also store finds the indegree of every vtx and store the vtx whose indegree is
        //  more than 1.
        for(int[]e:edges){
            int u=e[0], v=e[1];
            int p1=findPar(u);
            int p2=findPar(v);
            if(p1!=p2){
                par[v]=u;
                in[v]++;
                if(in[v]>1)
                    hasTwoPar=v;
            }
            else
                ans=e;
        }
        //now if any vtx has indegree more than 1, we will see whether if we dont include
        //that edge where v= that vtx whose indegree is more than 1, will there be a cycle
        //present ? and if we got no cycle present then ans= that excluded edge.
        if(hasTwoPar!=-1){
            for(int[]e:edges){
                int u=e[0], v=e[1];
                if(v==hasTwoPar)
                    if(union(edges,e))
                        ans = e;
            }
        }
        return ans;
    }
}