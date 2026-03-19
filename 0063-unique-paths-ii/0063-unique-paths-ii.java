//Bottom up
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = 1; 
        
        //First Column
        for(int i = 1; i < m; i++){
            if(obstacleGrid[i][0] == 0)
                dp[i][0] = dp[i-1][0];
            else {
                break;
            }
        }
        //First Row
        for(int j = 1; j < n; j++){
            if(obstacleGrid[0][j] == 0)
                dp[0][j] = dp[0][j-1];
            else
                break;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1) 
                    dp[i][j] = 0;
                else 
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
//Recursion + Memoization
// class Solution {
//     int[][] dp = new int[101][101];
//     private int solve(int[][] grid, int i, int j, int m, int n){
//         if(i == m || j == n) return 0;
//         if(grid[i][j] == 1) return 0;
//         if(i == m-1 && j == n-1) return 1;

//         if(dp[i][j] != -1) return dp[i][j];
//         int down = solve(grid, i+1, j, m, n);
//         int right = solve(grid, i, j+1, m, n);
//         return dp[i][j] = down + right;
//     }
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         for(int[] row : dp) Arrays.fill(row,-1);
//         return solve(obstacleGrid, 0, 0, m, n);
//     }
// }
//Recursion
// class Solution {
//     private int solve(int[][] grid, int i, int j, int m, int n){
//         if(i == m || j == n) return 0;
//         if(grid[i][j] == 1) return 0;
//         if(i == m-1 && j == n-1) return 1;

//         int down = solve(grid, i+1, j, m, n);
//         int right = solve(grid, i, j+1, m, n);
//         return down + right;
//     }
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         return solve(obstacleGrid, 0, 0, m, n);
//     }
// }