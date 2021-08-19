//*********1458. Max Dot Product of Two Subsequences
// Given two arrays nums1 and nums2.
// Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.
// A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters
// without disturbing the relative positions of the remaining characters.
// (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).

// Example 1:
// Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
// Output: 18
// Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
// Their dot product is (2*3 + (-2)*(-6)) = 18.

// Example 2:
// Input: nums1 = [3,-2], nums2 = [2,-6,7]
// Output: 21
// Explanation: Take subsequence [3] from nums1 and subsequence [7] from nums2.
// Their dot product is (3*7) = 21.

// Example 3:
// Input: nums1 = [-1,-1], nums2 = [1,1]
// Output: -1
// Explanation: Take subsequence [-1] from nums1 and subsequence [1] from nums2.
// Their dot product is -1.

// Constraints:
// 1 <= nums1.length, nums2.length <= 500
// -1000 <= nums1[i], nums2[i] <= 1000
public class MaxDotProductOfTwoSubsequences {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n=nums1.length,m=nums2.length;
        int[][]dp=new int[n+1][m+1];
        for (int[] d : dp)
            Arrays.fill(d, -(int)1e9);
        
        // int ans= maxDotProd(nums1,n,nums2,m,dp);
        // print(dp);
        // return ans;
        return maxDotProd_DP(nums1,n,nums2,m,dp);
    }
    
    public int maxDotProd(int[]nums,int n,int[]nums2,int m,int[][]dp){
        if(n==0||m==0) return dp[n][m]=-(int)1e8;
        
        if(dp[n][m]!=-(int)1e9) return dp[n][m];
        
        int res1=Math.max(maxDotProd(nums,n-1,nums2,m-1,dp),0)+nums[n-1]*nums2[m-1];
        int res2=Math.max(maxDotProd(nums,n-1,nums2,m,dp),maxDotProd(nums,n,nums2,m-1,dp));
        return dp[n][m]=Math.max(res1,res2);
    }
    
     public int maxDotProd_DP(int[] nums, int N, int[] nums2, int M, int[][] dp) {
    for (int n = 0; n <= N; n++) {
      for (int m = 0; m <= M; m++) {
        if (n == 0 || m == 0) {
          dp[n][m] = -(int) 1e8;
          continue;
        }

        int res1 = Math.max(dp[n - 1][m - 1], 0) + nums[n - 1] * nums2[m - 1];
        int res2 = Math.max(dp[n - 1][m], dp[n][m - 1]);
        dp[n][m] = Math.max(res1, res2);
      }
    }
    return dp[N][M];
  }
    
    public void print(int[][]dp){
        for(int[]d: dp){
            for(int e: d){
                if(e==-(int)1e8)
                    System.out.print("min ");
                else
                    System.out.print(e+" ");
            }
            System.out.println();
        }
        
    }
}
