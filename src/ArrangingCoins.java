//*************441. Arranging Coins
// You have n coins and you want to build a staircase with these coins.
// The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
// Given the integer n, return the number of complete rows of the staircase you will build.

// Example 1:
// Input: n = 5
// Output: 2
// Explanation: Because the 3rd row is incomplete, we return 2.

// Example 2:
// Input: n = 8
// Output: 3
// Explanation: Because the 4th row is incomplete, we return 3.

// Constraints:
// 1 <= n <= 231 - 1
public class ArrangingCoins {
    //used quadratic equations and discriminant used k(k+1) <=2*n and foud k here.
    public int arrangeCoins(int n) {
        return ((int) Math.sqrt(8*((long) n)+1)-1)/2;
     }
}
