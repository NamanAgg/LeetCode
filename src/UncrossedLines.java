//****************1035. Uncrossed Lines
// We write the integers of nums1 and nums2 (in the order they are given) on two separate horizontal lines.
// Now, we may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:
// nums1[i] == nums2[j];
// The line we draw does not intersect any other connecting (non-horizontal) line.
// Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
// Return the maximum number of connecting lines we can draw in this way.

// Example 1:
// Input: nums1 = [1,4,2], nums2 = [1,2,4]
// Output: 2
// Explanation: We can draw 2 uncrossed lines as in the diagram.
// We cannot draw 3 uncrossed lines, because the line from nums1[1]=4 to nums2[2]=4 will intersect the line from nums1[2]=2 to nums2[1]=2.

// Example 2:
// Input: nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
// Output: 3

// Example 3:
// Input: nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
// Output: 2
 
// Note:
// 1 <= nums1.length <= 500
// 1 <= nums2.length <= 500
// 1 <= nums1[i], nums2[i] <= 2000
public class UncrossedLines{
    public int maxUncrossedLines(int[] A, int[] B, int N, int M, int[][] dp) {

        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {

                if (n == 0 || m == 0) {
                    dp[n][m] = 0;
                    continue;
                }

                if (A[n - 1] == B[m - 1])
                    dp[n][m] = dp[n - 1][m - 1] + 1;
                else
                    dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);
            }
        }

        return dp[N][M];

    }

    public int maxUncrossedLines(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];

        return maxUncrossedLines(A, B, n, m, dp);
    }
}