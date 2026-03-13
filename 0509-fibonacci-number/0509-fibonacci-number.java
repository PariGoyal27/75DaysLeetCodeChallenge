//Recursion + memoization
// class Solution {
//     int[] dp = new int[31];
//     private int solve(int n){
//         if(n == 0 || n == 1) return n;
//         if(dp[n] != -1) return dp[n];
//         dp[n] = solve(n-1) + solve(n-2);
//         return dp[n];
//     }
//     public int fib(int n) {
//         Arrays.fill(dp, -1);
//         return solve(n);
//     }
// }
//Memoization + dp
class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;
        for(int i = 2; i < n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}