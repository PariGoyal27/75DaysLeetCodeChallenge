class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0, minP = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            minP = Math.min(minP, prices[i-1]);
            profit = Math.max(profit, prices[i] - minP);
        }
        return profit;
    }
}