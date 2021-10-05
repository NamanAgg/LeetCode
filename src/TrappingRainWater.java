//*****************42. Trapping Rain Water
// Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it can trap after raining.

// Example 1:
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
// In this case, 6 units of rain water (blue section) are being trapped.

// Example 2:
// Input: height = [4,2,0,3,2,5]
// Output: 9

// Constraints:
// n == height.length
// 1 <= n <= 2 * 104
// 0 <= height[i] <= 105
public class TrappingRainWater {
    public int trap(int[] height) {
        int flow = 0;
       int water = 0;
       int max = height[0];
       int maxIndx = 0;

       for(int i = 1; i < height.length; i++) {
           int ht = height[i];
           if(max <= ht) {
               water += flow;
               flow = 0;
               max = ht;
               maxIndx = i;
           } else {
               flow += (max - ht);
           }
       }

       // solve the overflow of flow value
       flow = 0;
       max = height[height.length - 1];
       for(int i = height.length - 2; i >= maxIndx; i--) {
           int ht = height[i];
           if(max <= ht) {
               water += flow;
               flow = 0;
               max = ht;
           } else {
               flow += (max - ht);
           }
       }
       return water;
   }
}
