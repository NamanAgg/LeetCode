//***************** 11. Container With Most Water
// Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
// n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
// Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
// Notice that you may not slant the container.

// Example 1:
// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

// Example 2:
// Input: height = [1,1]
// Output: 1

// Example 3:
// Input: height = [4,3,2,1,4]
// Output: 16

// Example 4:
// Input: height = [1,2,1]
// Output: 2

// Constraints:
// n == height.length
// 2 <= n <= 105
// 0 <= height[i] <= 104
public class ContainerWithMostWater {
    //Basically a greedy approach solution.
 
    public int maxArea(int[] height) {
     int n=height.length;
     int i=0;
     int j =n-1;
     int ans=0;
     while(i<j){
         int h = Math.min(height[i],height[j]); //height
         int l = j-i; //length
         int currWaterVol = h*l*1; // 1 signifies breadth
         ans = Math.max(ans,currWaterVol);
         
         if(height[i]<height[j])
             i++;                 //moved i bcz we might get a height of an element that may give more volume                                        // than curr volume keeping j as same.
         else 
             j--;                 //moved j bcz we might get a height of an element that may give more volume                                        // than curr volume keeping i as same.
     }
     return ans;
 }
}
