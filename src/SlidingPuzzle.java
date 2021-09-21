//*********************773. Sliding Puzzle
// On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0.
// A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
// The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
// Given the puzzle board board, return the least number of moves required so that the state of the board is solved.
// If it is impossible for the state of the board to be solved, return -1.

// Example 1:
// Input: board = [[1,2,3],[4,0,5]]
// Output: 1
// Explanation: Swap the 0 and the 5 in one move.

// Example 2:
// Input: board = [[1,2,3],[5,4,0]]
// Output: -1
// Explanation: No number of moves will make the board solved.

// Example 3:
// Input: board = [[4,1,2],[5,0,3]]
// Output: 5
// Explanation: 5 is the smallest number of moves that solves the board.
// An example path:
// After move 0: [[4,1,2],[5,0,3]]
// After move 1: [[4,1,2],[0,5,3]]
// After move 2: [[0,1,2],[4,5,3]]
// After move 3: [[1,0,2],[4,5,3]]
// After move 4: [[1,2,0],[4,5,3]]
// After move 5: [[1,2,3],[4,5,0]]

// Example 4:
// Input: board = [[3,2,4],[1,5,0]]
// Output: 14

// Constraints:
// board.length == 2
// board[i].length == 3
// 0 <= board[i][j] <= 5
// Each value board[i][j] is unique.
public class SlidingPuzzle {
        //gotta apply bfs because we need to find the least number of moves
    //though we can do it with the dfs but here bfs will be better
    
    public int slidingPuzzle(int[][] board) {
        int dirs[][] = {{-1, 0}, {1,0}, {0,-1}, {0,1}};
        int n = board.length;
        int m =board[0].length;
        
        String destination = "123450";
        
        String src = "";
        for(int[] b: board)  //how the board looking currently or making the src.
            for(Integer e : b)
                src+=e;
        
        if(src.equals(destination)) return 0; //if the src is already the way we want.
        
        
        
        HashSet<String> vis=new HashSet<>();//this will be my visited set
                                            //(I cant use vis array here thats why using set)
        LinkedList<String>que = new LinkedList<>();
        int level=-1;
        que.add(src);
        
        while(que.size()!=0){
            level++;
            int size=que.size();
            while(size-->0){
                String rs= que.removeFirst(); //removedString
                
                if(rs.equals(destination)) return level;
                if(vis.contains(rs)) continue;
                
                int idx=findZeroIdxInString(rs); //for finding at which idx zero present in string 
                
                int i = idx/m;  //to find the row if we represent the string in board
                int j = idx%m;  //to find the col if we represent the string in board
                
                for(int[]d : dirs){
                    int r = i + d[0];
                    int c = j + d[1];
                    
                    if(r>=0 && c>=0 && r<n && c<m){
                        String str = getNewString(rs,idx,r*m+c);//this will swap and return the new string
                        que.add(str);
                    }
                }
                vis.add(rs);  //making it visited
            }
        }
        
        return -1;
    }
    
    public String getNewString(String str, int i, int j){
        StringBuilder sb = new StringBuilder(str);
        
        char ch = sb.charAt(i);
        sb.replace(i,i+1,sb.charAt(j)+"");
        sb.replace(j,j+1,ch+"");
        
        return sb.toString();
    }
    
    public int findZeroIdxInString(String str){
        for(int i=0;i<str.length();i++){
            int val = str.charAt(i)-'0';
            if(val==0)
                return i;
        }
        return -1;
    }
}
