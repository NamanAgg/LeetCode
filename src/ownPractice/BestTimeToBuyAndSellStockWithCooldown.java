//************309. Best Time to Buy and Sell Stock with Cooldown
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You may complete as many transactions as you like 
// (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
// After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// Example 1:
// Input: prices = [1,2,3,0,2]
// Output: 3
// Explanation: transactions = [buy, sell, cooldown, buy, sell]

// Example 2:
// Input: prices = [1]
// Output: 0

// Constraints:
// 1 <= prices.length <= 5000
// 0 <= prices[i] <= 1000
public class BestTimeToBuyAndSellStockWithCooldown{
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++)
            Arrays.fill(dp[i], -1);
        
        return maxProfit(prices, 0, 0, dp);
    }
    
    public int maxProfit(int[] prices, int day, int bought, int[][] dp) {
        if(day >= prices.length)
            return 0;
        
        if(dp[day][bought] != -1)
            return dp[day][bought];
        
        if(bought == 0) { // buy
            return dp[day][bought] = Math.max(maxProfit(prices,day+1,1,dp)-prices[day],maxProfit(prices,day+1,bought,dp));
        }
        else { // sell
            return dp[day][bought] = Math.max(prices[day]+maxProfit(prices,day+2,0,dp),maxProfit(prices,day+1,bought,dp));
        }
    }
}
