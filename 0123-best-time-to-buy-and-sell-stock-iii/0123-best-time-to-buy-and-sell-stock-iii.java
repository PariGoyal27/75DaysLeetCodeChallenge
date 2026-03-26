class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int i = n-1; i >= 0; i--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= 2; cap++){
                    if(buy == 1){
                        dp[i][buy][cap] = Math.max(-prices[i] + dp[i+1][0][cap], 
                                0 + dp[i+1][1][cap]);
                    }else{ 
                        dp[i][buy][cap] = Math.max(prices[i] + dp[i+1][1][cap-1], 
                                0 + dp[i+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}
//Recursion + Memoization
// class Solution {
//     private int solve(int i, int buy, int cap, int[] prices, int[][][] dp){
//         if(i == prices.length || cap == 0) return 0;
//         if(dp[i][buy][cap] != -1) return dp[i][buy][cap];

//         int profit = 0;
//         if(buy == 1){//Can buy
//             profit = Math.max(-prices[i] + solve(i+1, 0, cap, prices, dp), 
//                      0 + solve(i+1, 1, cap, prices, dp));
//         }else{ // can't buy only sell
//             profit = Math.max(prices[i] + solve(i+1, 1, cap-1, prices, dp), 
//                      0 + solve(i+1, 0, cap, prices, dp));
//         }
//         return dp[i][buy][cap] = profit;
//     }
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][][] dp = new int[n+1][2][3];
//         for(int[][] mat : dp)
//             for(int[] row : mat)
//                 Arrays.fill(row, -1);
//         return solve(0, 1, 2, prices, dp);
//     }
// }