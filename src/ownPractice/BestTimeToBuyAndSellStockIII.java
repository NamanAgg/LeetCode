package ownPractice;
//******************123. Best Time to Buy and Sell Stock III
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You may complete at most two transactions.
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// Example 1:
// Input: prices = [3,3,5,0,0,3,1,4]
// Output: 6
// Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
// Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

// Example 2:
// Input: prices = [1,2,3,4,5]
// Output: 4
// Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
// Note that you cannot buy on day 1, buy on day 2 and sell them later,
// as you are engaging multiple transactions at the same time. You must sell before buying again.

// Example 3:
// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.

// Example 4:
// Input: prices = [1]
// Output: 0

// Constraints:
// 1 <= prices.length <= 105
// 0 <= prices[i] <= 105
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][]dp = new int[n][2][2];
        for(int[][]d:dp)
            for(int[]e:d)
                Arrays.fill(e,-1);
        
        return maxProfit(prices,0,0,0,dp);
    }
    
    public int maxProfit(int[]prices,int day,int bought,int number,int[][][]dp){
        if(day>=prices.length || number>=2) return 0;
        
        if(dp[day][bought][number]!=-1) return dp[day][bought][number];
        
        int myAns = Integer.MIN_VALUE;
        
        if(bought==0){ //buy   
            myAns = Math.max(maxProfit(prices,day+1,1,number,dp)-prices[day],maxProfit(prices,day+1,bought,number,dp));
        }
        else{ //sell
            myAns = Math.max(prices[day]+maxProfit(prices,day+1,0,number+1,dp),maxProfit(prices,day+1,bought,number,dp));
        }
        
        return dp[day][bought][number] = myAns;
    }
}
