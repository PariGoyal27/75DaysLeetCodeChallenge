class Solution {
    int[][] dp;
    private int solve(int i, int amt, int[] coins){
        if(amt == 0) return 1;
        if(i >= coins.length || amt < 0) return 0;

        if(dp[i][amt] != -1) return dp[i][amt];

        // take or not take
        int take = solve(i, amt - coins[i], coins);
        int notTake = solve(i + 1, amt, coins);

        return dp[i][amt] = take + notTake;
    }
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, amount, coins);
    }
}