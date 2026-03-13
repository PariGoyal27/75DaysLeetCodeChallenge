class Solution {
    int[] dp = new int[46];
    private int solve(int n){
        if(n == 0){
            return 1;
        }else if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        dp[n] = solve(n-1) + solve(n-2);
        return dp[n];
    }
    public int climbStairs(int n) {
        Arrays.fill(dp, -1);
        return solve(n);
    }
}