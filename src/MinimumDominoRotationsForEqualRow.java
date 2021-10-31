//**************1007. Minimum Domino Rotations For Equal Row
// In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino.
// (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
// We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
// Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
// If it cannot be done, return -1.

// Example 1:
// Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
// Output: 2
// Explanation: 
// The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
// If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

// Example 2:
// Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
// Output: -1
// Explanation: 
// In this case, it is not possible to rotate the dominoes to make one row of values equal.

// Constraints:
// 2 <= tops.length <= 2 * 104
// bottoms.length == tops.length
// 1 <= tops[i], bottoms[i] <= 6
public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] tops, int[] bottom) {
        int val1 = tops[0];
        int val2 = bottom[0];
        
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        
        for(int i=0;i<tops.length;i++){
            //count1 denotes the total rotations required to convert the all the tops with val1
            if(count1!=Integer.MAX_VALUE){
                if(val1==tops[i]){
                    //nothing to do
                }
                else if(val1==bottom[i]) count1++;
                else count1=Integer.MAX_VALUE;
            }
            //count2 denotes the total rotations required to convert the all the bottom with val1 
            if(count2!=Integer.MAX_VALUE){
                if(val1==bottom[i]){
                    //nothing to do
                }
                else if(val1==tops[i]) count2++;
                else count2=Integer.MAX_VALUE;
            }
            //count3 denotes the total rotations required to convert the all the tops with val2
            if(count3!=Integer.MAX_VALUE){
                if(val2==tops[i]){
                    //nothing to do
                }
                else if(val2==bottom[i]) count3++;
                else count3=Integer.MAX_VALUE;
            }
            //count4 denotes the total rotations required to convert the all the bottom with val2
            if(count4!=Integer.MAX_VALUE){
                if(val2==bottom[i]){
                    //nothing to do
                }
                else if(val2==tops[i]) count4++;
                else count4=Integer.MAX_VALUE;
            }
        }
        
        int ans = Math.min(count1,Math.min(count2,Math.min(count3,count4)));
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
