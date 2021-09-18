//****************849. Maximize Distance to Closest Person
// You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat,
// and seats[i] = 0 represents that the ith seat is empty (0-indexed).
// There is at least one empty seat, and at least one person sitting.
// Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 
// Return that maximum distance to the closest person.

// Example 1:
// Input: seats = [1,0,0,0,1,0,1]
// Output: 2
// Explanation: 
// If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
// If Alex sits in any other open seat, the closest person has distance 1.
// Thus, the maximum distance to the closest person is 2.

// Example 2:
// Input: seats = [1,0,0,0]
// Output: 3
// Explanation: 
// If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
// This is the maximum distance possible, so the answer is 3.

// Example 3:
// Input: seats = [0,1]
// Output: 1

// Constraints:
// 2 <= seats.length <= 2 * 104
// seats[i] is 0 or 1.
// At least one seat is empty.
// At least one seat is occupied.
public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int maxDistance=0; //gmax: globall maximum
          int tmax=0; //tmax:temp maximum
          int f1idx=-1; //first 1 idx
          int lidx=-1;  //last 1 idx
          boolean flag=false;
          
          for(int i=0;i<seats.length;i++){
              int val=seats[i];
              if(val==0){
                  tmax++;
              }else{
                  if(!flag){
                      flag=true;
                      f1idx=i;
                  }
                  lidx=i;
                  maxDistance=Math.max(maxDistance,tmax);
                  tmax=0;
              }
          }
          int c1=(maxDistance+1)/2; //candidate 1
          int c2=f1idx;      //candidate 2
          int c3=seats.length-1-lidx;  //candidate 3
          
          return Math.max(c1,Math.max(c2,c3)); 
      }
}
