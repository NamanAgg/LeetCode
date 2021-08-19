//************583. Delete Operation for Two Strings
// Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
// In one step, you can delete exactly one character in either string.

// Example 1:
// Input: word1 = "sea", word2 = "eat"
// Output: 2
// Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

// Example 2:
// Input: word1 = "leetcode", word2 = "etco"
// Output: 4

// Constraints:
// 1 <= word1.length, word2.length <= 500
// word1 and word2 consist of only lowercase English letters.
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int n=word1.length(),m=word2.length();
        int[][]dp=new int[n+1][m+1];
        for(int[]d:dp)
            Arrays.fill(d,-1);
        //return minDist(word1,word2,n,m,dp);
          return n + m - 2 * lcss_DP(word1,n,word2,m,dp);
    }
    
    public int minDist(String word1,String word2,int n,int m,int[][]dp){
        if(n==0||m==0){
            return dp[n][m] = (n == 0 ? m : n);
        }
        if(dp[n][m]!=-1) return dp[n][m];
        
        if(word1.charAt(n-1)==word2.charAt(m-1))
            return dp[n][m]=minDist(word1,word2,n-1,m-1,dp);
        
        return dp[n][m]=Math.min(minDist(word1,word2,n-1,m,dp),minDist(word1,word2,n,m-1,dp))+1;
    }
    
     public int lcss_DP(String str1, int N, String str2, int M, int[][] dp) {
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                if (n == 0 || m == 0) {
                    dp[n][m] = 0;
                    continue;
                }

                if (str1.charAt(n - 1) == str2.charAt(m - 1))
                    dp[n][m] = dp[n - 1][m - 1] + 1;
                else
                    dp[n][m] = Math.max(dp[n][m - 1], dp[n - 1][m]);
            }
        }

        return dp[N][M];
    }
    
}
