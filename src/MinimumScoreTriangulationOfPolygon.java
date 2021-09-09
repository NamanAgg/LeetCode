//************1039. Minimum Score Triangulation of Polygon

//************* DP QUESTION BASED ON CUT SET STRATEGY AND YOU CAN SEE IT IN DP12LevelUp video   ************************

// You have a convex n-sided polygon where each vertex has an integer value.
// You are given an integer array values where values[i] is the value of the ith vertex (i.e., clockwise order).
// You will triangulate the polygon into n - 2 triangles. For each triangle,
// the value of that triangle is the product of the values of its vertices,
// and the total score of the triangulation is the sum of these values over all n - 2 triangles in the triangulation.
// Return the smallest possible total score that you can achieve with some triangulation of the polygon.

// Example 1:
// Input: values = [1,2,3]
// Output: 6
// Explanation: The polygon is already triangulated, and the score of the only triangle is 6.

// Example 2:
// Input: values = [3,7,4,5]
// Output: 144
// Explanation: There are two triangulations, with possible scores: 3*7*5 + 4*5*7 = 245, or 3*4*5 + 3*4*7 = 144.
// The minimum score is 144.

// Example 3:
// Input: values = [1,3,1,4,1,5]
// Output: 13
// Explanation: The minimum score triangulation has score 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13.

// Constraints:
// n == values.length
// 3 <= n <= 50
// 1 <= values[i] <= 100
public class MinimumScoreTriangulationOfPolygon {
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        int[][]dp=new int[n][n];
        for(int[]d: dp)
            Arrays.fill(d,-1);
        
        return minScoreTriangulation(values,0,n-1,dp);
        
        
    }
    
    public int minScoreTriangulation(int[]values,int si,int ei,int[][]dp){
        if(ei-si<=1)
            return dp[si][ei]=0;
        
        if(dp[si][ei]!=-1) return dp[si][ei];
        
        int finalRes = (int)1e9;
        for(int cut =si+1;cut<ei;cut++){
            int leftRes = minScoreTriangulation(values,si,cut,dp);
            int rightRes = minScoreTriangulation(values,cut,ei,dp);
            
            int myRes = leftRes + values[si]*values[cut]*values[ei] + rightRes;
            
            finalRes = Math.min(finalRes,myRes);
        }
        
        return dp[si][ei] = finalRes;
    }
}
