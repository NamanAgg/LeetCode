package ownPractice;
//**************871. Minimum Number of Refueling Stops
// A car travels from a starting position to a destination which is target miles east of the starting position.
// There are gas stations along the way. The gas stations are represented as an array stations
// where stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of the starting position
// and has fueli liters of gas.
// The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.
// It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel,
// transferring all the gas from the station into the car.
// Return the minimum number of refueling stops the car must make in order to reach its destination.
// If it cannot reach the destination, return -1.
// Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.
// If the car reaches the destination with 0 fuel left, it is still considered to have arrived.

// Example 1:
// Input: target = 1, startFuel = 1, stations = []
// Output: 0
// Explanation: We can reach the target without refueling.

// Example 2:
// Input: target = 100, startFuel = 1, stations = [[10,100]]
// Output: -1
// Explanation: We can not reach the target (or even the first gas station).

// Example 3:
// Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
// Output: 2
// Explanation: We start with 10 liters of fuel.
// We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
// Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
// and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
// We made 2 refueling stops along the way, so we return 2.

// Constraints:
// 1 <= target, startFuel <= 109
// 0 <= stations.length <= 500
// 0 <= positioni <= positioni+1 < target
// 1 <= fueli < 109

// Approach 2: Priority Queue, O(NlogN)
// i is the index of next stops to refuel.
// res is the times that we have refeuled.
// pq is a priority queue that we store all available gas.
// ​
// We initial res = 0 and in every loop:
// ​
// We add all reachable stop to priority queue.
// We pop out the largest gas from pq and refeul once.
// If we can't refuel, means that we can not go forward and return -1
// ​
// ​
// ​
// Approach 1: 1D DP, O(N^2)
// dp[t] means the furthest distance that we can get with t times of refueling.
// ​
// So for every station s[i],
// if the current distance dp[t] >= s[i][0], we can refuel:
// dp[t + 1] = max(dp[t + 1], dp[t] + s[i][1])
// ​
// In the end, we'll return the first t with dp[t] >= target,
// otherwise we'll return -1.
public class MinimumNumberOfRefuelingStops {
     //this question can be solved using dp but we will solve it using priority queue
    //Dp solution time complexity is n^2, priority queue solution tome complexity is nlogn.
    //this priority queue is a greedy solution.
//     Approach 2: Priority Queue, O(NlogN)
// i is the index of next stops to refuel.
// res is the times that we have refeuled.
// pq is a priority queue that we store all available gas.

// We initial res = 0 and in every loop:

// We add all reachable stop to priority queue.
// We pop out the largest gas from pq and refeul once.
// If we can't refuel, means that we can not go forward and return -1
public int minRefuelStops(int target, int startFuel, int[][] stations) {
    if(target<=startFuel) return 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
        return b-a;
    }); //max priority queue
    
    int currSum = startFuel;
    int stops = 0;
    int i=0;
    while(currSum<target){
        while(i<stations.length && stations[i][0]<=currSum){
            pq.add(stations[i][1]);//adding fuel of those station where we can go.
            i++;
        }
        if(pq.size()==0) return -1;
        currSum+=pq.remove();
        stops++;
    }
    return stops;
}
}
