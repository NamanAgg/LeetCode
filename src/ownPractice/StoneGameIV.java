package ownPractice;
//***********1510. Stone Game IV
// Alice and Bob take turns playing a game, with Alice starting first.
// Initially, there are n stones in a pile. On each player's turn,
// that player makes a move consisting of removing any non-zero square number of stones in the pile.
// Also, if a player cannot make a move, he/she loses the game.
// Given a positive integer n, return true if and only if Alice wins the game otherwise return false,
// assuming both players play optimally.

// Example 1:
// Input: n = 1
// Output: true
// Explanation: Alice can remove 1 stone winning the game because Bob doesn't have any moves.

// Example 2:
// Input: n = 2
// Output: false
// Explanation: Alice can only remove 1 stone, after that Bob removes the last one winning the game (2 -> 1 -> 0).

// Example 3:
// Input: n = 4
// Output: true
// Explanation: n is already a perfect square, Alice can win with one move, removing 4 stones (4 -> 0).

// Constraints:
// 1 <= n <= 105

// Solution link
// https://leetcode.com/problems/stone-game-iv/discuss/1708369/Easy-Explanation-you-will-definitely-gonna-understand
public class StoneGameIV {
//     https://leetcode.com/problems/stone-game-iv/discuss/1708369/Easy-Explanation-you-will-definitely-gonna-understand
    public boolean winnerSquareGame(int n) {
        int[][]dp = new int[n+1][2];
        for(int[]d : dp)
            Arrays.fill(d, -1);
        int res = winnerSquareGame(n,0,dp);
        return res==1?true:false;
    }
    
    public int winnerSquareGame(int n, int turn, int[][]dp){
        if(n==0)
            return dp[n][turn] = turn;
        
        
        if(dp[n][turn]!=-1) 
            return dp[n][turn];
        int myRes = 0;
        int nxtTurn = 1;
        if(turn==1) nxtTurn = 0;
        
        boolean isZero = false;
        for(int i=1;(i*i)<=n;i++){
            int val = winnerSquareGame(n-i*i, nxtTurn, dp);
            if(val==0 && turn==1){
                isZero = true;
                break;
            }
            else if(val==1) myRes = 1;
        }
        
        if(myRes==0 || isZero) return dp[n][turn] = 0;
        return dp[n][turn] = myRes;
    }
}
