//***********70. Climbing Stairs
// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Example 1:
// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps

// Example 2:
// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step

// Constraints:
// 1 <= n <= 45
public class ClimbingStairs {
    public int climbStairs(int n) {
        // int[]dp=new int[n+1];
        // int ans=climbStairs_DP(dp,n);
        // return ans;
           int a = 1, b = 1;
           for (int i = 0; i < n; i++) {
               int sum = a + b;
               a = b;
               b = sum;
           }
   
           return a;
       }
       
       public int climbStairs(int[]dp,int tar){
           if(tar<0) return 0;
           if(tar==0) return dp[0]=1;;
           
           if(dp[tar]!=0) return dp[tar];
           int count=0;
           count+=climbStairs(dp,tar-1);
           count+=climbStairs(dp,tar-2);
            return dp[tar]=count;
       }
       public int climbStairs_DP(int[]dp,int tar){
           for(int i=0;i<=tar;i++){
               if(i==0){
                   dp[0]=1;
                   continue;
               }
               int count=0;
            dp[i]=dp[i-1]+((i-2>=0)?dp[i-2]:0);
           }
           return dp[tar];
       }
       
}