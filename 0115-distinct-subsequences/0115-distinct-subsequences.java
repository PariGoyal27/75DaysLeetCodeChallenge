// space optimization
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(n > m) return 0;

        int[] prev = new int[n+1];
        // int[] curr = new int[n+1];
        // curr[0] = 1;
        prev[0] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = n; j >= 1; j--){ // for(int j = 1; j <= n; j++)
                if(s.charAt(i-1) == t.charAt(j-1)){
                    prev[j] = prev[j] + prev[j-1]; // curr[j] = prev[j] + prev[j-1];
                }else{
                    prev[j] = prev[j]; // curr[j] = prev[j]
                }
            }
            // for(int j = 1; j <= n; j++){
            //     prev[j] = curr[j];
            // }
        }
        return prev[n];
    }
}
// tabulation
// class Solution {
//     public int numDistinct(String s, String t) {
//         int m = s.length();
//         int n = t.length();
//         if(n > m) return 0;

//         int[][] dp = new int[m + 1][n + 1];
//         for(int i = 0; i <= m; i++){
//             dp[i][0] = 1;
//         }
//         for(int i = 1; i <= m; i++){
//             for(int j = 1; j <= n; j++){
//                 if(s.charAt(i-1) == t.charAt(j-1)){
//                     dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
//                 }else{
//                     dp[i][j] = dp[i-1][j];
//                 }
//             }
//         }
//         return dp[m][n];
//     }
// }
// recursion + memoization
// class Solution {
//     int[][] dp;
//     private int solve(int i, int j, String s, String t){
//         if(j < 0){
//             return 1;
//         }
//         if(i < 0){
//             return 0;
//         }
//         if(dp[i][j] != -1) return dp[i][j];

//         if(s.charAt(i) == t.charAt(j)){
//             return dp[i][j] = solve(i-1, j-1, s, t) + solve(i-1, j, s, t);
//         }else{
//             return dp[i][j] = solve(i-1, j, s, t);
//         }
//     }
//     public int numDistinct(String s, String t) {
//         int n1 = s.length();
//         int n2 = t.length();
//         if(n2 > n1) return 0;
//         dp = new int[n1][n2];
//         for(int[] row : dp)
//             Arrays.fill(row, -1);
//         return solve(n1-1, n2-1, s, t);
//     }
// }