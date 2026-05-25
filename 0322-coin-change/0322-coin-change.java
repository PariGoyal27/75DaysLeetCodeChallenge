class Solution {
    int[][] dp;
    private int solve(int i, int[] coins, int amt){
        if(amt == 0) return 0;
        if(amt < 0 || i >= coins.length) return (int)1e9;
        if(dp[i][amt] != -1) return dp[i][amt];

        int take = 1 + solve(i, coins, amt - coins[i]);
        int notTake = solve(i + 1, coins, amt);

        return dp[i][amt] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        int ans = solve(0, coins, amount);
        return ans == (int)1e9 ? -1 : ans;
    }
}
// class Solution {
//     int[] dp;
//     private int solve(int[] coins, int amt){
//         if(amt == 0) return 0;
//         if(amt < 0) return -1;

//         int mini = Integer.MAX_VALUE;
        
//         for(int i = 0; i < coins.length; i++){
//             int res = solve(coins, amt - coins[i]);

//             // Valid Answer
//             if(res >= 0 && res < mini){
//                 mini = res + 1;
//             }
//         }
//         return mini == Integer.MAX_VALUE ? -1 : mini;
//     }
//     public int coinChange(int[] coins, int amount) {
//         return solve(coins, amount);
//     }
// }