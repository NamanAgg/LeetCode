//******************1143. Longest Common Subsequence
// Given two strings text1 and text2, return the length of their longest common subsequence.
// If there is no common subsequence, return 0.
// A subsequence of a string is a new string generated from the original string with some characters
// (can be none) deleted without changing the relative order of the remaining characters.
// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.

// Example 1:
// Input: text1 = "abcde", text2 = "ace" 
// Output: 3  
// Explanation: The longest common subsequence is "ace" and its length is 3.

// Example 2:
// Input: text1 = "abc", text2 = "abc"
// Output: 3
// Explanation: The longest common subsequence is "abc" and its length is 3.

// Example 3:
// Input: text1 = "abc", text2 = "def"
// Output: 0
// Explanation: There is no such common subsequence, so the result is 0.
 
// Constraints:
// 1 <= text1.length, text2.length <= 1000
// text1 and text2 consist of only lowercase English characters.
public class LongestCommonSubsequence{
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
 
         int[][] dp = new int[n + 1][m + 1];
         for (int[] d : dp)
             Arrays.fill(d, -1);  
         //return LCSS(text1,text2,n,m,dp);
         return LCSS_DP(text1,text2,n,m,dp);
     }
     
     public int LCSS(String s1, String s2, int n, int m, int[][] dp) {
         if (n == 0 || m == 0) {
             return dp[n][m] = 0;
         }
         if (dp[n][m] != -1)
             return dp[n][m];
         if (s1.charAt(n - 1) == s2.charAt(m - 1))
             return dp[n][m] = LCSS(s1, s2, n - 1, m - 1, dp) + 1;
         else
             return dp[n][m] = Math.max(LCSS(s1, s2, n - 1, m, dp), LCSS(s1, s2, n, m - 1, dp));
     }
     
       public int LCSS_DP(String s1, String s2, int N, int M, int[][] dp) {
 
         for (int n = 0; n <= N; n++) {
             for (int m = 0; m <= M; m++) {
 
                 if (n == 0 || m == 0) {
                     dp[n][m] = 0;
                     continue;
                 }
 
                 if (s1.charAt(n - 1) == s2.charAt(m - 1))
                     dp[n][m] = dp[n - 1][m - 1] + 1;
                 else
                     dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);
             }
         }
 
         return dp[N][M];
     }
}