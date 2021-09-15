package ownPractice;
//****************264. Ugly Number II
// An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
// Given an integer n, return the nth ugly number.

// Example 1:
// Input: n = 10
// Output: 12
// Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.

// Example 2:
// Input: n = 1
// Output: 1
// Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.

// Constraints:
// 1 <= n <= 1690
public class UglyNumbers2 {
    public int nthUglyNumber(int n) {
        if(n<=6) return n;
        
        int[]dp = new int[n];
        dp[0]=1;
        int twoPointer=0, threePointer=0, fivePointer=0;
        int[]twoRes=new int[2];
        int[]threeRes=new int[2];
        int[]fiveRes=new int[2];
        for(int i=1;i<n;i++){
            twoRes=findRes(dp,twoPointer,2,i);
            threeRes=findRes(dp,threePointer,3,i);
            fiveRes=findRes(dp,fivePointer,5,i);
            
            twoPointer=twoRes[1];
            threePointer=threeRes[1];
            fivePointer=fiveRes[1];
            
            if(twoRes[0]<=Math.min(threeRes[0],fiveRes[0]) ){
                dp[i]=twoRes[0];
                // System.out.print(twoRes[1]+" two ");
                twoPointer++;
                
            }
            else if(threeRes[0]<=Math.min(twoRes[0],fiveRes[0])){
                dp[i]=threeRes[0];
                // System.out.print(threeRes[1]+" three ");
                threePointer++;
            }
            else{
                dp[i]=fiveRes[0];
                // System.out.print(fiveRes[1]+" five ");
                fivePointer++;
            }
            // System.out.println(dp[i]);
        }
        
        return dp[n-1];
    }
    
    public int[] findRes(int[]dp,int pointer,int factor,int idx){
        int res= dp[pointer]*factor;
        while(res == dp[idx-1]){
            res = dp[++pointer]*factor;
        }
        
        return new int[]{res,pointer};
    }
}
