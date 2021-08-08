/* 499TheMaze III
There is a ball in a maze with empty spaces and walls. 
The ball can go through empty spaces by rolling up (u), down (d), left (l) or right (r), but it won't stop rolling until hitting a wall. 
When the ball stops, it could choose the next direction.
There is also a hole in this maze. The ball will drop into the hole if it rolls on to the hole.

Given the ball position, the hole position and the maze, find out how the ball could drop into the hole by moving the shortest distance. 
The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the hole (included). 
Output the moving directions by using 'u', 'd', 'l' and 'r'. 
Since there could be several different shortest ways, you should output the lexicographically smallest way. 
If the ball cannot reach the hole, output "impossible".

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. 
You may assume that the borders of the maze are all walls. The ball and the hole coordinates are represented by row and column indexes.

Example 1
Input 1: a maze represented by a 2D array
0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0
Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (0, 1)
Output: "lul"
Explanation: There are two shortest ways for the ball to drop into the hole.
The first way is left -> up -> left, represented by "lul".
The second way is up -> left, represented by 'ul'.
Both ways have shortest distance 6, but the first way is lexicographically smaller because 'l' < 'u'. So the output is "lul".

Example 2
Input 1: a maze represented by a 2D array
0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0
Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (3, 0)
Output: "impossible"
Explanation: The ball cannot reach the hole.

Note:
There is only one ball and one hole in the maze.
Both the ball and hole exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and the width and the height of the maze won't exceed 30.
 */
import java.util.*;
import java.io.*;
public class TheMaze3{
    int min; //min distance to hole
    String minS; //min distance's path string
    int[] hole;
    int[][] maze; 
    int[][] map; //shortest distant traveling from ball to this point
    int[][] dirs = {{0,1},{-1,0},{1,0},{0,-1}}; //r, u, d, l
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        this.min = Integer.MAX_VALUE; 
        this.minS = null;
        this.hole = hole; 
        this.maze = maze; 
        this.map = new int[maze.length][maze[0].length];
        for(int i = 0; i<map.length; i++) Arrays.fill(map[i], Integer.MAX_VALUE); 
        move(ball[0], ball[1], 0, "", -1);
        return (minS==null) ? "impossible" : minS;
    }
    
    private void move(int r, int c, int cnt, String path, int dir){
        if(cnt > min || cnt > map[r][c]) return;
        int rr = r;
        int cc = c;
        if(dir!=-1){
            if(dir==0) path+='r';
            else if(dir==1) path+='u';
            else if(dir==2) path+='d';
            else path+='l';

            while(rr>=0 && rr<maze.length && cc>=0 && cc<maze[0].length && maze[rr][cc]==0){
                map[rr][cc] = Math.min(map[rr][cc], cnt); 
                if(rr==hole[0] && cc==hole[1]){
                    if(cnt==min && path.compareTo(minS)<0){
                        minS=path;
                    }else if(cnt<min){
                        min = cnt; 
                        minS = path; 
                    }
                    return; 
                }
                rr += dirs[dir][0];
                cc += dirs[dir][1];
                cnt++;
            }
            rr -= dirs[dir][0];
            cc -= dirs[dir][1];
            cnt--;
        }
        
        
        for(int i = 0; i<dirs.length; i++){
            if(dir == i || dir == (3-i)) continue;
            int newR = rr + dirs[i][0];
            int newC = cc + dirs[i][1];
            if(newR>=0 && newR<maze.length && newC>=0 && newC<maze[0].length && maze[newR][newC]==0){//can go
                move(rr, cc, cnt, path, i);
            }
        }
    }
}