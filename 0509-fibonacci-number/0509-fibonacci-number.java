class Solution {
    int[] dp = new int[31];
    private int solve(int n){
        if(n == 0 || n == 1) return n;
        if(dp[n] != -1) return dp[n];
        dp[n] = solve(n-1) + solve(n-2);
        return dp[n];
    }
    public int fib(int n) {
        Arrays.fill(dp, -1);
        return solve(n);
    }
}