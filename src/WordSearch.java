//**************79. Word Search
// Given an m x n grid of characters board and a string word, return true if word exists in the grid.
// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells
// are horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Example 1:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true

// Example 2:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true

// Example 3:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false

// Constraints:
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase and uppercase English letters.

// Follow up: Could you use search pruning to make your solution faster with a larger board?
public class WordSearch {
    int[][]dirs= new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public boolean exist(char[][] board, String word) {
        char ch = word.charAt(0);
        boolean res = false;
        
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(ch==board[i][j]) 
                    res = res||exist(board,i,j,word,1);
        
        return res;
    }
    
    public boolean exist(char[][]board,int i,int j, String word,int idx){
        // System.out.println(form+" : "+i+" : "+j);
        if(idx==word.length()) return true;
        
        char ch = board[i][j]; 
        board[i][j]='@';
        boolean res = false;
        for(int d=0;d<dirs.length;d++){
            int r = i+dirs[d][0];
            int c = j+dirs[d][1];
            if(r>=0 && c>=0 && r<board.length && c<board[0].length && board[r][c]!='@' && board[r][c]==word.charAt(idx))
                res=res||exist(board,r,c,word,idx+1);    
        }
        
        board[i][j]=ch;
        return res;
    }    
}