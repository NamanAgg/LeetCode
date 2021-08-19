//**************115. Distinct Subsequences
// Given two strings s and t, return the number of distinct subsequences of s which equals t.
// A string's subsequence is a new string formed from the original string by deleting some (can be none)
// of the characters without disturbing the remaining characters' relative positions.
// (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
// It is guaranteed the answer fits on a 32-bit signed integer.

// Example 1:
// Input: s = "rabbbit", t = "rabbit"
// Output: 3
// Explanation:
// As shown below, there are 3 ways you can generate "rabbit" from S.
// rabbbit
// rabbbit
// rabbbit

// Example 2:
// Input: s = "babgbag", t = "bag"
// Output: 5
// Explanation:
// As shown below, there are 5 ways you can generate "bag" from S.
// babgbag
// babgbag
// babgbag
// babgbag
// babgbag

// Constraints:
// 1 <= s.length, t.length <= 1000
// s and t consist of English letters.
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int n=s.length(),m=t.length();
        int[][]dp=new int[n+1][m+1];
        for(int[]d:dp)
            Arrays.fill(d,-1);
        //return numDistinct_memo(s,n,t,m,dp);
        return numDistinct_DP(s,n,t,m,dp);
    }
    
      public int numDistinct_DP(String s, int N, String t, int M, int[][] dp) {
    for (int n = 0; n <= N; n++) for (int m = 0; m <= M; m++) {
      if (n == 0 || m == 0) {
        dp[n][m] = (m == 0) ? 1 : 0;
        continue;
      }
      int inclusiveCall = 0, exclusiveCall = 0;
      if (s.charAt(n - 1) == t.charAt(m - 1)) exclusiveCall = dp[n - 1][m - 1];

      inclusiveCall = dp[n - 1][m];
      dp[n][m] = inclusiveCall + exclusiveCall;
    }
    return dp[N][M];
  }
    
    public int numDistinct_memo(String s,int n,String t,int m,int[][]dp){
        if(n==0||m==0){
            return dp[n][m]=(m==0)?1:0;
        }
        
        if(dp[n][m]!=-1) return dp[n][m];
        
        int inclusiveCall=0,exclusiveCall=0;
        if(s.charAt(n-1)==t.charAt(m-1)){
            exclusiveCall=numDistinct_memo(s,n-1,t,m-1,dp);
        }
        inclusiveCall=numDistinct_memo(s,n-1,t,m,dp);
        
        return dp[n][m]=inclusiveCall+exclusiveCall;
    }
}
