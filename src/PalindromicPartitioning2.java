//*************132. Palindrome Partitioning II
// Given a string s, partition s such that every substring of the partition is a palindrome.
// Return the minimum cuts needed for a palindrome partitioning of s.

// Example 1:
// Input: s = "aab"
// Output: 1
// Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

// Example 2:
// Input: s = "a"
// Output: 0

// Example 3:
// Input: s = "ab"
// Output: 1

// Constraints:
// 1 <= s.length <= 2000
// s consists of lower-case English letters only.
public class PalindromicPartitioning2 {

  public int minCut_memo(
    String s,
    int si,
    boolean[][] isPlaindromeDp,
    int[] dp
  ) {
    if (isPlaindromeDp[si][s.length() - 1]) return dp[si] = 0;

    if (dp[si] != -1) return dp[si];

    int minAns = (int) 1e8;
    for (int cut = si; cut < s.length(); cut++) {
      if (isPlaindromeDp[si][cut]) minAns =
        Math.min(minAns, minCut_memo(s, cut + 1, isPlaindromeDp, dp) + 1);
    }

    return dp[si] = minAns;
  }

  public int minCut_DP(String s, int SI, boolean[][] isPlaindromeDp, int[] dp) {
    for (int si = dp.length - 1; si >= SI; si--) {
      if (isPlaindromeDp[si][s.length() - 1]) {
        dp[si] = 0;
        continue;
      }

      int minAns = (int) 1e8;
      for (int cut = si; cut < s.length(); cut++) {
        if (isPlaindromeDp[si][cut]) minAns = Math.min(minAns, dp[cut + 1] + 1);
      }

      dp[si] = minAns;
    }
    return dp[SI];
  }

  public int minCut(String s) {
    int n = s.length();
    boolean[][] isPlaindromeDp = new boolean[n][n];
    for (int gap = 0; gap < n; gap++) {
      for (int i = 0, j = gap; j < n; i++, j++) {
        if (gap == 0) isPlaindromeDp[i][j] = true; else if (
          gap == 1 && s.charAt(i) == s.charAt(j)
        ) isPlaindromeDp[i][j] = true; else isPlaindromeDp[i][j] =
          s.charAt(i) == s.charAt(j) && isPlaindromeDp[i + 1][j - 1];
      }
    }

    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    return minCut_memo(s, 0, isPlaindromeDp, dp);
  }
}
