package ownPractice;
//*************56. Merge Intervals
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
// and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Example 1:
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

// Example 2:
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.

// Constraints:
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (val1, val2) -> Integer.compare(val1[0], val2[0]));
      ArrayList<int[]> list = new ArrayList<>();
      int lsp = intervals[0][0];
      int lep = intervals[0][1];

      for(int i = 1; i < intervals.length; i++) {
          int sp = intervals[i][0];
          int ep = intervals[i][1];

          if(sp > lep) {
              // new interval is here
              int[] subinterval = {lsp, lep};
              list.add(subinterval);
              lsp = sp;
              lep = ep;
          } else if(lep < ep) {
              // partial merging
              lep = ep;
          } else {
              // new interval is already covered in lsp and lep
          }
      }
      int[] subinterval = {lsp, lep};
      list.add(subinterval);
      return list.toArray(new int[list.size()][]);
  }
}
