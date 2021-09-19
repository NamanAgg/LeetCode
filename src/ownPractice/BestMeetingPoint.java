package ownPractice;
//**************** Best Meeting Point
// A group of two or more people wants to meet and minimize the total travel distance.
// You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
// The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

// Example 1:
// Input:
// [[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]
// Output:
// 6

// Explanation:
// The point `(0,2)` is an ideal meeting point, as the total travel distance of `2 + 2 + 2 = 6` is minimal. So return `6`.

// Example 2:
// Input:
// [[1,1,0,0,1],[1,0,1,0,0],[0,0,1,0,1]]
// Output:
// 14
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        ArrayList<Integer>xcoord=new ArrayList<>();
      ArrayList<Integer>ycoord=new ArrayList<>();
      
      //traversing row wise for sorting xcoordinates
      for(int i=0;i<grid.length;i++)
          for(int j=0;j<grid[0].length;j++)
              if(grid[i][j]==1)
                  xcoord.add(i);
      
      //traversing column wise for sorting ycoordinates
      for(int j=0;j<grid[0].length;j++)
          for(int i=0;i<grid.length;i++)
              if(grid[i][j]==1)
                  ycoord.add(j);
      
      int x  = xcoord.get(xcoord.size()/2);
      int y  = ycoord.get(ycoord.size()/2);
      
      int sum =0;
      
      for(int i=0;i<grid.length;i++)
          for(int j=0;j<grid[0].length;j++)
              if(grid[i][j]==1)
                  sum+= Math.abs(i-x) + Math.abs(j-y);
              
      
      return sum;
  }
}
