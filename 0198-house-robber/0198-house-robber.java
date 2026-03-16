class Solution {
    // int solve(int n, int[] nums, int[] dp){
    //     if(n <= 0){
    //         return 0;
    //     }
    //     if(n == 1) return nums[0];
    //     if(dp[n] != -1)
    //         return dp[n];
        
    //     int pick = nums[n-1] + solve(n-2, nums, dp);
    //     int notPick = solve(n-1, nums, dp);
    //     return dp[n] = Math.max(pick, notPick);
    // }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for(int i = 3; i < n+1; i++){
            int pick = nums[i-1] + dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n];
    }
}