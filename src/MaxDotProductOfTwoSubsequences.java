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
