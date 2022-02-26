//************847. Shortest Path Visiting All Nodes
// You have an undirected, connected graph of n nodes labeled from 0 to n - 1.
//You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.
// Return the length of the shortest path that visits every node. You may start and stop at any node,
//you may revisit nodes multiple times, and you may reuse edges.

// Example 1:
// Input: graph = [[1,2,3],[0],[0],[0]]
// Output: 4
// Explanation: One possible path is [1,0,2,0,3]

// Example 2:
// Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
// Output: 4
// Explanation: One possible path is [0,1,4,2,3]

// Constraints:
// n == graph.length
// 1 <= n <= 12
// 0 <= graph[i].length < n
// graph[i] does not contain i.
// If graph[a] contains b, then graph[b] contains a.
// The input graph is always connected.

// very interesting problem and very different problem of graph, you expect it will be using some algos and whatnot but 
// what we are just doing is using bfs but with a slight modification. i.e using bitmanipulation.
// The reason we are using but manipulation is to store the current state of out path as we can visit a node more than once time and thats why we gotta use
// a different kind of bfs bcz in traditional bfs we can't visit a node twice, moreover we have to make sure we don't run into infinite loop, thats why we are using 
// but manipulation, so for example we are at node 0, then our current state will be 0000..1(these 000..are upto n-1).
// Now when we move to node 1 from 0 our state at node 1 will be 00..11, now we can go back to 0 with a state 00..11 at node 0. now if we go back to 1,
// the state will be 00..11 at node 1, but we already had the same state at node 1. I repeat we alreadt visited with the same state AT NODE 1,
// we can go to lets suppose to 2 with this state but not to 1 bcz we have already been, and REMEMBER THE NODE AND THE STATE COMBINED TOGETHER WILL DETERMINE 
// WHETHER WE CAN GO TO THAT NODE OR NOT.
// so we have done that only but if you didn't get it please refer the video given below.
// https://www.youtube.com/watch?v=1XkMFNvkouo
public class ShortestPathVisitingAllNodes{
     public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int finalState = (1<<n) - 1;
        
        //{i, state}
        LinkedList<int[]> que = new LinkedList<>();
        boolean[][]vis = new boolean[n][finalState+1];
        
        for(int i = 0;i<n;i++){
            int state = 1<<i;
            que.addLast(new int[]{i, state});
            vis[i][state] = true;
        }
        
        int level = 0;
        while(que.size()!=0){
            int size = que.size();
         
            while(size-- > 0){
                int[]rm  =que.removeFirst();
                int vtx = rm[0];
                int rmState = rm[1];
                if(rmState == finalState) return level;
                for(Integer e : graph[vtx]){
                    int bitmask = 1<<e;
                    int nextState = bitmask | rmState;
                    if(!vis[e][nextState]){
                        que.addLast(new int[]{e, nextState});
                        vis[e][nextState] = true;
                    }
                }
            }
            level++;
        }
        return level;
    }
