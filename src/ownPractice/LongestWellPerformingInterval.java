package ownPractice;
//***********1124. Longest Well-Performing Interval
// We are given hours, a list of the number of hours worked per day for a given employee.
// A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.
// A well-performing interval is an interval of days for which the number of tiring days is strictly larger
// than the number of non-tiring days.
// Return the length of the longest well-performing interval.

// Example 1:
// Input: hours = [9,9,6,0,6,6,9]
// Output: 3
// Explanation: The longest well-performing interval is [9,9,6].

// Example 2:
// Input: hours = [6,6,6]
// Output: 0

// Constraints:
// 1 <= hours.length <= 104
// 0 <= hours[i] <= 16
public class LongestWellPerformingInterval {
     //the question is very similar to subarray sum equals to k.
     public int longestWPI(int[] hours) {
        int tiring = 0;
        int maxLen = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<hours.length;i++){
            int val = hours[i];
            if(val>8) tiring++;
            else tiring--;
            if(tiring>0) maxLen = i+1;
            else{
                if(map.containsKey(tiring-1)){
                    maxLen = Math.max(maxLen,i-map.get(tiring-1));
                }
            }
            map.putIfAbsent(tiring,i);
        }
        
        return maxLen;
    }
}
