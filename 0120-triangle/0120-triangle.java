class Solution {
    int n;
    Integer[][] dp;
    private int solve(List<List<Integer>> triangle, int row, int col){
        // base condition
        if(row == n) return 0;
        if(dp[row][col] != null) return dp[row][col];

        int down = solve(triangle, row + 1, col);
        int right = solve(triangle, row + 1, col + 1);

        return dp[row][col] = triangle.get(row).get(col) + Math.min(down, right);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        dp = new Integer[n][n]; // automatically all null 
        return solve(triangle, 0, 0);
    }
}