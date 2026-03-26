//Space Optimization
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][k+1];
        int[][] curr = new int[2][k+1];
        for(int i = n-1; i >= 0; i--){
            // for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= k; cap++){
                    // if(buy == 1){
                        curr[1][cap] = Math.max(-prices[i] + ahead[0][cap], 
                                0 + ahead[1][cap]);
                    // }else{ 
                        curr[0][cap] = Math.max(prices[i] + ahead[1][cap-1], 
                                0 + ahead[0][cap]);
                    // }
                }
            // }
            for(int j = 0; j < 2; j++){
                System.arraycopy(curr[j], 0, ahead[j], 0, k+1);
            }
        }
        return ahead[1][k];
    }
}        
//Tabulation
// class Solution {
//     public int maxProfit(int k, int[] prices) {
//         int n = prices.length;
//         int[][][] dp = new int[n+1][2][k+1];
//         for(int i = n-1; i >= 0; i--){
//             // for(int buy = 0; buy <= 1; buy++){
//                 for(int cap = 1; cap <= k; cap++){
//                     // if(buy == 1)
//                         dp[i][1][cap] = Math.max(-prices[i] + dp[i+1][0][cap], dp[i+1][1][cap]);
//                     // else
//                         dp[i][0][cap] = Math.max(prices[i] + dp[i+1][1][cap-1], dp[i+1][0][cap]);
//                 }
//             // }
//         }
//         return dp[0][1][k];
//     }
// }
//memoization
// class Solution{
//     public int maxProfit(int k, int[] prices){
//         int n = prices.length;
//         int[][][] dp = new int[n + 1][2][k + 1];
//         for(int[][] mat : dp){
//             for(int[] row : mat){
//                 Arrays.fill(row, -1);
//             }
//         }
//         return solve(0, 1, k, n, prices, dp);
//     }
//     public int solve(int ind, int buy, int k, int n, int[] prices, int[][][] dp){
//         if(ind == n || k == 0) return 0;
//         if(dp[ind][buy][k] != -1) return dp[ind][buy][k];
//         int profit = 0;
//         if(buy == 1){
//             profit = Math.max(-prices[ind] + solve(ind + 1, 0, k, n, prices, dp), 0 + solve(ind + 1, 1, k, n, prices, dp));
//         }else{
//             profit = Math.max(prices[ind] + solve(ind + 1, 1, k - 1, n, prices, dp), 0 + solve(ind + 1, 0, k, n, prices, dp));
//         }
//         dp[ind][buy][k] = profit;
//         return profit;
//     }
// }


//recursive
// class Solution {
//     public int maxProfit(int k, int[] prices) {
//         int n = prices.length;
//         return solve(0, 1, k, n, prices);
//     }
//     public int solve(int ind, int buy, int k, int n, int[] prices){
//         if(ind == n || k == 0) return 0;
//         int profit = 0;
//         if(buy == 1){
//             profit = Math.max(-prices[ind] + solve(ind + 1, 0, k, n, prices), 0 + solve(ind + 1, 1, k, n, prices));
//         }else{
//             profit = Math.max(prices[ind] + solve(ind + 1, 1, k - 1, n, prices), 0 + solve(ind + 1, 0, k, n, prices));
//         }
//         return profit;
//     }
// }