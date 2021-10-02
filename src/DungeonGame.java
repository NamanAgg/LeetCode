//*************174. Dungeon Game
// The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon.
// The dungeon consists of m x n rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left
// room and must fight his way through dungeon to rescue the princess.
// The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below,
// he dies immediately.
// Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms;
// other rooms are either empty (represented as 0) or contain magic orbs that increase
// the knight's health (represented by positive integers).
// To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
// Return the knight's minimum initial health so that he can rescue the princess.
// Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room
// where the princess is imprisoned.

// Example 1:
// Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
// Output: 7
// Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.

// Example 2:
// Input: dungeon = [[0]]
// Output: 1

// Constraints:
// m == dungeon.length
// n == dungeon[i].length
// 1 <= m, n <= 200
// -1000 <= dungeon[i][j] <= 1000
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][]dp = new int[dungeon.length][dungeon[0].length];
        for(int[]d: dp)
            Arrays.fill(d,-1);
        
        return (dfs(dungeon,0,0,dp)<0) ? (Math.abs(dp[0][0])+1) : 1;
    }
    
    public int dfs(int[][]dungeon,int r,int c,int[][]dp){
        if(r==dungeon.length-1 && c==dungeon[0].length-1)
            return dp[r][c]=(dungeon[r][c]<0)?dungeon[r][c]:0;
        
        if(dp[r][c]!=-1) return dp[r][c];
       
        int[][]dirs = {{1,0},{0,1}};
        int myAns = Integer.MIN_VALUE;
        
        for(int d=0;d<dirs.length;d++){
            int x= dirs[d][0]+r;
            int y= dirs[d][1]+c;
            if(x>=0 && y>=0 && x<dungeon.length && y<dungeon[0].length){
                int gotRes=dfs(dungeon,x,y,dp);
                myAns = Math.max(gotRes,myAns);
            }
        }
        
        myAns+=dungeon[r][c];
        return dp[r][c]=((myAns<0)?(myAns):0);   
    }
}
