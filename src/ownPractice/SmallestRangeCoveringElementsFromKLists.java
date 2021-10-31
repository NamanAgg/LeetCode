package ownPractice;
//************632. Smallest Range Covering Elements from K Lists
// You have k lists of sorted integers in non-decreasing order.
// Find the smallest range that includes at least one number from each of the k lists.
// We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.

// Example 1:
// Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
// Output: [20,24]
// Explanation: 
// List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
// List 2: [0, 9, 12, 20], 20 is in range [20,24].
// List 3: [5, 18, 22, 30], 22 is in range [20,24].

// Example 2:
// Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
// Output: [1,1]

// Example 3:
// Input: nums = [[10,10],[11,11]]
// Output: [10,11]

// Example 4:
// Input: nums = [[10],[11]]
// Output: [10,11]

// Example 5:
// Input: nums = [[1],[2],[3],[4],[5],[6],[7]]
// Output: [1,7]

// Constraints:
// nums.length == k
// 1 <= k <= 3500
// 1 <= nums[i].length <= 50
// -105 <= nums[i][j] <= 105
// nums[i] is sorted in non-decreasing order.
public class SmallestRangeCoveringElementsFromKLists {
    public class pair implements Comparable<pair>{
        int data;
        int idx;
        int col;
        pair(int data,int col,int idx){
            this.data = data;
            this.idx = idx;
            this.col = col;
        }
        
        public int compareTo(pair o){
            return this.data - o.data;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<pair> que = new PriorityQueue<>();
        int[]ans = new int[2];
        int finalRange = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.size();i++){
            int val = nums.get(i).get(0);
            max = Math.max(max,val);
            que.add(new pair(val,i,0));
        }
        
        while(que.size()==nums.size()){
            pair rm = que.remove();
            int range = max - rm.data;
            if(finalRange>range){
                finalRange = range;
                ans[0] = rm.data;
                ans[1] = max;
            }
            if(rm.idx!=nums.get(rm.col).size()-1){
                int val = nums.get(rm.col).get(rm.idx+1);
                max = Math.max(max,val);
                que.add(new pair(val,rm.col,rm.idx+1));
            }
        }
        return ans;
    }
}
