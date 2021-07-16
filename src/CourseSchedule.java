//**********************207. Course Schedule
// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
//You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

// Example 1:
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.

// Example 2:
// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 
// Constraints:
// 1 <= numCourses <= 105
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// All the pairs prerequisites[i] are unique.
public class CourseSchedule{
     public boolean canFinish(int numCourses, int[][] prerequisites) {
     ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();
        for (int[] a : prerequisites) {
            graph[a[0]].add(a[1]);
        }
       int[]indegree=new int[numCourses];
       LinkedList<Integer> que=new LinkedList<>();
       LinkedList<Integer> ans=new LinkedList<>();

        // O(E)
        for (int i = 0; i < numCourses; i++) {
            for (Integer v : graph[i]) {
                indegree[v]++;
            }
        }

        // O(V)
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                que.addLast(i);

        // O(E + V)
        while (que.size() != 0) {
            int rvtx = que.removeFirst();
            ans.add(rvtx);

            for (Integer v : graph[rvtx]) {
                if (--indegree[v] == 0)
                    que.addLast(v);
            }
        }

        if (ans.size() != numCourses)
            return false;

        return true;
    }
}
