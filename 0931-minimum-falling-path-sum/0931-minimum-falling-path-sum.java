class Solution {
    int n;
    int[][] dp;
    private int solve(int[][] matrix, int i, int j){
        if(j < 0 || j >= n) return (int)1e9;
        if(i == n-1) return matrix[i][j];

        if(dp[i][j] != (int)1e9) return dp[i][j];

        int left = solve(matrix, i + 1, j - 1);
        int down = solve(matrix, i + 1, j);
        int right = solve(matrix, i + 1, j + 1);

        return dp[i][j] = matrix[i][j] + Math.min(left, Math.min(down, right));
    }
    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        int min = (int)1e9;
        dp = new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row, (int)1e9);
        }

        for(int i = 0; i < n; i++){
            min = Math.min(min, solve(matrix, 0, i));
        }
        return min;
    }
}