//*************516. Longest Palindromic Subsequence
// Given a string s, find the longest palindromic subsequence's length in s.
// A subsequence is a sequence that can be derived from another sequence by deleting
// some or no elements without changing the order of the remaining elements.

// Example 1:
// Input: s = "bbbab"
// Output: 4
// Explanation: One possible longest palindromic subsequence is "bbbb".

// Example 2:
// Input: s = "cbbd"
// Output: 2
// Explanation: One possible longest palindromic subsequence is "bb".

// Constraints:
// 1 <= s.length <= 1000
// s consists only of lowercase English letters.
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][]dp=new int[n][n];
        return lpss_dp(s,0,n-1,dp);
    }
    public static int lpss(String str, int i, int j, int[][] dp) {
        if (i >= j) {
            return dp[i][j] = (i == j) ? 1 : 0;
        }

        if (dp[i][j] != 0)
            return dp[i][j];

        if (str.charAt(i) == str.charAt(j))
            return dp[i][j] = lpss(str, i + 1, j - 1, dp) + 2;
        else
            return dp[i][j] = Math.max(lpss(str, i + 1, j, dp), lpss(str, i, j - 1, dp));
    }
    
    public int lpss_dp(String s, int SI, int EI, int[][]dp){
        int n=s.length();
        for(int gap=0;gap<n;gap++){
            for(int si=0,ei=gap;ei<n;si++,ei++){
                if(si>=ei){
                    dp[si][ei]=(si==ei)?1:0;
                    continue;
                }
                if(s.charAt(si)!=s.charAt(ei))
                    dp[si][ei]=Math.max(dp[si+1][ei],dp[si][ei-1]);
                else
                    dp[si][ei]=dp[si+1][ei-1]+2;
            }
        }
        return dp[SI][EI];
    }
}
