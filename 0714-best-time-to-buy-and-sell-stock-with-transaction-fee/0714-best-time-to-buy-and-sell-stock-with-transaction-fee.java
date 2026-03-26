class Solution {
    private int solve(int i, int buy, int[] prices, int fee, int[][] dp){
        if(i == prices.length) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];

        if(buy == 1)
            return dp[i][buy] = Math.max(-prices[i] - fee + solve(i+1, 0, prices, fee, dp), solve(i+1, 1, prices, fee, dp));
        else
            return dp[i][buy] = Math.max(prices[i] + solve(i+1, 1, prices, fee, dp), solve(i+1, 0, prices, fee, dp));
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return solve(0, 1, prices, fee, dp);
    }
}