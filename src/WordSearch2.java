// 212. Word Search II
// Given an m x n board of characters and a list of strings words, return all words on the board.
// Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
// or vertically neighboring. The same letter cell may not be used more than once in a word.

// Example 1:
// Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
// Output: ["eat","oath"]

// Example 2:
// Input: board = [["a","b"],["c","d"]], words = ["abcb"]
// Output: []
 
// Constraints:
// m == board.length
// n == board[i].length
// 1 <= m, n <= 12
// board[i][j] is a lowercase English letter.
// 1 <= words.length <= 3 * 104
// 1 <= words[i].length <= 10
// words[i] consists of lowercase English letters.
// All the strings of words are unique.
public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        for(String word : words){
            if(exist(board,word)) ans.add(word);
        }
        
        return ans;
    }
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
