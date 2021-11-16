package ownPractice;
//*************668. Kth Smallest Number in Multiplication Table
// Nearly everyone has used the Multiplication Table. The multiplication table of size
// m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed).
// Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.

// Example 1:
// Input: m = 3, n = 3, k = 5
// Output: 3
// Explanation: The 5th smallest number is 3.

// Example 2:
// Input: m = 2, n = 3, k = 6
// Output: 6
// Explanation: The 6th smallest number is 6.

// Constraints:
// 1 <= m, n <= 3 * 104
// 1 <= k <= m * n
// TC : O(mlog(m*n));
// SC : O(1)
public class KthSmallestNumberInMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        int range = m*n;
        int low = 1;
        int high = range;
        
        while(low<high){
            int mid = low + (high - low)/2;
            int cnt = getCountOfTotalNumbersThatAreBelowHigh(mid,m,n);
            if(cnt>=k) high = mid;
            else low = mid+1;
        } 
        
        return low;
    }
    
    //this is the main logic and the tricky part.
    public int getCountOfTotalNumbersThatAreBelowHigh(int num,int row,int col){
        int count = 0;
        for(int i=1;i<=row;i++)
            count+= Math.min(num/i,col);
        
        return count;
    }
}
