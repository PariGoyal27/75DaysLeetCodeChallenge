//Space Optimization
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int aheadNotBuy = 0, aheadBuy = 0;
        int currNotBuy = 0, currBuy = 0;
        for(int i = n-1; i >= 0; i--){
            currBuy = Math.max(-prices[i] - fee + aheadNotBuy,
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
//     public int maxProfit(int[] prices, int fee) {
//         int n = prices.length;
//         int[][] dp = new int[n+1][2];
//         for(int i = n-1; i >= 0; i--){
//             // for(int buy = 0; buy <= 1; buy++){
//                 // if(buy == 1)
//                     dp[i][1] = Math.max(-prices[i] - fee + dp[i+1][0], dp[i+1][1]);
//                 // else
//                     dp[i][0] = Math.max(prices[i] + dp[i+1][1], dp[i+1][0]);   
//             // }
//         }
//         return dp[0][1];
//     }
// }
//Recursion + Memoization
// class Solution {
//     private int solve(int i, int buy, int[] prices, int fee, int[][] dp){
//         if(i == prices.length) return 0;

//         if(dp[i][buy] != -1) return dp[i][buy];

//         if(buy == 1)
//             return dp[i][buy] = Math.max(-prices[i] - fee + solve(i+1, 0, prices, fee, dp), solve(i+1, 1, prices, fee, dp));
//         else
//             return dp[i][buy] = Math.max(prices[i] + solve(i+1, 1, prices, fee, dp), solve(i+1, 0, prices, fee, dp));
//     }
//     public int maxProfit(int[] prices, int fee) {
//         int n = prices.length;
//         int[][] dp = new int[n+1][2];
//         for(int[] row : dp)
//             Arrays.fill(row, -1);
//         return solve(0, 1, prices, fee, dp);
//     }
// }