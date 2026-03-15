class Solution {
    int[][] dp = new int[101][10001];
    private int solve(int k, int n){
        if(k == 1 || n == 0 || n == 1)
            return n;
        if(dp[k][n] != -1) return dp[k][n];

        int low = 1, high = n;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            int down, up;
            if(dp[k-1][i-1] != -1) down = dp[k-1][i-1];
            else {
                down = solve(k-1, i-1);
                dp[k-1][i-1] = down;
            }
            if(dp[k][n-i] != -1) up = dp[k][n-i];
            else {
                up = solve(k, n-i);
                dp[k][n-i] = up;
            }
            int temp = 1 + Math.max(down, up);
            min = Math.min(min, temp);
        }
        return dp[k][n] = min;
    }
    public int superEggDrop(int k, int n) {
        for(int[] row : dp) Arrays.fill(row, -1);        
        return solve(k, n);
    }
}