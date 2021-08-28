//**************10. Regular Expression Matching
// Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
// '.' Matches any single character.​​​​
// '*' Matches zero or more of the preceding element.
// The matching should cover the entire input string (not partial).

// Example 1:
// Input: s = "aa", p = "a"
// Output: false
// Explanation: "a" does not match the entire string "aa".

// Example 2:
// Input: s = "aa", p = "a*"
// Output: true
// Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

// Example 3:
// Input: s = "ab", p = ".*"
// Output: true
// Explanation: ".*" means "zero or more (*) of any character (.)".

// Example 4:
// Input: s = "aab", p = "c*a*b"
// Output: true
// Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".

// Example 5:
// Input: s = "mississippi", p = "mis*is*p*."
// Output: false

// Constraints:
// 1 <= s.length <= 20
// 1 <= p.length <= 30
// s contains only lowercase English letters.
// p contains only lowercase English letters, '.', and '*'.
// It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
public class RegularExpressionMatching {

  public String removeStars(String str) {
    if (str.length() == 0) return "";

    StringBuilder sb = new StringBuilder();
    sb.append(str.charAt(0));

    int i = 1;
    while (i < str.length()) {
      while (
        i < str.length() &&
        sb.charAt(sb.length() - 1) == '*' &&
        str.charAt(i) == '*'
      ) i++;

      if (i < str.length()) sb.append(str.charAt(i));
      i++;
    }

    return sb.toString();
  }

  public int isMatch(String s, String p, int n, int m, int[][] dp) {
    if (n == 0 && m == 0) return dp[n][m] = 1;
    if (m == 0) return dp[n][m] = 0;

    if (dp[n][m] != -1) return dp[n][m];

    char ch1 = n > 0 ? s.charAt(n - 1) : '$';
    char ch2 = p.charAt(m - 1);

    if (ch1 != '$' && (ch1 == ch2 || ch2 == '.')) return (
      dp[n][m] = isMatch(s, p, n - 1, m - 1, dp)
    ); else if (ch2 == '*') {
      boolean res = false;
      if (
        m > 1 &&
        n > 0 &&
        (p.charAt(m - 2) == '.' || p.charAt(m - 2) == s.charAt(n - 1))
      ) res = res || isMatch(s, p, n - 1, m, dp) == 1;
      res = res || isMatch(s, p, n, m - 2, dp) == 1;

      return dp[n][m] = res ? 1 : 0;
    } else return dp[n][m] = 0;
  }

  public int isMatch_DP(String s, String p, int N, int M, int[][] dp) {
    for (int n = 0; n <= N; n++) for (int m = 0; m <= M; m++) {
      if (n == 0 && m == 0) {
        dp[n][m] = 1;
        continue;
      }
      if (m == 0) {
        dp[n][m] = 0;
        continue;
      }

      char ch1 = n > 0 ? s.charAt(n - 1) : '$';
      char ch2 = p.charAt(m - 1);

      if (ch1 != '$' && (ch1 == ch2 || ch2 == '.')) dp[n][m] =
        dp[n - 1][m - 1]; else if (ch2 == '*') {
        boolean res = false;
        if (
          m > 1 &&
          n > 0 &&
          (p.charAt(m - 2) == '.' || p.charAt(m - 2) == s.charAt(n - 1))
        ) res = res || dp[n - 1][m] == 1;
        res = res || dp[n][m - 2] == 1;

        dp[n][m] = res ? 1 : 0;
      } else dp[n][m] = 0;
    }
    return dp[N][M];
  }

  public boolean isMatch(String s, String p) {
    p = removeStars(p);
    int n = s.length(), m = p.length();

    int[][] dp = new int[n + 1][m + 1];
    for (int[] d : dp) Arrays.fill(d, -1);

    return isMatch(s, p, n, m, dp) == 1;
  }
}
