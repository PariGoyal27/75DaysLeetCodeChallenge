class Solution {
    int solve(int n, int[] nums, int[] dp){
        if(n <= 0){
            return 0;
        }
        if(n == 1) return nums[0];
        if(dp[n] != -1)
            return dp[n];
        
        int pick = nums[n-1] + solve(n-2, nums, dp);
        int notPick = solve(n-1, nums, dp);
        return dp[n] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, nums, dp);
    }
}