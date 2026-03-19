//Bottom Up
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m+1; i++){
            for(int j = 0; j < n+1; j++){
                dp[i][j] = 1;
            }
        }
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}

//Recursive + memoization
// class Solution {
//     int[][] dp = new int[101][101];
//     private int solve(int i, int j, int m, int n){
//         if(i == m-1 || j == n-1) return 1;
//         if(dp[i][j] != -1) return dp[i][j];
//         int down = solve(i+1, j, m, n);
//         int right = solve(i, j+1, m, n);
//         return dp[i][j] = down + right;
//     }
//     public int uniquePaths(int m, int n) {
//         for(int[] row : dp) Arrays.fill(row, -1);
//         return solve(0, 0, m, n);
//     }
// }
//Recursive
// class Solution {
//     private int solve(int i, int j, int m, int n){
//         if(i == m-1 || j == n-1) return 1;
//         int down = solve(i+1, j, m, n);
//         int right = solve(i, j+1, m, n);
//         return down + right;
//     }
//     public int uniquePaths(int m, int n) {
//         return solve(0, 0, m, n);
//     }
// }