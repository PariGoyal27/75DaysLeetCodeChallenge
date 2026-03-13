// Recursion + memoization
// class Solution {
//     int[] dp = new int[46];
//     private int solve(int n){
//         if(n == 0){
//             return 1;
//         }else if(n < 0) return 0;
//         if(dp[n] != -1) return dp[n];
//         dp[n] = solve(n-1) + solve(n-2);
//         return dp[n];
//     }
//     public int climbStairs(int n) {
//         Arrays.fill(dp, -1);
//         return solve(n);
//     }
// }

//memoization dp
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for(int i = 2; i < n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}