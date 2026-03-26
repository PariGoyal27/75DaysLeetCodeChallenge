class Solution {
    int profit = 0;
    private int solve(int i, int canBuy, int[] prices, int[][] dp){
        if(i == prices.length) return 0;
        if(dp[i][canBuy] != -1) return dp[i][canBuy];
        if(canBuy == 1){//Can buy
            int buy = -prices[i] + solve(i+1, 0, prices, dp);
            int notBuy = 0 + solve(i+1, 1, prices, dp);
            profit = Math.max(buy, notBuy);
        }else{ // can't buy only sell
            int sell = prices[i] + solve(i+1, 1, prices, dp);
            int notSell = 0 + solve(i+1, 0, prices, dp);
            profit = Math.max(sell, notSell);
        }
        return dp[i][canBuy] = profit;
    }
    public int maxProfit(int[] prices) {
        profit = 0;
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return solve(0, 1, prices, dp);
    }
}