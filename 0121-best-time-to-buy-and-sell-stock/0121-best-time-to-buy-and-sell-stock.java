class Solution {
    public int maxProfit(int[] prices) {
        int min,cost,profit;
        profit = 0; min = prices[0];
        for(int i = 1;i<prices.length;i++)
        {
            cost = prices[i] - min;
            profit = Math.max(profit, cost);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}