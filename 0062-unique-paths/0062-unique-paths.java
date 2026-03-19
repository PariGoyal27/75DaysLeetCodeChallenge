//Recursive + memoization
class Solution {
    int[][] dp = new int[101][101];
    private int solve(int i, int j, int m, int n){
        if(i == m-1 || j == n-1) return 1;
        // if(i > m || j > n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int down = solve(i+1, j, m, n);
        int right = solve(i, j+1, m, n);
        return dp[i][j] = down + right;
    }
    public int uniquePaths(int m, int n) {
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(0, 0, m, n);
    }
}
//Recursive
// class Solution {
//     private int solve(int i, int j, int m, int n){
//         if(i == m-1 || j == n-1) return 1;
//         // if(i > m || j > n) return 0;
//         int down = solve(i+1, j, m, n);
//         int right = solve(i, j+1, m, n);
//         return down + right;
//     }
//     public int uniquePaths(int m, int n) {
//         return solve(0, 0, m, n);
//     }
// }