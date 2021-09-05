//**************1025. Divisor Game
// Alice and Bob take turns playing a game, with Alice starting first.
// Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
// Choosing any x with 0 < x < n and n % x == 0.
// Replacing the number n on the chalkboard with n - x.
// Also, if a player cannot make a move, they lose the game.
// Return true if and only if Alice wins the game, assuming both players play optimally.

// Example 1:
// Input: n = 2
// Output: true
// Explanation: Alice chooses 1, and Bob has no more moves.

// Example 2:
// Input: n = 3
// Output: false
// Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.

// Constraints:
// 1 <= n <= 1000
public class DivisorGame {
    public boolean divisorGame(int n) {
        //         int[][]dp=new int[n+1][2];
        //         for(int[]d:dp)
        //             Arrays.fill(d,-1);
                
        //         return divisorGame(n,0,dp)==1?true:false;
                
                return (n%2==0);
                
            }
            
            public int divisorGame(int n,int state,int[][]dp){
                if(n==0){
                    return dp[n][state]=0;
                }
                
                if(dp[n][state]!=-1) return dp[n][state];
                int res=0;
                int nextState = state==1?0:1;
                boolean flag=false;
                for(int i=1;i<n;i++)
                    if(n%i==0)
                        flag = flag || divisorGame(n-i,nextState,dp)==0;
                
                return dp[n][state]= flag==true?1:0;
            }
}
