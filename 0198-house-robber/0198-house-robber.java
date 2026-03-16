class Solution {
    int solve(int i, int[] nums, int sum, int[][] dp){
        if(i >= nums.length){
            return sum;
        }
        if(dp[i][sum] != -1)
            return dp[i][sum];
        int temp = Math.max(solve(i+2, nums, sum+nums[i], dp), solve(i+1, nums, sum, dp));
        return dp[i][sum] = temp;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        int[][] dp = new int[n+1][sum+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return solve(0, nums, 0, dp);
    }
}