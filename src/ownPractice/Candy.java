package ownPractice;
//*******************135. Candy
// There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
// You are giving candies to these children subjected to the following requirements:
// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
// Return the minimum number of candies you need to have to distribute the candies to the children.

// Example 1:
// Input: ratings = [1,0,2]
// Output: 5
// Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

// Example 2:
// Input: ratings = [1,2,2]
// Output: 4
// Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
// The third child gets 1 candy because it satisfies the above two conditions.

// Constraints:
// n == ratings.length
// 1 <= n <= 2 * 104
// 0 <= ratings[i] <= 2 * 104

// https://www.youtube.com/watch?v=h6_lIwZYHQw
// solution link video for better explanation.

// first we have to make twoa rrays where we will fill only considering left nbrs
// and then another only considering right nbrs
// then the end result will be the max(left[i],right[i])
public class Candy {
    public int candy(int[] ratings) {
        int[]left=new int[ratings.length];
        int[]right=new int[ratings.length];
        
        fillConsideringLeftElements(ratings,left);
        fillConsideringRightElements(ratings,right);
        int count=0;
        for(int i = 0;i<ratings.length;i++){
            count+=Math.max(left[i],right[i]);
        }
        
        return count;
        
    }
    
    public void fillConsideringLeftElements(int[]ratings,int[]left){        
        left[0]=1;
        for(int i =1;i<left.length;i++){
            if(ratings[i-1]<ratings[i])
                left[i]=left[i-1]+1;
            else left[i]=1;
        }
    }
    
    public void fillConsideringRightElements(int[]ratings,int[]right){
        right[right.length-1]=1;
        for(int i =right.length-2;i>=0;i--){
            if(ratings[i+1]<ratings[i])
                right[i]=right[i+1]+1;
            else right[i]=1;
        }
    }    
}