//Space Optimization
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int aheadNotBuy = 0, aheadBuy = 0;
        int currNotBuy = 0, currBuy = 0;
        for(int i = n-1; i >= 0; i--){
            currBuy = Math.max(-prices[i] + aheadNotBuy,
                                aheadBuy);
            currNotBuy = Math.max(prices[i] + aheadBuy,
                            aheadNotBuy);
            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }
        return aheadBuy;
    }
}

//Tabulation
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][] dp = new int[n+1][2];
//         for(int i = n-1; i >= 0; i--){
//             for(int buy = 0; buy <= 1; buy++){
//                 int profit = 0;
//                 if(buy == 1){//Can buy
//                     profit = Math.max(-prices[i] + dp[i+1][0],
//                                         0 + dp[i+1][1]);
//                 }else{ // can't buy only sell
//                     profit = Math.max(prices[i] + dp[i+1][1],
//                                     0 + dp[i+1][0]);
//                 }
//                 dp[i][buy] = profit;
//             }
//         }
//         return dp[0][1];
//     }
// }

//Recursion + Memoization
// class Solution {
//     private int solve(int i, int buy, int[] prices, int[][] dp){
//         if(i == prices.length) return 0;
//         if(dp[i][buy] != -1) return dp[i][buy];

//         int profit = 0;
//         if(buy == 1){//Can buy
//             int buying = -prices[i] + solve(i+1, 0, prices, dp);
//             int notBuy = 0 + solve(i+1, 1, prices, dp);
//             profit = Math.max(buying, notBuy);
//         }else{ // can't buy only sell
//             int sell = prices[i] + solve(i+1, 1, prices, dp);
//             int notSell = 0 + solve(i+1, 0, prices, dp);
//             profit = Math.max(sell, notSell);
//         }
//         return dp[i][buy] = profit;
//     }
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][] dp = new int[n+1][2];
//         for(int[] row : dp)
//             Arrays.fill(row, -1);
//         return solve(0, 1, prices, dp);
//     }
// }