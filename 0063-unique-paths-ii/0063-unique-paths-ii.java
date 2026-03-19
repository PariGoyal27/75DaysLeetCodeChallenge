class Solution {
    int[][] dp = new int[101][101];
    private int solve(int[][] grid, int i, int j, int m, int n){
        if(i == m || j == n) return 0;
        if(grid[i][j] == 1) return 0;
        if(i == m-1 && j == n-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int down = solve(grid, i+1, j, m, n);
        int right = solve(grid, i, j+1, m, n);
        return dp[i][j] = down + right;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(obstacleGrid, 0, 0, m, n);
    }
}