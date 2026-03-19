//Bottom up
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        dp[0][0] = matrix[0][0];
        
        //first row
        for(int i = 1; i < n; i++){
            dp[0][i] = matrix[0][i]; //As we can start with any column
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                int left = j > 0 ? dp[i-1][j-1] : Integer.MAX_VALUE;
                int up = dp[i-1][j];
                int right = j < n-1 ? dp[i-1][j+1] : Integer.MAX_VALUE;
                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(left, right));
            }
        }
        int min = dp[n-1][0];
        for(int j = 1; j < n; j++){
            min = Math.min(min, dp[n-1][j]);// min of the last row
        }
        return min;
    }
}
//Recursion + Memoization 
// class Solution {
//     private int solve(int[][] mat, int i, int j, int[][] dp){
//         int n = mat.length;
//         // if(j < 0 || j >= n)
//         //     return Integer.MAX_VALUE;
//         if(i == n-1)
//             return mat[i][j];
//         if(dp[i][j] != -1) return dp[i][j];

//         int left = Integer.MAX_VALUE;
//         if(j > 0)
//             left = solve(mat, i+1, j-1, dp);

//         int down = solve(mat, i+1, j, dp);
//         int right = Integer.MAX_VALUE;
//         if(j < n-1)
//             right = solve(mat, i+1, j+1, dp);

//         return dp[i][j] = mat[i][j] + Math.min(left, Math.min(down, right));
//     }
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         int min = Integer.MAX_VALUE;
//         int[][] dp = new int[n][n];
//         for(int[] row : dp) Arrays.fill(row, -1);
//         for(int j = 0; j < n; j++){
//             min = Math.min(min, solve(matrix, 0, j, dp));
//         }
//         return min;
//     }
// }
//Recursion
// class Solution {
//     private int solve(int[][] mat, int i, int j, int n){
//         if(j < 0 || j >= n)
//             return Integer.MAX_VALUE;
//         if(i == n-1)
//             return mat[i][j];

//         int left = solve(mat, i+1, j-1, n);
//         int down = solve(mat, i+1, j, n);
//         int right = solve(mat, i+1, j+1, n);

//         return mat[i][j] + Math.min(left, Math.min(down, right));
//     }
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         int min = Integer.MAX_VALUE;
//         for(int j = 0; j < n; j++){
//             min = Math.min(min, solve(matrix, 0, j, n));
//         }
//         return min;
//     }
// }