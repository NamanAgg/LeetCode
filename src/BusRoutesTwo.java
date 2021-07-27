//*****************815. Bus Routes
// You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.

// For example, if routes[0] = [1, 5, 7],
// this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
// You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target.
// You can travel between bus stops by buses only.
// Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.

// Example 1:
// Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
// Output: 2
// Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.

// Example 2:
// Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
// Output: -1
 
// Constraints:
// 1 <= routes.length <= 500.
// 1 <= routes[i].length <= 105
// All the values of routes[i] are unique.
// sum(routes[i].length) <= 105
// 0 <= routes[i][j] < 106
// 0 <= source, target < 106
public class BusRoutesTwo{
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target) return 0;
        int N = routes.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); // busStand to bus mapping
        for (int bus = 0; bus < routes.length; bus++) {
            for (int busStand : routes[bus]) {
                map.putIfAbsent(busStand, new ArrayList<>());
                map.get(busStand).add(bus);
            }
        }

        HashSet<Integer> busStandVisted = new HashSet<>();
        boolean[] busVisited = new boolean[N];
        int interchange = 0;

        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(source);
        busStandVisted.add(source);

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int busStand = que.removeFirst();
                for (int bus : map.get(busStand)) {

                    if (busVisited[bus])
                        continue;

                    for (int upcomingBusStand : routes[bus]) {
                        if (!busStandVisted.contains(upcomingBusStand)) {
                            busStandVisted.add(upcomingBusStand);
                            que.addLast(upcomingBusStand);
                            if (upcomingBusStand == target) {
                                return interchange + 1;
                            }
                        }
                    }

                    busVisited[bus] = true;
                }
            }
            interchange++;
        }

        return -1;
    }
}