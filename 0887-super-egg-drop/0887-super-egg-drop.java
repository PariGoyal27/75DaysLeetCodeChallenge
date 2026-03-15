class Solution {
    int[][] dp = new int[101][10001];
    private int solve(int k, int n){
        if(k == 1 || n == 0 || n == 1)
            return n;
        if(dp[k][n] != -1) return dp[k][n];
        
        int low = 1, high = n;
        int min = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low + high) / 2;

            int down = (dp[k-1][mid-1] != -1) ? dp[k-1][mid-1] : solve(k-1, mid-1);
            int up   = (dp[k][n-mid] != -1) ? dp[k][n-mid] : solve(k, n-mid);

            int temp = 1 + Math.max(down, up);
            min = Math.min(min, temp);

            if(down > up)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return dp[k][n] = min;
        return dp[k][n] = min;
    }
    public int superEggDrop(int k, int n) {
        for(int[] row : dp) Arrays.fill(row, -1);        
        return solve(k, n);
    }
}