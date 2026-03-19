//Recursion + memoization
class Solution {
    int sum = 0;
    private int solve(int[][] grid, int i, int j, int m, int n, int[][] dp){
        if(i == m-1 && j == n-1)
            return grid[i][j];
        if(i >= m || j >= n)
            return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        int down = solve(grid, i+1, j, m, n, dp);
        int right = solve(grid, i, j+1, m, n, dp);
        return dp[i][j] = grid[i][j] + Math.min(down, right);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(grid, 0, 0, m, n, dp);
    }
}
//Recursion
// class Solution {
//     int sum = 0;
//     private int solve(int[][] grid, int i, int j, int m, int n){
//         if(i == m-1 && j == n-1)
//             return grid[i][j];

//         if(i >= m || j >= n)
//             return Integer.MAX_VALUE;
//         int down = solve(grid, i+1, j, m, n);
//         int right = solve(grid, i, j+1, m, n);
//         return grid[i][j] + Math.min(down, right);
//     }
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         return solve(grid, 0, 0, m, n);
//     }
// }